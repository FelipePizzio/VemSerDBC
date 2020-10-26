import React, { Component } from 'react';
import CandidatosApiConnector from '../Util/CandidatosApiConnector';
import VagasApiConnector from '../Util/VagasApiConnector';
import Candidatos from '../Models/Candidatos';
import Button from './Button';
import Scrollbar from 'react-scrollbars-custom';


export default class Vinculo extends Component {

    constructor(props) {
        super(props)
        this.CandidatoApiConnector = new CandidatosApiConnector()
        this.VagasApiConnector = new VagasApiConnector()
        this.removeElement = this.removeElement.bind(this);
        this.vincular = this.vincular.bind(this);
        this.desvincular = this.desvincular.bind(this);
        this.state = {
            listCandidatos: [],
            listaCandidatosVaga: this.props.vaga.candidatos,
            vaga: this.props.vaga
        }
    }

    async componentWillMount() {
        await this.CandidatoApiConnector.getTodosCandidatos()
            .then(res => {
                this.setState({
                    listCandidatos: res.data.map(candidato => candidato = new Candidatos(candidato.id, candidato.nome,
                        candidato.dadosPessoais, candidato.endereco, candidato.dadosEscolares, candidato.experiencias,
                        candidato.curriculo, candidato.codigoVaga
                    ))
                })
            })
            .catch(err => {
                console.log(err)
            })
    }

    vincular(candidato) {
        candidato.codigoVaga.push(this.state.vaga.codigovaga);
        let { vaga } = { ...this.state };
        vaga.candidatos.push(candidato)
        this.VagasApiConnector.editarVaga(vaga, vaga.id).then(res => {
            console.log(res.data);
        }).catch(err => {
            console.log(err)
        })
        this.setState({
            [vaga]: vaga
        })
    }

    removeElement = (array, element) => {
        let index = array.indexOf(element);
        if (index > -1) {
            array.splice(index, 1);
        }
    }

    desvincular(candidato) {
        let { vaga } = { ...this.state };
        this.removeElement(vaga.candidatos, candidato);
        this.VagasApiConnector.editarVaga(vaga, vaga.id).then(res => {
            console.log(res.data);
        }).catch(err => {
            console.log(err)
        })
        this.setState({
            [vaga]: vaga
        })
    }

    render() {
        let { listCandidatos, vaga, listaCandidatosVaga } = this.state
        return (
            <React.Fragment>
                <div className="box-popup">
                    <div className="row">
                        <h3>{vaga.titulo}</h3>
                    </div>
                    <div className="row">
                        <div className="col col-5 div-popup">
                            <Scrollbar style={{ width: 250, height: 250 }}>
                                {listaCandidatosVaga.map(candidato => (
                                    <Button
                                        texto={candidato.nome}
                                        class="button-vincular"
                                        key={candidato.id}
                                        onClick={() => this.desvincular(candidato)}
                                    />
                                ))}
                            </Scrollbar>
                        </div>

                        <div className="col col-2 vincular">
                            
                        </div>

                        <div className="col col-5 div-popup">
                            <Scrollbar style={{ width: 250, height: 250 }}>
                                {listCandidatos.filter(candidato => !listaCandidatosVaga.includes(candidato))
                                .map(candidato =>
                                    (
                                        <div>
                                            <Button
                                                texto={candidato.nome}
                                                class="button-vincular"
                                                key={candidato.id}
                                                onClick={() => this.vincular(candidato)}
                                            />
                                        </div>

                                    ))}
                            </Scrollbar>{}
                        </div>
                    </div>
                </div>
            </React.Fragment>
        )
    }
}