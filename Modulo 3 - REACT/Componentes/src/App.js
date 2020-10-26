import React, { Component } from 'react';
import './App.css';

/* import CompA, { CompB } from './components/ExemploComponenteBasico';*/
import Membros from './components/Membros';

class App extends Component {
  constructor( props ) {
    super( props );
  }

  render() {
    return (
      <div className='App'>
        {/* <CompA />
        <CompB /> */}
        <Membros nome="Jão" sobrenome="Pedra" />
      </div>
    );
  }
}

export default App;