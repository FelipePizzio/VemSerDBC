import React, { Component } from 'react'
import { Link } from 'react-router-dom'

import Api from '../components/Api'

import Header from '../components/Header'
import Button from '../components/Button'

export default class TipoContaEspecifica extends Component {
    constructor(props) {
        super(props);
        this.banco = new Api();
        this.state = {
            tipoconta: {}
        }
    }
    getDataConta = ( id ) => {
        return this.banco.getTipoContaEspecifica( id )
        .then(value => this.setState({ tipoconta: value.data.tipos }))
        .catch("Não conseguimos carregar o conteudo, tente novamente")
    }
    componentDidMount() {
        const { id } = this.props.match.params 
        this.getDataConta( id );
    }
    render() {
        const { tipoconta } = this.state
        return (
            <div className='App'>
                <Header />
                <section className='App-header'>
                    <div className='container box'>
                        <div>
                            <p>ID: {tipoconta.id}</p>
                            <p>NOME: {tipoconta.nome}</p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                                Montes nascetur ridiculus mus mauris vitae ultricies leo integer malesuada. 
                                Tellus molestie nunc non blandit massa enim nec. 
                                Tellus orci ac auctor augue mauris. Nisi lacus sed viverra tellus in hac habitasse platea dictumst. 
                                Sed augue lacus viverra vitae. Mattis rhoncus urna neque viverra justo nec.
                            </p>
                            <Link to={'/tipos_conta'}>
                                <Button className={'button button-big button-outline'} mensagem='Voltar' />
                            </Link>
                        </div>
                    </div>
                </section>
            </div>
        );
  }
}