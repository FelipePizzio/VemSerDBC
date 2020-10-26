import React, { Component } from 'react';
import './Mirror.css';
import { Link } from 'react-router-dom';

import ListaEpisodios from './models/listaEpisodios';
import EpisodioUi from './components/episodioUi'
import Header from './components/header';
import Botao from './components/botao';
import Alerta from './components/alerta';
import MeuInputNumero from './components/MeuInputNumero';

class Mirror extends Component {
  constructor( props ) {
    super( props );
    this.listaEpisodios = new ListaEpisodios();
    this.state = {
      episodio: this.listaEpisodios.episodiosAleatorios,
      exibirMensagem: false,
      deveExibirErro: false,
    }
  }
  sortear() {
    const episodio = this.listaEpisodios.episodiosAleatorios;
    this.setState( {
      episodio
    } )
  }
  assistido() {
    const { episodio } = this.state;
    episodio.marcarComoAssistido();
    this.setState( {
      episodio
    } )
  }
  classificar( { nota, erro } ) {
    this.setState({
      deveExibirErro: erro
    })
    if( erro ){
      return;
    }
    let cor, mensagem;
    const { episodio } = this.state;
    if( episodio.validarNota( nota ) ){
      episodio.classificarEpisodio( nota )
      cor = 'verde'
      mensagem = "Registramos sua nota!"
    }else{
      cor = 'vermelho'
      mensagem = "Digite uma nota valida (entre 1 e 5)"
    }
    this.exibirMensagem( { cor, mensagem } )
  }
  exibirMensagem = ( { cor, mensagem } ) => {
    this.setState( {
      cor,
      mensagem,
      exibirMensagem: true,
    } )
  }
  atualizarMensagem = devoExibir => {
    this.setState({
      exibirMensagem: devoExibir,
    })
  }

  render() {
    const { episodio, exibirMensagem, cor, mensagem, deveExibirErro} = this.state;
    const { listaEpisodios } = this

    return (
      <div className='App'>
        <Header />
        <div className='App-header'>
          <div className='container'>
            <EpisodioUi episodio={ episodio } />
            <div className='row'>
              <div className='col col-lg-6 col-md-6 col-12'>
                <Botao botaoClasses={'button button-big button-outline'} 
                      botaoTexto={'Próximo'} 
                      botaoClique={this.sortear.bind( this )}
                />
                <Botao botaoClasses={'button button-big button-outline'} 
                      botaoTexto={'Assistido'} 
                      botaoClique={this.assistido.bind( this )}
                />
                <Link to={{ pathname:"/listaAvaliacoes", state: { listaEpisodios } }}>
                  <Botao botaoClasses={'button button-big button-outline'} 
                        botaoTexto={'Avaliações'}>
                  </Botao>
                </Link>
              </div>
              <div className='col col-lg-5 col-md-5 col-12 alerta'>
                <Alerta atualizarMensagem={ this.atualizarMensagem }
                        deveExibirMensagem={ exibirMensagem } 
                        mensagem={ mensagem } 
                        cor= { cor }
                        segundos= { 5 }/>
              </div>
            </div>
            <div className='row'>
              <div className='col col-lg-6 col-md-6 col-12'>
                <MeuInputNumero placeholder="1 a 5"
                                mensagemCampo="Qual sua nota para esse episódio?"
                                visivel={ episodio.assistido || false }
                                obrigatorio={ true }
                                atualizarNota={ this.classificar.bind(this) }
                                deveExibirErro={ deveExibirErro }
                />              
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Mirror;