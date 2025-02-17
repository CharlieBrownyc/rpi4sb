import logo from './logo.svg';
import './App.css';
import {useState} from 'react';

function Header(props){
  // console.log('Header:props', props);
  return (
    <header>
      <h1><a href="/" onClick={(event)=>{        
        event.preventDefault();
        props.onChangeMode();
      }}>{props.title}</a></h1>
    </header>
  )
}

function Nav(props){
  // console.log('Nav:props', props.topics);
  const lis = []
  for(let i=0; i<props.topics.length; i++){
    let t = props.topics[i];
    lis.push(<li key={t.id}><a id={t.id} href={'/read/'+t.id} onClick={event=>{
      event.preventDefault();
      props.onChangeMode(Number(event.target.id));
    }}>{t.title}</a></li>);
  }
  return (
    <nav>
      <ol>
        {lis}
      </ol>
    </nav>
  )
}

function Article(props){
  return (
    <div>
      <article>
        <h2>{props.title}</h2>
        {props.body}
      </article>
    </div>
  )
}

function Create(props){
  console.log('1 step');

  return (
    <article>
      <h2>Create new article</h2>
      <form onSubmit={event=>{
        console.log('2 step');
        event.preventDefault();
        const title = event.target.title.value;
        const body = event.target.body.value;
        props.onCreate(title, body);
      }}>
        <p><input type="text" name="title" placeholder="Title"/></p>
        <p><textarea name="body" placeholder="Body"></textarea></p>
        <p><input type="submit" value='Create'></input></p>
      </form>
    </article>
  )
}

function App() {
  const [mode, setMode] = useState('WELCOME');
  const [id, setId] = useState(null);
  const [nextId, setNextId] = useState(4);
  const [topics, setTopics] = useState([
    {id: 1, title: 'HTML', body: 'HTML is HyperText Markup Language'},
    {id: 2, title: 'CSS', body: 'CSS is Cascading Style Sheets'},
    {id: 3, title: 'JavaScript', body: 'JavaScript is a programming language'}
  ]);
  let content = null;

  if(mode === 'WELCOME') {
    content = <Article title="Welcome" body="Hello, Web"></Article>
  } else if(mode === 'READ') {
    let title, body = null;
    for(let i = 0; i <topics.length; i++) {
      console.log(topics[i].id, id);
      if(topics[i].id === id) {
        title = topics[i].title;
        body = topics[i].body;
      }
    }
    content = <Article title={title} body={body}></Article>
  } else if(mode === 'CREATE') {
    content = <Create onCreate={(_title, _body)=>{
      console.log('3 step');
      const newTopic = {id:nextId, title: _title, body: _body}
      const newTopics = [...topics]
      newTopics.push(newTopic);
      setTopics(newTopics);
      setMode('READ');
      setId(nextId);
      setNextId(nextId+1);
    }}></Create>
  }

  return (
    <div>
      <Header title="WEB" onChangeMode={()=>{
        setMode('WELCOME');
      }}></Header>
      <Nav topics={topics} onChangeMode={(_id)=>{
        setMode('READ');
        setId(_id);
      }}></Nav>
      {content}
      <a href='/create/' onClick={event=>{
        event.preventDefault();
        setMode('CREATE');
      }}>Create</a>
    </div>
  );
}

export default App;
