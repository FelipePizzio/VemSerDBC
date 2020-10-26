import React, { Component } from 'react';
import Header from '../Components/Header';
import { Link } from 'react-router-dom';

export default class DetalheCandidatoPage extends Component {
    render() {
        const { candidato } = this.props.location.state
        console.log(this.state)
        return (
            <div className='App'>
                <div className='pages-background'>
                    <Header />
                    <div className="container">
                        <div className="page  detalhes-page">
                            <Link to={{ pathname: "/candidatos" }}>Voltar</Link>
                            <h2>{candidato.nome}</h2>
                            <div className="row">
                                <section className="col col-12">
                                    <h3>Dados Pessoais</h3>
                                    <ul>
                                        <li>CPF: {candidato.dadosPessoais.cpf}</li>
                                        <li>Data de Nascimento: {candidato.dadosPessoais.dataNascimento}</li>
                                        <li>Telefone: {candidato.dadosPessoais.telefone}</li>
                                        <li>E-mail: {candidato.dadosPessoais.email}</li>
                                    </ul>
                                </section>
                            </div>
                            <div className="row">
                                <section className="col col-12">
                                    <h3>Endereço</h3>
                                    <ul>
                                        <li>Estado: {candidato.endereco.estado}</li>
                                        <li>Cidade: {candidato.endereco.cidade}</li>
                                        <li>Bairro: {candidato.endereco.bairro}</li>
                                        <li>Rua: {candidato.endereco.rua}</li>
                                        <li>Numero: {candidato.endereco.numero}</li>
                                        <li>Complemento: {candidato.endereco.complemento}</li>
                                    </ul>
                                </section>
                            </div>
                            <div className="row">
                                <section className="col col-12">
                                    <h3>Informacoes Acadêmicas</h3>
                                    <ul>
                                        <li>Instituicao de Ensino: {candidato.dadosEscolares.localEscolar}</li>
                                        <li>Graduação: {candidato.dadosEscolares.graduacao}</li>
                                        <li>Ano de formação: {candidato.dadosEscolares.anoGraduacao}</li>
                                    </ul>
                                </section>
                            </div>
                            <div className="row">
                                <section className="col col-12">
                                    <h3>Experiências</h3>
                                    <ul>
                                        <li>Empresa: {candidato.experiencias.localExperiencia}</li>
                                        <li>Cargo: {candidato.experiencias.cargo}</li>
                                        <li>Periodo: {candidato.experiencias.periodo}</li>
                                    </ul>
                                </section>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        )
    }
}