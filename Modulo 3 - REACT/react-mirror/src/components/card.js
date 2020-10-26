import React, { Component } from 'react';

export default class Card extends Component {
    render() {
        return (
            <article className={this.props.cardClasses}>
                <div className="box">
                    {this.props.children}   
                </div>
            </article>
        )
    }
}