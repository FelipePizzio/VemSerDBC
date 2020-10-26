import React, { Component } from 'react';

export default class Artigo extends Component {
    render() {
        return (
            <article className={this.props.artigoClasses}>
                    {this.props.children}   
            </article>
        )
    }
}