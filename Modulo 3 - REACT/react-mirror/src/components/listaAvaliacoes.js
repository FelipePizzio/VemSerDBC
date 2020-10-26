import React from 'react';
import { Link } from 'react-router-dom';

const ListaAvaliacoes = props => {
    const { listaEpisodios } = props.location.state
    return listaEpisodios.avaliados.map( ep => 
        <li key={ ep.id }>
            <Link to={{ pathname: `/episodio/${ ep.id }`, state: { episodio: ep } }} >
                { `Nome: ${ ep.nome } - Nota: ${ ep.nota } - Temp: ${ ep.temporada } - Ep: ${ ep.ordem }` }
            </Link>
        </li>
    )
}

export default ListaAvaliacoes;