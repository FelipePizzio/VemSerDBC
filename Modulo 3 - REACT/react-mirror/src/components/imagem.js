import React, { Component } from 'react';

export default class Imagem extends Component {
    render() {
        return (
            <div>
                <img src={ this.props.imagemURL } alt={ this.props.imagemALT } />
            </div>
        )
    }
}