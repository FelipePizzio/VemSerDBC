import React, { Component } from 'react';
import { Link } from 'react-router-dom';

export default class Menu extends Component {
    render() {
        return (
           <ul className="clearfix">
               <li><Link to="/agencias">AGÊNCIAS</Link></li>
               <li><Link to="/clientes">CLIENTES</Link></li>
               <li><Link to="/tipos_conta">TIPOS DE CONTA</Link></li>
               <li><Link to="/contas_clientes">CONTA DE CLIENTES</Link></li>
           </ul>
        )
    }
}