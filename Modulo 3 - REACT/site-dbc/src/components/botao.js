import React, { Component } from 'react';

export default class Botao extends Component {
    render() {
        return (
            <React.Fragment>
                <a className={ this.props.botaoClasses } href={this.props.botaoLink} title={ this.props.botaoTitulo } > { this.props.botaoTexto } </a>
            </React.Fragment>
        )
    }
}