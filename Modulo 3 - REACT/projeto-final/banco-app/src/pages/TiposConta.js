import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import Api from '../components/Api'

import Header from '../components/Header';
import Button from '../components/Button'
import TipoConta from '../models/tipoconta'

export default class TiposConta extends Component {
    constructor(props) {
        super(props);
        this.banco = new Api();
        this.state = {
            tiposconta: []
        }
    }
    getDataConta = () => {
        return this.banco.getTipoContas()
            .then( value => this.setState( {
                tiposconta: value.data.tipos.map( e  => e = new TipoConta( e.id, e.nome ))
            } ) )
            .catch("Não conseguimos carregar o conteudo, tente novamente")
    }
    componentDidMount() {
        this.getDataConta();
    }
    render() {
        const { tiposconta } = this.state
        return (
            <div className='App'>
                <Header />
                <section className='App-header'>
                    <div className='container box'>
                        <div className='lista'>
                            <h1>Nossos Tipos de Conta</h1>
                            <ul>
                                { tiposconta.map((e, i) => <Link  to={{ pathname: `/tipo_conta/${e.id - 1}`}}  key={i}> {e.nome} </Link>)}
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