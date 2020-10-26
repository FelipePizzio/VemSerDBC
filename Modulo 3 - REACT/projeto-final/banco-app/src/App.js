import React, { Component } from 'react';
import './App.css'
import { BrowserRouter as Router, Route } from 'react-router-dom';

import Login from './pages/Login'
import Home from './pages/Home'
import Agencias from './pages/Agencias'
import AgenciaEspecifica from './pages/AgenciaEspecifica'
import Clientes from './pages/Clientes'
import ClienteEspecifico from './pages/ClienteEspecifico'
import TiposConta from './pages/TiposConta'
import TipoContaEspecifica from './pages/TipoContaEspecifica'
import ContasClientes from './pages/ContaClientes'
import ContaClienteEspecifico from './pages/ContaClienteEspecifico'

export default class App extends Component {
  render() {
    return (
      <Router>
        <Route path='/' exact component={ Login } />
        <Route path='/home' exact component={ Home } />
        <Route path='/agencias' exact component={ Agencias } />
        <Route path='/agencia/:id' exact component={ AgenciaEspecifica } />
        <Route path='/clientes' exact component={ Clientes } />
        <Route path='/cliente/:id' exact component={ ClienteEspecifico } />
        <Route path='/tipos_conta' exact component={ TiposConta } />
        <Route path='/tipo_conta/:id' exact component={ TipoContaEspecifica } />
        <Route path='/contas_clientes' exact component={ ContasClientes } />
        <Route path='/conta_cliente/:id' exact component={ ContaClienteEspecifico } />
      </Router>
    );
  }
}