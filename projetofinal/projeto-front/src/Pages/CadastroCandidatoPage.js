import React, { Component } from "react";
import Popup from 'reactjs-popup';
import { Link } from 'react-router-dom';
import Input from '../Components/Input';
import Button from "../Components/Button";
import CandidatosApiConnector from '../Util/CandidatosApiConnector';
import Header from "../Components/Header";
import FilesApiConnector from "../Util/FilesApiConnector";

export default class CadastroCandidatoPage extends Component {
    constructor(props) {
        super(props)
        this.apiConnector = new CandidatosApiConnector();
        this.fileConnector = new FilesApiConnector();
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleInputChangeDadosPessoais = this.handleInputChangeDadosPessoais.bind(this);
        this.handleInputChangeEndereco = this.handleInputChangeEndereco.bind(this);
        this.handleInputChangeExperiencias = this.handleInputChangeExperiencias.bind(this);
        this.handleInputChangeDadosEscolares = this.handleInputChangeDadosEscolares.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.onFileChangeHandler = this.onFileChangeHandler.bind(this);
        this.enviarArquivo = this.enviarArquivo.bind(this);
        this.state = {
            id: null,
            nome: "",
            dadosPessoais: {
                cpf: "",
                dataNascimento: "",
                telefone: "",
                email: ""
            },
            endereco: {
                estado: "",
                cidade: "",
                bairro: "",
                rua: "",
                numero: "",
                complemento: ""
            },
            dadosEscolares: {
                localEscolar: "",
                graduacao: "",
                anoGraduacao: ""
            },
            experiencias: {
                localExperiencia: "",
                cargo: "",
                periodo: ""
            },
            codigoVaga: [],
            curriculo: ""
        }
    }

    handleSubmit(event) {
        event.preventDefault();
        return this.apiConnector.salvarNovoCandidato(this.state)
            .then(res => {
                console.log(res);
            }).catch(err => {
                console.log(err);
            })
    }

    handleInputChange(event) {
        let propriedade = event.target.id;
        let valor = event.target.value;
        this.setState({
            [propriedade]: valor
        });
    }

    handleInputChangeDadosPessoais(event) {
        let { dadosPessoais } = { ...this.state };
        let currentState = dadosPessoais;
        let { id, value } = event.target;
        currentState[id] = value;
        this.setState({ dadosPessoais: currentState });
    }

    handleInputChangeEndereco(event) {
        let { endereco } = { ...this.state };
        let currentState = endereco;
        let { id, value } = event.target;
        currentState[id] = value;
        this.setState({ endereco: currentState });
    }

    handleInputChangeExperiencias(event) {
        let { experiencias } = { ...this.state };
        let currentState = experiencias;
        let { id, value } = event.target;
        currentState[id] = value;
        this.setState({ experiencias: currentState });
    }

    handleInputChangeDadosEscolares(event) {
        let { dadosEscolares } = { ...this.state };
        let currentState = dadosEscolares;
        let { id, value } = event.target;
        currentState[id] = value;
        this.setState({ dadosEscolares: currentState });
    }

    async onFileChangeHandler(event) {
        const { dadosPessoais } = { ...this.state }
        const { cpf } = { ...dadosPessoais }
        const formData = new FormData();
        formData.append("file", event.target.files[0], cpf);
        await this.setState({
            curriculo: formData
        })
    }

    enviarArquivo() {
        this.fileConnector.uploadFile(this.state.curriculo)
    }

    render() {
        return (
            <div className='App'>
                <div className='pages-background'>
                    <Header />
                    <div className="container">
                        <div className="page">
                            <form>
                                <Link to={{ pathname: "/candidatos" }}>Voltar</Link>
                                <h2>Cadastro de Candidatos</h2>
                                <section className="borda">
                                    <div className='row'>
                                        <Input className='col col-lg-4 col-md-6 col-12' propriedade="nome" handleChange={this.handleInputChange} titulo="Nome" placeholder="Nome e sobrenome do candidato" />
                                        <Input className='col col-lg-4 col-md-6 col-12' propriedade="email" handleChange={this.handleInputChangeDadosPessoais} titulo="E-mail" placeholder="E-mail candidato" />
                                        <Input className='col col-lg-4 col-md-12 col-12' propriedade="telefone" handleChange={this.handleInputChangeDadosPessoais} titulo="Telefone" placeholder="Telefone do candidato" />
                                    </div>
                                    <div className='row'>
                                        <Input className='col col-lg-6 col-md-12 col-12' propriedade="cpf" handleChange={this.handleInputChangeDadosPessoais} titulo="CPF" placeholder="CPF do candidato"></Input>
                                        <Input className='col col-lg-6 col-md-12 col-12' propriedade="dataNascimento" handleChange={this.handleInputChangeDadosPessoais} titulo="Data de Nascimento" placeholder="Nascimento do candidato"></Input>
                                    </div>
                                </section>
                                <section className="borda">
                                    <div className='row'>
                                        <Input className='col col-lg-4 col-md-6 col-12' propriedade="estado" handleChange={this.handleInputChangeEndereco} titulo="Estado" placeholder="Estado"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12' propriedade="cidade" handleChange={this.handleInputChangeEndereco} titulo="Cidade" placeholder="Cidade"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12' propriedade="bairro" handleChange={this.handleInputChangeEndereco} titulo="Bairro" placeholder="Bairro"></Input>
                                    </div>
                                    <div className='row'>
                                        <Input className='col col-lg-4 col-md-6 col-12' propriedade="rua" handleChange={this.handleInputChangeEndereco} titulo="Rua" placeholder="Rua"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12' propriedade="numero" handleChange={this.handleInputChangeEndereco} titulo="Número" placeholder="Número"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12' propriedade="complemento" handleChange={this.handleInputChangeEndereco} titulo="Comple." placeholder="Complemento"></Input>
                                    </div>
                                </section>
                                <section className="borda">
                                    <div className='row'>
                                        <Input className='col col-lg-4 col-md-6 col-12' propriedade="localExperiencia" handleChange={this.handleInputChangeExperiencias} titulo="Local" placeholder="Local de Trabalho"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12' propriedade="cargo" handleChange={this.handleInputChangeExperiencias} titulo="Cargo" placeholder="Cargo"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12' propriedade="periodo" handleChange={this.handleInputChangeExperiencias} titulo="Periodo" placeholder="Periodo"></Input>
                                    </div>
                                </section>
                                <section className="borda">
                                    <div className='row'>
                                        <Input className='col col-lg-4 col-md-6 col-12' propriedade="localEscolar" handleChange={this.handleInputChangeDadosEscolares} titulo="Local" placeholder="Local de Estudo"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12'  propriedade="graduacao" handleChange={this.handleInputChangeDadosEscolares} titulo="Grad." placeholder="Área de estudo do candidato"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12' propriedade="anoGraduacao" handleChange={this.handleInputChangeDadosEscolares} titulo="Ano" placeholder="Ano de formação"></Input>
                                    </div>
                                </section>
                                <Button class="button button-blue-dbc" texto="Enviar" tipo="submit" onClick={this.handleSubmit}></Button>
                            </form>
                            <Popup modal position="right center" className='pop' trigger={<Button class="button button-blue" texto="Anexar Currículo" />}>
                                <input type="file" className="form-control" name="file" onChange={this.onFileChangeHandler} />
                                <Button texto='OK' onClick={this.enviarArquivo}></Button>
                            </Popup>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}