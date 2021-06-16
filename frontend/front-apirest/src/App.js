import logo from './logo.svg';
import './App.css';
import axios from "axios";

// import Produto from './services/produtos';

function login() {
const form = new FormData();
form.append("grant_type", "password");
form.append("username", "berchon");
form.append("password", "abc");

const options = {
  method: 'POST',
  url: 'http://localhost:8080/oauth/token',
  headers: {
    'Content-Type': 'multipart/form-data; boundary=---011000010111000001101001',
    Authorization: 'Basic bHVjaWFubzoxMjM='
  },
  data: '[form]'
};

axios.request(options).then(function (response) {
  console.log(response.data);
}).catch(function (error) {
  console.error(error);
});
}

function App() {
  login();
  // const a=Produto.listar ().then(res => {
  //   console.log(res.data)
  //   return res;
  // })
  // const objSalvar = { nome: 'Luciano', quantidade: 1, valor: 10 }
  // const b = Produto.salvar(objSalvar).then(res => {
  //   alert('Salvo com sucesso!')
  // })
  // console.log(a)
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
