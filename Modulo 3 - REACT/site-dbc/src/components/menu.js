import React, { Component } from 'react';
import Botao from './botao';

export default class Menu extends Component {
    render() {
        return (
           <ul className="clearfix">
               <li><Botao botaoTexto={"HOME"}/></li>
               <li><Botao botaoTexto={"ABOUT US"}/></li>
               <li><Botao botaoTexto={"SERVICE"}/></li>
               <li><Botao botaoTexto={"CONTACT"}/></li>
           </ul>
        )
    }
}