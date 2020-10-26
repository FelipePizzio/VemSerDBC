import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import Api from '../components/Api'

import Header from '../components/Header';
import Button from '../components/Button'

export default class AgenciaEspecifica extends Component {
    constructor(props) {
        super(props);
        this.banco = new Api();
        this.state = {
            agencia: {},
            endereco: {}
        }
    }
    getDataAgencias = ( id ) => {
        return this.banco.getAgenciaEspecifica( id )
        .then((res) => {
            this.setState({endereco: res.data.agencias.endereco})
            this.setState({agencia: res.data.agencias})
        })
        .catch("Não conseguimos carregar o conteudo, tente novamente")
    }
    componentDidMount() {
        const { id } = this.props.match.params 
        this.getDataAgencias( id );
    }
    render() {
        const { agencia, endereco } = this.state
        return (
            <div className='App'>
                <Header />
                <section className='App-header'>
                    <div className='container box'>
                        <div>
                            <p>ID: {agencia.id}</p>
                            <p>NOME: {agencia.nome}</p>
                            <p>CODIGO: {agencia.codigo}</p>
                            <p>LOGRADOURO: {endereco.logradouro}</p>
                            <p>CIDADE: {endereco.cidade}</p>
                            <p>NUMERO: {endereco.numero}</p>
                            <p>UF: {endereco.uf}</p>
                            <Link to={'/agencias'}>
                                <Button className={'button button-big button-outline'} mensagem='Voltar' />
                            </Link>
                        </div>
                    </div>
                </section>
            </div>
        );
  }
}