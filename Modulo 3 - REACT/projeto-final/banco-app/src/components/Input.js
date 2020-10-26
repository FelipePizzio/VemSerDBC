import React, { Component } from 'react'; 

export default class Input extends Component {
    render() {
        const { id, name, className, placeholder, type, onBlur } = this.props
        return (
            <input 
                id={ id } 
                name={ name } 
                className={ className } 
                placeholder={ placeholder } 
                type={ type }
                onBlur={ onBlur }>
            </input>
        )
    }
}