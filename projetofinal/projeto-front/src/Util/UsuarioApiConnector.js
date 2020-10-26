import axios from 'axios'
import Usuario from '../Models/Usuario'

export default class UsuarioApiConnector {
    getUsuarios = () => axios.get('http://localhost:8080/api/usuarios/buscar-todos')
    getUsuariosPorId = (id) => axios.get(`http://localhost:8080/api/usuarios/buscar-por-id/${id}`)
    getNomeUsuario = (nome) => axios.get(`http://localhost:8080/api/usuarios/buscar-por-nome/${nome}`)
    getEmailUsuario = (email) => axios.get(`http://localhost:8080/api/usuarios/buscar-por-email/${email}`)
    salvarNovoUsuario = () => axios.post(`http://localhost:8080/api/usuarios/salvar/novo`, Usuario) 
    editarUsuario = (id) => axios.put(`http://localhost:8080/api/usuarios/editar/${id}`, Usuario)
    deletarUsuario = (id) => axios.delete(`http://localhost:8080/api/usuarios/editar/${id}`)
}