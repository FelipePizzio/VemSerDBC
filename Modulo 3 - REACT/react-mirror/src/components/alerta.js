import React, { Component } from 'react';
import PropTypes from 'prop-types';

export default class Alerta extends Component {
    constructor( props ) {
        super( props )
        this.idsTimeouts = []
    }
    fechar = () => {
        this.props.atualizarMensagem( false )
    }
    limparTimeouts() {
        this.idsTimeouts.forEach( clearTimeout )
    }
    componentWillUnmount() {
        this.limparTimeouts()
    }
    componentDidUpdate( prevProps ){
        const { deveExibirMensagem, segundos } = this.props
        if ( prevProps.deveExibirMensagem !== deveExibirMensagem ) {
            const novoIdTimeout = setTimeout( () => {
                this.fechar()
            }, segundos * 1000 )
            this.idsTimeouts.push( novoIdTimeout )
        }
    }
    render() {
        const { deveExibirMensagem, mensagem, cor } = this.props
        if( this.animacao || deveExibirMensagem ) {
            this.animacao = deveExibirMensagem ? 'fade-in' : 'fade-out'
        }

        return (
            <span onClick={ this.fechar } className={ `alerta ${ cor } ${ this.animacao }` } >{ mensagem }</span>
        )
    }
}
Alerta.propTypes = {
    mensagem: PropTypes.string.isRequired,
    deveExibirMensagem: PropTypes.bool.isRequired,
    atualizarMsg: PropTypes.func.isRequired,
    cor: PropTypes.oneOf(['verde', 'vermelho']),
}
Alerta.defaultProps = {
    cor: 'verde',
    segundos: 3
}