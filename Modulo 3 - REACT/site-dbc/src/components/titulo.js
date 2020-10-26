import React, { Component } from 'react';

export default class Titulo extends Component {
    render() {
        return (
            <React.Fragment>
                { this.props.tituloTexto }
            </React.Fragment>
        )
    }
}