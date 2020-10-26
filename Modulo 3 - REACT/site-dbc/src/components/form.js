import React, { Component } from 'react';

export default class Form extends Component{
    render() {
  
      return (
        <form className={ this.props.formClasses }>
            {this.props.children}
            <input type="text" name="name" placeholder="NOME" /><br/>
            <input type="text" name="email" placeholder="EMAIL" /><br/>
            <input type="text" name="fone" placeholder="TELEFONE" /><br/>
            <textarea placeholder="ESCREVA SUA RECLAMAÇÃO AQUI" /><br/>
            <input className={"button button-blue"} type="submit" value="ENVIAR" />
        </form>
      );
    }
  }