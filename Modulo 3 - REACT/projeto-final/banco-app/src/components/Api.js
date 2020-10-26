import axios from 'axios'

export default class ApiBanco {
    getAgencias = () => axios.get('http://localhost:1337/agencias', {
        headers: {
            Authorization: "banco-vemser-api-fake"
        }
    })
    getAgenciaEspecifica = (id) => axios.get(`http://localhost:1337/agencia/${id}`, {
        headers: {
            Authorization: "banco-vemser-api-fake"
        }
    })
    getClientes = () => axios.get('http://localhost:1337/clientes', {
        headers: {
            Authorization: "banco-vemser-api-fake"
        }
    })
    getClienteEspecifico = (id) => axios.get(`http://localhost:1337/cliente/${id}`, {
        headers: {
            Authorization: "banco-vemser-api-fake"
        }
    })
    getTipoContas = () => axios.get('http://localhost:1337/tipoContas', {
        headers: {
            Authorization: "banco-vemser-api-fake"
        }
    })
    getTipoContaEspecifica = (id) => axios.get(`http://localhost:1337/tiposConta/${id}`, {
        headers: {
            Authorization: "banco-vemser-api-fake"
        }
    })
    getContasClientes = () => axios.get('http://localhost:1337/conta/clientes', {
        headers: {
            Authorization: "banco-vemser-api-fake"
        }
    })
    getContaClienteEspecifico = (id) => axios.get(`http://localhost:1337/conta/cliente/${id}`, {
        headers: {
            Authorization: "banco-vemser-api-fake"
        }
    })
}