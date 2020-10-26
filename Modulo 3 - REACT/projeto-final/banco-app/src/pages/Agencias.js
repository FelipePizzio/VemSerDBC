import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import Api from '../components/Api'

import Header from '../components/Header';
import Button from '../components/Button'

import Agencia from '../models/agencia'

export default class Agencias extends Component {
    constructor(props) {
        super(props);
        this.banco = new Api();
        this.state = {
            agencias: []
        }
    }
    getDataAgencias = () => {
        return this.banco.getAgencias()
            .then( value => this.setState( {
                agencias: value.data.agencias.map( e  => e = new Agencia( e.id, e.codigo, e.nome, e.endereco, e.logradouro, e.numero, e.bairro, e.cidade, e.uf ))
            } ) )
            .catch("Não conseguimos carregar o conteudo, tente novamente")
    }
    componentDidMount() {
        this.getDataAgencias();
    }
    render() {
        const { agencias } = this.state
        return (
            <div className='App'>
                <Header />
                <section className='App-header'>
                    <div className='container box'>
                        <div className='lista'>
                            <h1>Nossas Agências</h1>
                            <ul>
                                { agencias.map((e, i) => <Link  to={{ pathname: `/agencia/${e.id - 1}`}}  key={i}> {e.nome} </Link>)}
                            </ul>
                            <Link to={'/home'}>
                                <Button className={'button button-big button-outline'} mensagem='Voltar' />
                            </Link>
                        </div>
                    </div>
                </section>
            </div>
        );
  }
}