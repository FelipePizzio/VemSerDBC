import React, { Component } from 'react';
import Titulo from './titulo';
import Texto from './texto';
import Botao from './botao';

export default class Banner extends Component {
    render() {
        return (
            <section className="main-banner">
                <article>
                    <Titulo tituloTexto={<h1>VEM SER DBC</h1>} />
                    <Texto texto={"Lorem ipsum dolor sit amet consectetur adipisicing elit. Blanditiis iusto consequuntur sunt dolorem qui doloremque, hic id eligendi nulla iste ullam a reiciendis aut tenetur totam. Voluptas quia veniam aperiam."} />
                    <Botao botaoClasses={"button button-outline button-big"} botaoTexto={"SAIBA MAIS"}/>
                </article>
            </section>
        )
    }
}