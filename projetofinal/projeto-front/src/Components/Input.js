import React, {Component} from "react";

export default class Input extends Component{

    render() {
        return (
            <div className={this.props.className}>
                <label htmlFor={this.props.propriedade}>{this.props.titulo}</label>
                <input type="text" defaultValue={this.props.valor} placeholder={this.props.placeholder} id={this.props.propriedade} onBlur={this.props.handleChange}/>
            </div>
        )
    }
}