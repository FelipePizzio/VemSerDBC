import React, { Component } from 'react';
import './App.css';
import ListaSeries from './models/ListaSeries';
import Header from './components/header';
import Botao from './components/botao';

export default class Netflix extends Component {
  constructor( props ){
    super(props)
    this.listaSeries = new ListaSeries()
    this.state = {
      msg: [],
      isArray: true,
      isBoolean: false
    }
  }
  
  invalidas(){
    const serie = this.listaSeries.invalidas();
    this.setState = ({
      msg: serie,
      isArray: false,
      isBoolean: false
    })
  }

  render(){
    const { msg } = this.state

    return (
      <div className="App">
        <Header />
        <div className='App-header'>
          <div className='container'>
            <div className='row'>
              <div className='col col-6'>
                <Botao botaoClasses={'button button-big button-outline'} botaoClique={ this.invalidas.bind( this ) } botaoTexto={'Series Invalidas'}/>
              </div>
              <div className='col col-6'>
                <Botao botaoClasses={'button button-big button-outline'} botaoClique={console.log( this.listaSeries.filtrarPorAno( 2020 ) )} botaoTexto={'Filtrar Por Ano'}/>
              </div>
            </div>
            <div className='row'>
              <div className='col col-6'>
                <Botao botaoClasses={'button button-big button-outline'} botaoClique={console.log( this.listaSeries.procurarPorNome( '' ) )} botaoTexto={'Procurar Por Nome'}/>
              </div>
              <div className='col col-6'>
                <Botao botaoClasses={'button button-big button-outline'} botaoClique={console.log( this.listaSeries.mediaEpisodios() )} botaoTexto={'Media Episodios'}/>
              </div>
            </div>
            <div className='row'>
              <div className='col col-6'>
                <Botao botaoClasses={'button button-big button-outline'} botaoClique={console.log( this.listaSeries.totalSalarios(0) )} botaoTexto={'Total Salarios'}/>
              </div>
              <div className='col col-6'>
                <Botao botaoClasses={'button button-big button-outline'} botaoClique={console.log( this.listaSeries.queroGenero("Caos") )} botaoTexto={'Quero Genero'}/>
              </div>
            </div>
            <div className='row'>
              <div className='col col-6'>
                <Botao botaoClasses={'button button-big button-outline'} botaoClique={console.log( this.listaSeries.queroTitulo("The") )} botaoTexto={'Quero Titulo'}/>
              </div>
              <div className='col col-6'>
                <Botao botaoClasses={'button button-big button-outline'} botaoClique={console.log( this.listaSeries.creditos(0) )} botaoTexto={'Creditos'}/>
              </div>
            </div>
            <div className='row'>
              <div className='col col-12'>
                <span>{this.state.isArray ? (msg.map(serie => { return `${serie.titulo}, ` })) : this.state.isBoolean ? msg.toLocaleString() : msg}</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
