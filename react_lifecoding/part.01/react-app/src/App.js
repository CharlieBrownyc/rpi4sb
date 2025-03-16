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

function Update(props){
  console.log('Update: 1 step');
  const [title, setTitle] = useState(props.title);
  const [body, setBody] = useState(props.body);
  return (
    <article>
      <h2>Update article</h2>
      <form onSubmit={event=>{
        event.preventDefault();
        console.log('Update: 2 step');        
        const title = event.target.title.value;
        const body = event.target.body.value;
        props.onUpdate(title, body);
      }}>
        <p><input type="text" name="title" placeholder="Title" value={title} onChange={event=>{
          console.log(event.target.value);
          setTitle(event.target.value);
        }}/></p>
        <p><textarea name="body" placeholder="Body" value={body} onChange={event=>{
          console.log(event.target.value);
          setBody(event.target.value);
        }}></textarea></p>
        <p><input type="submit" value='Update'></input></p>
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
  let contextControl = null;
  console.log('App:id=',id);
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
    contextControl = <>
      <li><a href={'/update/'+id} onClick={event=>{
        event.preventDefault();
        setMode('UPDATE');      
      }}>Update</a></li>
      <li><input type='button' value='Delete' onClick={()=>{
        // console.log('Delete');
        // const newTopics = topics.filter(t=>t.id!==id);
        const newTopics = []
        for(let i=0; i<topics.length; i++){
          if(topics[i].id!== id){
            newTopics.push(topics[i]);
          }
        }
        setTopics(newTopics);
        setMode('WELCOME');
        // setId(null);
      }}></input></li>
    </>

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
  } else if(mode === 'UPDATE') {
    let title, body = null;
    for(let i = 0; i <topics.length; i++) {
      console.log(topics[i].id, id);
      if(topics[i].id === id) {
        title = topics[i].title;
        body = topics[i].body;
      }
    }

    content = <Update title={title} body={body} onUpdate={(title, body)=>{
      console.log('onUpdate:', title, body);
      const newTopics = [...topics];
      const updatedTopic = {id:id, title:title, body:body}
      // newTopics[newTopics.findIndex(t=>t.id===id)] = updatedTopic;
      // newTopics.findIndex(t=>{console.log('['+t.id+']t.id===id',t.id===id)});
      for(let i=0; i<newTopics.length; i++){
        if(newTopics[i].id === id){
          newTopics[i] = updatedTopic;
          break;
        }
      }
      setTopics(newTopics);
      setMode('READ');      
    }}></Update>
  }

  return (
    <div>
      <Header title="WEB2" onChangeMode={()=>{
        setMode('WELCOME');
      }}></Header>
      <Nav topics={topics} onChangeMode={(_id)=>{
        setMode('READ');
        setId(_id);
      }}></Nav>
      {content}
      <ul>
        <li><a href='/create/' onClick={event=>{
          event.preventDefault();
          setMode('CREATE');
        }}>Create</a></li>
        {contextControl}
      </ul>
    </div>
  );
}

export default App;
