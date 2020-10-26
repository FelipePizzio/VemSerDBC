import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import Api from '../components/Api'

import Header from '../components/Header';
import Button from '../components/Button'
import ContaCliente from '../models/contacliente'

export default class ContasClientes extends Component {
    constructor(props) {
        super(props);
        this.banco = new Api();
        this.state = {
            contaCliente: []
        }
    }
    getDataContasClientes = () => {
        return this.banco.getContasClientes()
            .then( value => this.setState( {
                contaCliente: value.data.cliente_x_conta.map( e  => e = new ContaCliente( e.id, e.codigo, e.tipo.nome, e.cliente.nome ))
            } ) )
            .catch("Não conseguimos carregar o conteudo, tente novamente")
    }
    componentDidMount() {
        this.getDataContasClientes();
    }
    render() {
        const { contaCliente } = this.state
        return (
            <div className='App'>
                <Header />
                <section className='App-header'>
                    <div className='container box'>
                        <div className='lista'>
                            <h1>Nossos Clientes</h1>
                            <ul>
                                { contaCliente.map((e, i) => 
                                    <Link  to={{ pathname: `/conta_cliente/${e.id - 1}`}}  key={i}>
                                        { e.id }&nbsp;
                                        { e.cliente }&nbsp;
                                        { e.tipo }
                                </Link>)}
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