import axios from 'axios'

export default class CandidatosApiConnector {
    getCandidatos = () => axios.get('http://localhost:8080/api/candidatos') 
    getTodosCandidatos = () => axios.get('http://localhost:8080/api/candidatos/buscar-todos')
    getCandidatoPorId = (id) => axios.get(`http://localhost:8080/api/candidatos/buscar-por-id/${id}`)
    getCandidatoPorNome = (nome) => axios.get(`http://localhost:8080/api/candidatos/buscar-por-nome/${nome}`)
    getCandidatoPorVaga = (codigoVaga) => axios.get(`http://localhost:8080/api/candidatos/buscar-por-vaga/${codigoVaga}`)
    salvarNovoCandidato = (candidato) => axios.post(`http://localhost:8080/api/candidatos/salvar/novo`, candidato) 
    editarCandidato = (candidato, id) => axios.put(`http://localhost:8080/api/candidatos/editar/${id}`, candidato)
    deletarCandidato = (id) => axios.delete(`http://localhost:8080/api/candidatos/editar/${id}`)
    uploadCurriculo = (curriculo) => axios.post(`http://localhost:8080/api/arquivo/uploadFile`, curriculo)
}