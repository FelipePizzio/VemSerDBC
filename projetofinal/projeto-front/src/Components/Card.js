import React, { Component } from 'react';

export default class Card extends Component{
    render() {
        const { className } = this.props
        return(
            <div className = { className }>
                { this.props.children }
            </div>
        );
    }
}