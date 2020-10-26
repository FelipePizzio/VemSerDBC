import React, { Component } from 'react'; 

export default class Botao extends Component {
    render() {
        return (
            <React.Fragment>
                <a className={ this.props.botaoClasses } 
                    title={ this.props.botaoTitulo } 
                    onClick={this.props.botaoClique} >
                    { this.props.botaoTexto }
                </a>
            </React.Fragment>
        )
    }
}