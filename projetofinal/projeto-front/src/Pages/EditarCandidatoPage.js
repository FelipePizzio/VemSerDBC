import React, { Component } from "react";
import Popup from 'reactjs-popup';
import { Link } from 'react-router-dom';
import Input from '../Components/Input';
import Button from "../Components/Button";
import CandidatosApiConnector from '../Util/CandidatosApiConnector';
import Header from "../Components/Header";
import FilesApiConnector from "../Util/FilesApiConnector";

export default class EditarCandidatoPage extends Component {
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
            candidato: {
                id: this.props.location.state.candidato.id,
                nome: this.props.location.state.candidato.nome,
                dadosPessoais: {
                    cpf: this.props.location.state.candidato.dadosPessoais.cpf,
                    dataNascimento: this.props.location.state.candidato.dadosPessoais.dataNascimento,
                    telefone: this.props.location.state.candidato.dadosPessoais.telefone,
                    email: this.props.location.state.candidato.dadosPessoais.email
                },
                endereco: {
                    estado: this.props.location.state.candidato.endereco.estado,
                    cidade: this.props.location.state.candidato.endereco.cidade,
                    bairro: this.props.location.state.candidato.endereco.bairro,
                    rua: this.props.location.state.candidato.endereco.rua,
                    numero: this.props.location.state.candidato.endereco.numero,
                    complemento: this.props.location.state.candidato.endereco.complemento
                },
                dadosEscolares: {
                    localEscolar: this.props.location.state.candidato.dadosEscolares.localEscolar,
                    graduacao: this.props.location.state.candidato.dadosEscolares.graduacao,
                    anoGraduacao: this.props.location.state.candidato.dadosEscolares.anoGraduacao
                },
                experiencias: {
                    localExperiencia: this.props.location.state.candidato.experiencias.localExperiencia,
                    cargo: this.props.location.state.candidato.experiencias.cargo,
                    periodo: this.props.location.state.candidato.experiencias.periodo
                },
                codigoVaga: this.props.location.state.candidato.codigoVaga,
                curriculo: this.props.location.state.candidato.curriculo
            }
        }
    }

    componentWillMount() {
        console.log(this.state.candidato)
    }

    handleSubmit(event) {
        event.preventDefault();
        console.log(this.state.candidato);
        return this.apiConnector.editarCandidato(this.state.candidato, this.props.location.state.candidato.id)
            .then(res => {
                console.log(res);
                console.log(res.data);
            }).catch(err => {
                console.log(err);
            })
    }

    handleInputChange(event) {
        let { candidato } = { ...this.state };
        let currentState = candidato;
        let { id, value } = event.target;
        currentState[id] = value;

        this.setState({ candidato: currentState });
    }

    handleInputChangeDadosPessoais(event) {
        let { candidato } = { ...this.state };
        let { dadosPessoais } = { ...candidato };
        let currentState = dadosPessoais;
        let { id, value } = event.target;
        currentState[id] = value;

        this.setState({ dadosPessoais: currentState });
    }

    handleInputChangeEndereco(event) {
        let { candidato } = { ...this.state };
        let { endereco } = { ...candidato };
        let currentState = endereco;
        let { id, value } = event.target;
        currentState[id] = value;

        this.setState({ endereco: currentState });
    }

    handleInputChangeExperiencias(event) {
        let { candidato } = { ...this.state };
        let { experiencias } = { ...candidato };
        let currentState = experiencias;
        let { id, value } = event.target;
        currentState[id] = value;

        this.setState({ experiencias: currentState });
    }

    handleInputChangeDadosEscolares(event) {
        let { candidato } = { ...this.state };
        let { dadosEscolares } = { ...candidato };
        let currentState = dadosEscolares;
        let { id, value } = event.target;
        currentState[id] = value;
        this.setState({ dadosEscolares: currentState });
    }

    async onFileChangeHandler(event) {
        let { candidato } = { ...this.state }
        const { dadosPessoais } = { ...candidato }
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
                                <h2>Editar</h2>
                                <section className="borda">
                                    <div className='row'>
                                        <Input className='col col-lg-4 col-md-6 col-12' valor={this.state.candidato.nome} propriedade="nome" handleChange={this.handleInputChange} titulo="Nome" placeholder="Nome e sobrenome do candidato" />
                                        <Input className='col col-lg-4 col-md-6 col-12' valor={this.state.candidato.dadosPessoais.email} propriedade="email" handleChange={this.handleInputChangeDadosPessoais} titulo="E-mail" placeholder="E-mail candidato" />
                                        <Input className='col col-lg-4 col-md-12 col-12' valor={this.state.candidato.dadosPessoais.telefone} propriedade="telefone" handleChange={this.handleInputChangeDadosPessoais} titulo="Telefone" placeholder="Telefone do candidato" />
                                    </div>
                                    <div className='row'>
                                        <Input className='col col-lg-6 col-md-12 col-12' valor={this.state.candidato.dadosPessoais.cpf} propriedade="cpf" handleChange={this.handleInputChangeDadosPessoais} titulo="CPF" placeholder="CPF do candidato"></Input>
                                        <Input className='col col-lg-6 col-md-12 col-12' valor={this.state.candidato.dadosPessoais.dataNascimento} propriedade="dataNascimento" handleChange={this.handleInputChangeDadosPessoais} titulo="Data de Nascimento" placeholder="Nascimento do candidato"></Input>
                                    </div>
                                </section>
                                <section className="borda">
                                    <div className='row'>
                                        <Input className='col col-lg-4 col-md-6 col-12' valor={this.state.candidato.endereco.estado} propriedade="estado" handleChange={this.handleInputChangeEndereco} titulo="Estado" placeholder="Estado"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12' valor={this.state.candidato.endereco.cidade} propriedade="cidade" handleChange={this.handleInputChangeEndereco} titulo="Cidade" placeholder="Cidade"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12' valor={this.state.candidato.endereco.bairro} propriedade="bairro" handleChange={this.handleInputChangeEndereco} titulo="Bairro" placeholder="Bairro"></Input>
                                    </div>
                                    <div className='row'>
                                        <Input className='col col-lg-4 col-md-6 col-12' valor={this.state.candidato.endereco.rua} propriedade="rua" handleChange={this.handleInputChangeEndereco} titulo="Rua" placeholder="Rua"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12' valor={this.state.candidato.endereco.numero} propriedade="numero" handleChange={this.handleInputChangeEndereco} titulo="Número" placeholder="Número"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12' valor={this.state.candidato.endereco.complemento} propriedade="complemento" handleChange={this.handleInputChangeEndereco} titulo="Comple." placeholder="Complemento"></Input>
                                    </div>
                                </section>
                                <section className="borda">
                                    <div className='row'>
                                        <Input className='col col-lg-4 col-md-6 col-12' valor={this.state.candidato.experiencias.localExperiencia} propriedade="localExperiencia" handleChange={this.handleInputChangeExperiencias} titulo="Local" placeholder="Local de Trabalho"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12' valor={this.state.candidato.experiencias.cargo} propriedade="cargo" handleChange={this.handleInputChangeExperiencias} titulo="Cargo" placeholder="Cargo"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12' valor={this.state.candidato.experiencias.periodo} propriedade="periodo" handleChange={this.handleInputChangeExperiencias} titulo="Periodo" placeholder="Periodo"></Input>
                                    </div>
                                </section>
                                <section className="borda">
                                    <div className='row'>
                                        <Input className='col col-lg-4 col-md-6 col-12' valor={this.state.candidato.dadosEscolares.localEscolar} propriedade="localEscolar" handleChange={this.handleInputChangeDadosEscolares} titulo="Local" placeholder="Local de Estudo"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12' valor={this.state.candidato.dadosEscolares.graduacao} propriedade="graduacao" handleChange={this.handleInputChangeDadosEscolares} titulo="Grad." placeholder="Área de estudo do candidato"></Input>
                                        <Input className='col col-lg-4 col-md-6 col-12' valor={this.state.candidato.dadosEscolares.anoGraduacao} propriedade="anoGraduacao" handleChange={this.handleInputChangeDadosEscolares} titulo="Ano" placeholder="Ano de formação"></Input>
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