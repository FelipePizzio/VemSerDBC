import React, { Component } from 'react';

import Header from '../components/header';
import Conteudo from '../components/conteudo';
import Footer from '../components/footer';

import Card from '../components/card';
import Imagem from '../components/imagem';
import Titulo from '../components/titulo';
import Texto from '../components/texto';
import Botao from '../components/botao';
import Artigo from '../components/artigo';

import SmartIMG from '../img/DBC_Smartsourcing.png';


export default class Service extends Component{
  render() {

    return (
      <React.Fragment>
        <Header />
        <Conteudo conteudoClasses={"container main-service"}>
            <div className="row">
                <Card cardClasses={"col col-12 col-md-4 col-lg-4"}>
                    <Imagem imagemURL={SmartIMG} imagemALT={"Imagem do Smartsourcing"}/>
                    <Texto texto={"Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi, ducimus?"}/>
                    <Botao botaoClasses={"button button-blue"} botaoTexto={"Saiba Mais"}/>
                </Card>
                <Card cardClasses={"col col-12 col-md-4 col-lg-4"}>
                    <Imagem imagemURL={SmartIMG} imagemALT={"Imagem do Smartsourcing"}/>
                    <Texto texto={"Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi, ducimus?"}/>
                    <Botao botaoClasses={"button button-blue"} botaoTexto={"Saiba Mais"}/>
                </Card>
                <Card cardClasses={"col col-12 col-md-4 col-lg-4"}>
                    <Imagem imagemURL={SmartIMG} imagemALT={"Imagem do Smartsourcing"}/>
                    <Texto texto={"Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi, ducimus?"}/>
                    <Botao botaoClasses={"button button-blue"} botaoTexto={"Saiba Mais"}/>
                </Card>
            </div>
            <div className="row">
                <Card cardClasses={"col col-12 col-md-4 col-lg-4"}>
                    <Imagem imagemURL={SmartIMG} imagemALT={"Imagem do Smartsourcing"}/>
                    <Texto texto={"Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi, ducimus?"}/>
                    <Botao botaoClasses={"button button-blue"} botaoTexto={"Saiba Mais"}/>
                </Card>
                <Card cardClasses={"col col-12 col-md-4 col-lg-4"}>
                    <Imagem imagemURL={SmartIMG} imagemALT={"Imagem do Smartsourcing"}/>
                    <Texto texto={"Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi, ducimus?"}/>
                    <Botao botaoClasses={"button button-blue"} botaoTexto={"Saiba Mais"}/>
                </Card>
                <Card cardClasses={"col col-12 col-md-4 col-lg-4"}>
                    <Imagem imagemURL={SmartIMG} imagemALT={"Imagem do Smartsourcing"}/>
                    <Texto texto={"Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi, ducimus?"}/>
                    <Botao botaoClasses={"button button-blue"} botaoTexto={"Saiba Mais"}/>
                </Card>
            </div>
            <Artigo >
                <Titulo tituloTexto={<h1>VEM SER DBC</h1>}/>
                <Texto texto={"Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo vel harum pariatur! Sit reprehenderit nam, numquam cupiditate earum dolor pariatur neque reiciendis fugiat expedita possimus nostrum mollitia beatae. Consequatur, ad."}/>
                <Botao botaoClasses={"button button-blue"} botaoTexto={"Saiba Mais"}/>
            </Artigo>
        </Conteudo>
        <Footer />
      </React.Fragment>
    );
  }
}