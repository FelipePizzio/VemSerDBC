import React, {Component} from "react";

export default class InputFiltro extends Component {
    constructor(props) {
        super(props)
        this.handleChange = this.handleChange.bind(this);
        this.state = {
            valorInput: ""
        }
    }

    handleChange(evt) {
        this.setState({valorInput: evt.target.value});
    }
      
    geraBotao() {
        return (
          this.props.botao && (
            <button className="button" onClick={() => this.props.funcaoBotao( this.state.valorInput )}>{this.props.children}</button>
          )
        )
    }

    render() {
        return (
            <React.Fragment>
                <input onChange={this.handleChange}
                       type={this.props.type} 
                       placeholder={this.props.placeholder}></input>
                {this.geraBotao()}
            </React.Fragment>
        )
    }
}