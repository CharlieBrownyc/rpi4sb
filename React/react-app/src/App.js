import logo from './logo.svg';
import './App.css';

function Header(props){
  console.log('props', props.title);
  return (
    <div>
      <header>
        <h1><a href='/'>{props.title}</a></h1>
      </header>
    </div>
  )
}

function Nav(){
  return (
    <nav>
      <ol>
        <li><a href='/read/1'>html</a></li>          
        <li><a href='/read/2'>css</a></li>          
        <li><a href='/read/3'>js</a></li>          
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

function App() {
  return (
    <div>
      <Header title="REACT"></Header>
      <Nav></Nav>
      <Article title="Welcome" body="Hello, Web"></Article>
    </div>
  );
}

export default App;
