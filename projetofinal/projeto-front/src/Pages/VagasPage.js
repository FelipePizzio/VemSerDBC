import React, { Component } from 'react';
import Header from '../Components/Header';
import VagasApiConnector from '../Util/VagasApiConnector';
import Card from '../Components/Card';
import Vagas from '../Models/Vagas';
import Button from '../Components/Button';
import Popup from 'reactjs-popup';
import Vinculo from '../Components/Vinculo'
import InputFiltro from '../Components/InputFiltro';
import { Markup } from 'interweave';
import Scrollbar from 'react-scrollbars-custom';


export default class VagasPage extends Component {

    constructor(props) {
        super(props)
        this.apiConnector = new VagasApiConnector()
        this.filtrarVagas = this.filtrarVagas.bind(this);
        this.state = {
            listaVagas: [],
            vagasFiltradas: []
        }
    }

    async componentDidMount() {
        await this.apiConnector.getVagas()
            .then(res => {
                this.setState({
                    listaVagas: res.data.map(vaga => vaga = new Vagas(vaga.id,
                        vaga.titulo, vaga.dataabertura, vaga.codigovaga, vaga.url,
                        vaga.cidade, vaga.estado, vaga.codigofilial, vaga.nomefilial, vaga.descricaovaga, []
                    ))
                });
                this.setState({
                    vagasFiltradas: this.state.listaVagas
                });
            }).catch(err => {
                console.log(err)
            })
    }

    filtrarVagas(filtro) {
        const vagasFiltradas = this.state.listaVagas.filter(vaga => vaga.titulo.includes(filtro))
        this.setState({
            vagasFiltradas: vagasFiltradas
        });
    }

    render() {
        const { vagasFiltradas } = this.state
        return (
            <div className='App'>
                <div className='pages-background'>
                    <Header />
                    <div className="container">
                        <div className="page">
                            <h2>Vagas</h2>
                            <InputFiltro botao={true} funcaoBotao={this.filtrarVagas} placeholder="Filtrar por titulo">Filtrar</InputFiltro>
                            <div className="row">
                                {vagasFiltradas.map(vaga => vaga =
                                    <div className="col col-12 col-md-6 col-lg-3" >
                                        <Card className="card-vagas" key={vaga.id}>
                                            <div className="cssdiv" >
                                                <h3> {vaga.titulo} </h3>
                                            </div>
                                            <h5>Codigo: {vaga.codigovaga}</h5>
                                            <h5>Cidade: {vaga.cidade}</h5>
                                            <Popup modal position="right center" class="pop"
                                                trigger={<Button class="button button-blue" texto="Detalhes" />} >
                                                <div className="pop-detalhes-vaga">
                                                    <h2> Detalhes </h2>
                                                    <Card className="card-detalhes">
                                                        <div className="row">
                                                            <div className="col col-6">
                                                                <h4>Titulo: {vaga.titulo}</h4>
                                                                <h4>Codigo: {vaga.codigovaga}</h4>
                                                                <h4>Abertura: {vaga.dataabertura}</h4>
                                                                <h4>Cidade: {vaga.cidade}</h4>
                                                                <h4>Nome da FIlial: {vaga.nomefilial} </h4>
                                                                 {/* eslint-disable-next-line */}
                                                                 <button className="button button-outline" ><a href={vaga.url} target="_blank" >Visite a Página</a> </button>
                                                            </div>
                                                            <div className="col col-6">
                                                                <Scrollbar style={{ width: 280, height: 330 }}>
                                                                    <h4>Descrição: <Markup content={vaga.descricaovaga} /></h4>
                                                                </Scrollbar>
                                                            </div>
                                                        </div>
                                                    </Card>
                                                </div>
                                            </Popup>
                                            <Popup modal position="right center"
                                                trigger={<Button class="button button-blue-dbc" texto="Vincular" />} >
                                                <Vinculo vaga={vaga} />
                                            </Popup>
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