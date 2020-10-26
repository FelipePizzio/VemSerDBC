class PokeApi { // eslint-disable-line no-unused-vars
  buscar( id ) {
    const fazRequisicao = fetch( `https://pokeapi.co/api/v2/pokemon/${ id }` );
    return fazRequisicao.then( ( resultadoEmString ) => resultadoEmString.json() );
  }
}
