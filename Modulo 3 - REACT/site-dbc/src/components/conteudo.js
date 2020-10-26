import React, { Component } from 'react';

export default class Conteudo extends Component {
    render() {
        return (
            <section className={this.props.conteudoClasses}>
                {this.props.children}
            </section>
        )
    }
}