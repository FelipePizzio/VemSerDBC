import React, { Component } from 'react';

import Header from './components/header';
import EpisodioUI from './components/episodioUi';

export default class TelaDetalheEpisodios extends Component {
  constructor( props ){
    super( props )
  }

  render(){
    const { epi } = this.props.location.state

    return(
      <div className="App">
        <Header />
        <div className='App-header'>
          <EpisodioUI episodio={epi} />
        </div>
      </div>
    );
  }
}
