import React, { Component } from 'react';
import Botao from './botao';
import Imagem from './imagem';
import Menu from './menu';

import Logo from '../img/DBC-logo.png';

export default class Header extends Component {
    render() {
        return (
            <section className="main-header">
                <nav className="container clearfix">
                    <Botao botaoClasses={"logo"} botaoTitulo={"Voltar a Home"} 
                        botaoTexto={    <Imagem imagemURL={Logo} imagemALT={"Logo DBC"}/>   }
                    />
                    <label className="mobile-menu" htmlFor="mobile-menu">
                        <span></span>
                        <span></span>
                        <span></span>
                    </label>
                    <input id="mobile-menu" type="checkbox" />
                    <Menu />
                </nav>
            </section>
        )
    }
}