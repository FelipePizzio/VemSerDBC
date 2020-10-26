import React, { Component } from 'react';

import Form from '../components/form';
import Header from '../components/header';
import Conteudo from '../components/conteudo';
import Footer from '../components/footer';

import Titulo from '../components/titulo';
import Texto from '../components/texto';

export default class Contato extends Component{
  render() {

    return (
      <React.Fragment>
        <Header />
        <Conteudo conteudoClasses={"container main-contact"}>
            <div className="row">
                <Form formClasses={"col col-12 col-md-6 col-lg-6 clearfix"}>
                    <Titulo tituloTexto={<h2>TÍTULO</h2>}/>
                    <Texto texto={"Lorem ipsum dolor sit amet consectetur adipisicing elit. Et hic a debitis sequi eum, vitae corrupti cum praesentium repudiandae, veritatis distinctio magnam! Libero voluptates reiciendis neque ratione cum alias est!"}/>
                </Form>
                <div className="col col-12 col-md-6 col-lg-6">
                    <iframe title="maps" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3454.720246285662!2d-51.17087564972343!3d-30.0161882368336!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x951977775fc4c071%3A0x6de693cbd6b0b5e5!2sDBC%20Company!5e0!3m2!1spt-BR!2sbr!4v1576601305521!5m2!1spt-BR!2sbr"/>
                </div>
            </div>
        </Conteudo>
        <Footer />
      </React.Fragment>
    );
  }
}