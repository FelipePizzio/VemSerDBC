import React, { Component } from 'react';

export default class Texto extends Component {
    render() {
        return (
            <React.Fragment>
                <p>{ this.props.texto }</p>
            </React.Fragment>
        )
    }
}