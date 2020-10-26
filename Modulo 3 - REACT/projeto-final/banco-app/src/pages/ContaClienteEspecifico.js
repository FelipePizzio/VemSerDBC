import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import Api from '../components/Api'

import Header from '../components/Header';
import Button from '../components/Button'

export default class ContaClienteEspecifico extends Component {
    constructor(props) {
        super(props);
        this.banco = new Api();
        this.state = {
            contaCliente: {},
            cliente: {},
            tipoConta: {}
        }
    }
    getDataContaCliente = ( id ) => {
        return this.banco.getContaClienteEspecifico( id )
        .then((res) => {
            this.setState({contaCliente: res.data.conta})
            this.setState({cliente: res.data.conta.cliente})
            this.setState({tipoConta: res.data.conta.tipo})
        })
        .catch("Não conseguimos carregar o conteudo, tente novamente")
    }
    componentDidMount() {
        const { id } = this.props.match.params 
        this.getDataContaCliente( id );
    }
    render() {
        const { contaCliente, cliente, tipoConta } = this.state
        return (
            <div className='App'>
                <Header />
                <section className='App-header'>
                    <div className='container box'>
                        <div>
                            <p>ID: {contaCliente.id}</p>
                            <p>NOME: {cliente.nome}</p>
                            <p>CONTA: {tipoConta.nome}</p>
                            <Link to={`/cliente/${(cliente.id) - 1}`}>VER DETALHES DA AGÊNCIA</Link>
                        </div>
                        <Link to={'/contas_clientes'}>
                            <Button className={'button button-big button-outline'} mensagem='Voltar' />
                        </Link>
                    </div>
                </section>
            </div>  
        );
  }
}