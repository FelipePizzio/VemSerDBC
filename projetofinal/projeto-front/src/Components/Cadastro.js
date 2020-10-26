import React, {Component} from "react";
import Input from '../Components/Input';
import Candidatos from '../Models/Candidatos';
import Button from "./Button";
import CandidatosApiConnector from '../Util/CandidatosApiConnector.js';
import DadosEscolares from "../Models/DadosEscolares";
import DadosPessoais from "../Models/DadosPessoais";
import Endereco from "../Models/Endereco";
import Experiencias from "../Models/Experiencias";



export default class Cadastro extends Component{
    constructor(props) {
        super(props)
        this.apiConnector = new CandidatosApiConnector();
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.state = {
            candidato: "",
            nome: "",
            email: "",
            telefone: "",
            cpf: "",
            dataNascimento: "",
            estadoEndereco: "",
            cidadeEndereco: "",
            bairroEndereco: "",
            ruaEndereco: "",
            numeroEndereco: "",
            complementoEndereco: "",
            localExperiencia: "",
            cargoExperiencia: "",
            periodoExperiencia: "",
            localEscolar: "",
            graduacaoEscolar: "",
            anoEscolar: ""
        }
    }

    handleSubmit(event) {
        event.preventDefault();
        const enderecoDadosPessoais = new Endereco(this.state.estadoEndereco, this.state.cidadeEndereco,
                                                   this.state.bairroEndereco, this.state.ruaEndereco, 
                                                   this.state.numeroEndereco, this.state.complementoEndereco);
        const dadosPessoaisCandidato = new DadosPessoais(this.state.cpf, this.state.dataNascimento,
                                                         this.state.telefone, enderecoDadosPessoais);
        const experienciaCandidato = new Experiencias(this.state.localExperiencia, this.state.cargoExperiencia,
                                                      this.state.localExperiencia);
        const dadosEscolaresCandidato = new DadosEscolares(this.state.localEscolar, this.state.graduacaoEscolar,
                                                           this.state.anoEscolar);
        const candidato = new Candidatos( "" ,this.state.nome, dadosPessoaisCandidato, dadosEscolaresCandidato,
                                        experienciaCandidato, "", []);
        console.log(candidato);
        
        return this.apiConnector.salvarNovoCandidato(candidato)
        .then(res => {
            console.log(res);
            console.log(res.data);
        }).catch(err => {
            console.log("erro")
        }) 
    }

    handleInputChange(event) {
        let propriedade = event.target.id;
        let valor = event.target.value;
        this.setState({
            [propriedade]: valor
        });
    }

    render() {
        let {candidato} = this.state;
        return (
            <div>
            <section>
                <h3 className="titulo">Cadastro</h3>
                <section className="borda">
                    <form onSubmit = {this.handleSubmit} />
                        <div>
                            <Input propriedade="nome" handleChange={this.handleInputChange} titulo="Nome" placeholder="Nome e sobrenome do candidato"/>
                        </div>
                        <div>
                            <Input propriedade="email" handleChange={this.handleInputChange} titulo="E-mail" placeholder="E-mail candidato"/>
                        </div>
                        <div>
                            <Input propriedade="telefone" handleChange={this.handleInputChange} titulo="Telefone" placeholder="Telefone do candidato"/>
                        </div>
                        <div>
                            <Input propriedade="cpf" handleChange={this.handleInputChange} titulo="CPF" placeholder="CPF do candidato"></Input>
                        </div>    
                        <div>
                            <Input propriedade="dataNascimento" handleChange={this.handleInputChange} titulo="Data de Nascimento" placeholder="Nascimento do candidato"></Input>
                        </div>
                </section>
                <section className="borda">
                    <div>
                        <Input propriedade="estadoEndereco" handleChange={this.handleInputChange} titulo="Estado" placeholder="Estado"></Input>
                    </div>
                    <div>
                        <Input propriedade="cidadeEndereco" handleChange={this.handleInputChange} titulo="Cidade" placeholder="Cidade"></Input>
                    </div>
                    <div>
                        <Input propriedade="bairroEndereco" handleChange={this.handleInputChange} titulo="Bairro" placeholder="Bairro"></Input>
                    </div>
                    <div>
                        <Input propriedade="ruaEndereco" handleChange={this.handleInputChange} titulo="Rua" placeholder="Rua"></Input>
                    </div>
                    <div>
                        <Input propriedade="numeroEndereco" handleChange={this.handleInputChange} titulo="Número" placeholder="Número"></Input>
                    </div>
                    <div>
                        <Input propriedade="complementoEndereco" handleChange={this.handleInputChange} titulo="Complemento" placeholder="Complemento"></Input>
                    </div>
                </section>
                <section className="borda">
                    <div>
                        <Input propriedade="localExperiencia" handleChange={this.handleInputChange} titulo="Local de Trabalho" placeholder="Local de Trabalho"></Input>
                    </div>
                    <div>
                        <Input propriedade="cargoExperiencia" handleChange={this.handleInputChange} titulo="Cargo" placeholder="Cargo"></Input>
                    </div>
                    <div>
                        <Input propriedade="periodoExperiencia" handleChange={this.handleInputChange} titulo="Periodo" placeholder="Periodo"></Input>
                    </div>
                </section>
                <section className="borda">
                    <div>
                        <Input propriedade="localEscolar" handleChange={this.handleInputChange} titulo="Local de Estudo" placeholder="Local de Estudo"></Input>
                    </div>
                    <div>
                        <Input propriedade="graduacaoEscolar" handleChange={this.handleInputChange} titulo="Graduacao" placeholder="Área de estudo do candidato"></Input>
                    </div>
                    <div>
                        <Input propriedade="anoEscolar" handleChange={this.handleInputChange} titulo="Ano de formação" placeholder="Ano de formação"></Input>
                    </div>
                </section>
                    <Button texto="Enviar" tipo="submit"></Button>
            </section>
            </div>
        )
    }
}