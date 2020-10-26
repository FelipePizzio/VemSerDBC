import React, { Component } from 'react';
import './App.css'
import { BrowserRouter as Router, Route, Link } from 'react-router-dom'; 

import Mirror from './Mirror';
import Netflix from './Netflix';
import ListaAvaliacoes from './components/listaAvaliacoes';
import Detalhes from './TelaDetalheEpisodios';

import Botao from './components/botao';
import Card from './components/card';

export default class App extends Component {
  render() {
    return (
      <Router>
        <Route path="/" exact component={ PaginaInicial } />
        <Route path="/mirror" component={ Mirror } />
        <Route path="/netflix" component={ Netflix } />
        <Route path="/episodio/:id" component={ Detalhes } />
        <Route path="/listaAvaliacoes" component={ ListaAvaliacoes } />
      </Router>
    );
  }
}

const PaginaInicial = () => 
  <div className='container'>
    <div className='row'>
      <div className='col col-md-3 col-lg-3 col-12'>
        <Card>
          <Link to="/mirror">
            <Botao botaoClasses={'button button-big button-blue'} 
                  botaoTexto={'Black Mirror'}>
            </Botao>
          </Link>
        </Card>
      </div>
      <div className='col col-md-3 col-lg-3 col-12'>
        <Card>
          <Link to="/netflix">
            <Botao botaoClasses={'button button-big button-blue'} 
                  botaoTexto={'Netflix'}>
            </Botao>
          </Link>
        </Card>
      </div>
    </div>    
  </div>