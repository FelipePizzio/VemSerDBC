import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import Api from '../components/Api'

import Header from '../components/Header';
import Button from '../components/Button'
import Cliente from '../models/cliente'

export default class Clientes extends Component {
    constructor(props) {
        super(props);
        this.banco = new Api();
        this.state = {
            clientes: []
        }
    }
    getDataClientes = () => {
        return this.banco.getClientes()
            .then( value => this.setState( {
                clientes: value.data.clientes.map( e  => e = new Cliente( e.id, e.cpf, e.nome, e.agencia ))
            } ) )
            .catch("Não conseguimos carregar o conteudo, tente novamente")
    }
    componentDidMount() {
        this.getDataClientes();
    }
    render() {
        const { clientes } = this.state
        return (
            <div className='App'>
                <Header />
                <section className='App-header'>
                    <div className='container box'>
                        <div className='lista'>
                            <h1>Nossos Clientes</h1>
                            <ul>
                                { clientes.map((e, i) => <Link  to={{ pathname: `/cliente/${e.id - 1}`}}  key={i}>{e.nome} </Link>)}
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