import React, { Component } from 'react';
import { Link } from 'react-router-dom';

export default class Menu extends Component {
    render() {
        return (
           <ul className="clearfix">
               <li><Link to="/">HOME</Link></li>
               <li><Link to="/mirror">MIRROR</Link></li>
               <li><Link to="/netflix">NETFLIX</Link></li>
               <li><Link to="/listaAvaliacoes">AVALIAÇÕES</Link></li>
           </ul>
        )
    }
}