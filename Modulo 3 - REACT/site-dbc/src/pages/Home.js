import React, { Component } from 'react';

import Header from '../components/header';
import Banner from '../components/banner';
import Conteudo from '../components/conteudo';
import Footer from '../components/footer';

import Card from '../components/card';
import Artigo from '../components/artigo';
import Imagem from '../components/imagem';
import Titulo from '../components/titulo';
import Texto from '../components/texto';
import Botao from '../components/botao';

import SmartIMG from '../img/DBC_Smartsourcing.png';
import BuilderIMG from '../img/DBC_Software-Builder.png';
import SustainIMG from '../img/DBC_Sustain.png';
import AgilIMG from '../img/DBC_Agil.png'

export default class Home extends Component{
  render() {

    return (
      <div className="App">
        <Header />
        <Banner />
        <Conteudo conteudoClasses={"container"}>
          <div className="row">
            <Artigo artigoClasses={"col col-12 col-md-8 col-lg-8"}>
                <Titulo tituloTexto={<h2>ARTIGO ESQUERDA</h2>} />
                <Texto texto={"Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nemo quos ullam, totam eius, veniam animi illo voluptatum saepe aspernatur laudantium aliquid minima vero, sed tenetur quaerat quod repellendus mollitia fugiat!"}/>
            </Artigo>
            <Artigo artigoClasses={"col col-12 col-md-4 col-lg-4"}>
                <Titulo tituloTexto={<h2>ARTIGO DIREITA</h2>} />
                <Texto texto={"Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nemo quos ullam, totam eius, veniam animi illo voluptatum saepe aspernatur laudantium aliquid minima vero, sed tenetur quaerat quod repellendus mollitia fugiat!"}/>
            </Artigo>
          </div>
          <div className="row">
            <Card cardClasses={"col col-12 col-md-3 col-lg-3"}>
              <Imagem imagemURL={SmartIMG} imagemALT={"Imagem do Smartsourcing"}/>
              <Titulo tituloTexto={<h4>Smartsourcing</h4>}/>
              <Texto texto={"Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi, ducimus?"}/>
              <Botao botaoClasses={"button button-blue"} botaoTexto={"Saiba Mais"}/>
            </Card>
            <Card cardClasses={"col col-12 col-md-3 col-lg-3"}>
              <Imagem imagemURL={BuilderIMG} imagemALT={"Imagem do Software Builder"}/>
              <Titulo tituloTexto={<h4>Software Builder</h4>}/>
              <Texto texto={"Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi, ducimus?"}/>
              <Botao botaoClasses={"button button-blue"} botaoTexto={"Saiba Mais"}/>
            </Card>
            <Card cardClasses={"col col-12 col-md-3 col-lg-3"}>
              <Imagem imagemURL={SustainIMG} imagemALT={"Imagem do Sustain"}/>
              <Titulo tituloTexto={<h4>Sustain</h4>}/>
              <Texto texto={"Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi, ducimus?"}/>
              <Botao botaoClasses={"button button-blue"} botaoTexto={"Saiba Mais"}/>
            </Card>
            <Card cardClasses={"col col-12 col-md-3 col-lg-3"}>
              <Imagem imagemURL={AgilIMG} imagemALT={"Imagem do DBC Ágil"}/>
              <Titulo tituloTexto={<h4>DBC Ágil</h4>}/>
              <Texto texto={"Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi, ducimus?"}/>
              <Botao botaoClasses={"button button-blue"} botaoTexto={"Saiba Mais"}/>
            </Card>
          </div>
        </Conteudo>
        <Footer />
      </div>
    );
  }
}