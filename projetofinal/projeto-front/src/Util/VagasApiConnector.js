import axios from 'axios'

export default class VagasApiConnector {
    getVagas = () => axios.get('http://localhost:8080/api/vagas/buscar-todos')
    getVagasPorId = (id) => axios.get(`http://localhost:8080/api/vagas/buscar-por-id/${id}`)
    getVagasPorTitulo = (titulo) => axios.get(`http://localhost:8080/api/vagas/buscar-por-titulo/${titulo}`)
    getCodigoVaga = (codigoVaga) => axios.get(`http://localhost:8080/api/vagas/buscar-por-codigo-da-vaga/${codigoVaga}`)
    getCidade = (cidade) => axios.get(`http://localhost:8080/api/vagas/buscar-por-cidade/${cidade}`)
    editarVaga = (vaga, id) => axios.put(`http://localhost:8080/api/vagas/editar/${id}`, vaga)
}