import React, { Component } from 'react';

export default class EpisodioUi extends Component {
    render() {
        const { episodio } = this.props
        return (
            <React.Fragment>
                <div className='row'>
                    <div className='col col-lg-6 col-md-6 col-12 main-info'>
                        <h1>{ episodio.nome }</h1>
                        <img src={ episodio.url } alt={ episodio.nome }></img>
                    </div>
                    <div className='col col-lg-6 col-md-6 col-12 side-info'>
                        <span>Assistido: { episodio.assistido ? 'SIM' : 'NÃO' }, { episodio.qtdVezesAssistido } vez(es)</span>
                        <span>Duração: { episodio.duracaoEmMin }</span>
                        <span>{ episodio.temporadaEpisodio }</span>
                        <span>Nota: { episodio.nota }</span>
                    </div>
                </div>
            </React.Fragment>
        )
    }
}