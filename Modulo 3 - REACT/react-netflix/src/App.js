import React, { Component } from 'react';
import './App.css';
import ListaSeries from './models/ListaSeries';

export default class App extends Component {
  constructor( props ){
    super(props);
    this.listaSeries = new ListaSeries()

    //console.log( this.listaSeries.invalidas() );
    //console.log( this.listaSeries.filtrarPorAno( 2020 ) );
    //console.log( this.listaSeries.procurarPorNome( '' ) );
    //console.log( this.listaSeries.mediaEpisodios() );
    //console.log( this.listaSeries.totalSalarios(0) );
    //console.log( this.listaSeries.queroGenero("Caos") );
    //console.log( this.listaSeries.queroTitulo("The") );
    console.log( this.listaSeries.creditos(0) );
  }
  render(){
    return (
      <div className="App">
        
      </div>
    );
  }
}
