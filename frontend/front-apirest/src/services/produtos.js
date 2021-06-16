import http from './config';

const listar = () => {
  // return 'luciano'
  return http.get('/produtos')
}

const salvar = (produto) => {
  return http.post('produto', produto)
}

export default { listar, salvar };
