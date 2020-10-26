import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import Api from '../components/Api'

import Header from '../components/Header';
import Button from '../components/Button'

export default class ClienteEspecifico extends Component {
    constructor(props) {
        super(props);
        this.banco = new Api();
        this.state = {
            cliente: {},
            agencia: {}
        }
    }
    getDataCliente = ( id ) => {
        return this.banco.getClienteEspecifico( id )
        .then((res) => {
            this.setState({cliente: res.data.cliente})
            this.setState({agencia: res.data.cliente.agencia})
        })
        .catch("Não conseguimos carregar o conteudo, tente novamente")
    }
    componentDidMount() {
        const { id } = this.props.match.params 
        this.getDataCliente( id );
    }
    render() {
        const { agencia, cliente } = this.state
        return (
            <div className='App'>
                <Header />
                <section className='App-header'>
                    <div className='container box'>
                        <div>
                            <p>ID: {cliente.id}</p>
                            <p>NOME: {cliente.nome}</p>
                            <p>CPF: {cliente.cpf}</p>
                            <p>AGÊNCIA:&nbsp;
                                <Link to={`/agencia/${(agencia.id) - 1}`}>{agencia.nome}</Link>
                            </p>
                        </div>
                        <Link to={'/clientes'}>
                            <Button className={'button button-big button-outline'} mensagem='Voltar' />
                        </Link>
                    </div>
                </section>
            </div>
        );
  }
}