import React, { Component } from 'react';

import Header from '../components/header';
import Conteudo from '../components/conteudo';
import Footer from '../components/footer';

import Artigo from '../components/artigo';
import Imagem from '../components/imagem';
import Titulo from '../components/titulo';
import Texto from '../components/texto';

import Selfie from '../img/kitty-cat.jpeg';

export default class About extends Component{
  render() {

    return (
      <React.Fragment>
        <Header />
        <Conteudo conteudoClasses={"container main-about"}>
            <article className="row">
                <Artigo artigoClasses={"col col-12 col-md-12 col-lg-12"}>
                    <Imagem imagemURL={Selfie} imagemALT={"foto"}/>
                    <Titulo tituloTexto={<h4>TITULO</h4>}/>
                    <Texto texto={"Lorem ipsum dolor sit, amet consectetur adipisicing elit. Minus doloribus, harum, unde dolores quasi mollitia dolore dolorem ratione accusamus odit earum et repellendus corporis sint ipsa nesciunt recusandae quod ipsam!"}/>
                </Artigo>
            </article>
            <article className="row">
                <Artigo artigoClasses={"col col-12 col-md-12 col-lg-12"}>
                    <Imagem imagemURL={Selfie} imagemALT={"foto"}/>
                    <Titulo tituloTexto={<h4>TITULO</h4>}/>
                    <Texto texto={"Lorem ipsum dolor sit, amet consectetur adipisicing elit. Minus doloribus, harum, unde dolores quasi mollitia dolore dolorem ratione accusamus odit earum et repellendus corporis sint ipsa nesciunt recusandae quod ipsam!"}/>
                </Artigo>
            </article>
            <article className="row">
                <Artigo artigoClasses={"col col-12 col-md-12 col-lg-12"}>
                    <Imagem imagemURL={Selfie} imagemALT={"foto"}/>
                    <Titulo tituloTexto={<h4>TITULO</h4>}/>
                    <Texto texto={"Lorem ipsum dolor sit, amet consectetur adipisicing elit. Minus doloribus, harum, unde dolores quasi mollitia dolore dolorem ratione accusamus odit earum et repellendus corporis sint ipsa nesciunt recusandae quod ipsam!"}/>
                </Artigo>
            </article>
            <article className="row">
                <Artigo artigoClasses={"col col-12 col-md-12 col-lg-12"}>
                    <Imagem imagemURL={Selfie} imagemALT={"foto"}/>
                    <Titulo tituloTexto={<h4>TITULO</h4>}/>
                    <Texto texto={"Lorem ipsum dolor sit, amet consectetur adipisicing elit. Minus doloribus, harum, unde dolores quasi mollitia dolore dolorem ratione accusamus odit earum et repellendus corporis sint ipsa nesciunt recusandae quod ipsam!"}/>
                </Artigo>
            </article>
        </Conteudo>
        <Footer />
      </React.Fragment>
    );
  }
}