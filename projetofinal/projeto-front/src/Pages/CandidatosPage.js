import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import Header from '../Components/Header';
import CandidatosApiConnector from '../Util/CandidatosApiConnector';
import Card from '../Components/Card';
import Candidatos from '../Models/Candidatos';
import Button from '../Components/Button'

export default class CandidatosPage extends Component {

    constructor(props) {
        super(props)
        this.apiConnector = new CandidatosApiConnector()
        this.filtrarCandidato = this.filtrarCandidato.bind(this);
        this.state = {
            listaCandidatos: [],
            candidatosFiltrados: [],
            selectedFile: ""
        }
    }

    componentWillMount() {
        return this.apiConnector.getTodosCandidatos()
            .then(res => {
                this.setState({
                    listaCandidatos: res.data.map(candidato => candidato = new Candidatos(candidato.id,
                        candidato.nome, candidato.dadosPessoais, candidato.endereco, candidato.dadosEscolares,
                        candidato.experiencias, candidato.curriculo, candidato.codigoVaga
                    ))
                });
                this.setState({
                    candidatosFiltrados: this.state.listaCandidatos
                });
            }).catch(err => {
                console.log(err)
            })
    }

    onFileChangeHandler = (e) => {
        e.preventDefault();
        this.setState({
            selectedFile: e.target.files[0]
        });
        const formData = new FormData();
        formData.append('file', this.state.selectedFile);
        this.apiConnector.uploadCurriculo(formData)
            .then(res => {
                console.log(res.data);
                alert("File uploaded successfully.")
            })
    };

    filtrarCandidato(filtro) {
        const candidatosFiltrados = this.state.listaCandidatos.filter(candidato => candidato.nome.includes(filtro))
        this.setState({
            candidatosFiltrados: candidatosFiltrados
        });
    }

    render() {
        const { listaCandidatos } = this.state
        return (
            <div className='App'>
                <div className='pages-background'>
                    <Header />
                    <div className="container">
                        <div className="page">
                            <h2>Candidatos</h2>
                            <Link to={{ pathname: "/candidatos/cadastro" }}><Button class="button button-blue-dbc" texto="Cadastrar"/></Link>
                            <div>
                            </div>
                            <div className="row">
                                {listaCandidatos.map(candidato => candidato =
                                    <div className="col col-12 col-md-6 col-lg-3">
                                        <Card className="card-candidatos" key={candidato.id}>
                                        <div className="cssdiv" >
                                            <h3> {candidato.nome} </h3>
                                            </div>
                                            <h4>Nascimento: {candidato.dadosPessoais.dataNascimento}</h4>
                                            <h4>Cargo: {candidato.experiencias.cargo}</h4>
                                            
                                            
                                            <Link to={{ pathname: "/candidatos/detalhes", state: { candidato } }}><Button class="button button-blue" texto="Detalhes"/></Link>
                                            <Link to={{ pathname: "/candidatos/editar", state: { candidato } }}><Button class="button button-blue-dbc" texto="Editar"/></Link> 
                                        </Card>
                                    </div>
                                )}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}