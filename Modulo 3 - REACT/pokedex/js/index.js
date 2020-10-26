const pokeApi = new PokeApi();
let numero;
let comparador;
const numerosSorteados = [];

function renderizacaoPokemon( pokemon ) {
  setTimeout( () => {
    const id = document.getElementById( 'identificador' );
    const nome = document.getElementById( 'nome' );
    const altura = document.getElementById( 'altura' );
    const peso = document.getElementById( 'peso' );
    const imgPokemon = document.getElementById( 'img' );
    id.innerHTML = `ID: ${ pokemon.id }`;
    nome.innerHTML = `NOME: ${ pokemon.nome }`;
    altura.innerHTML = `ALTURA: ${ pokemon.altura }cm`;
    peso.innerHTML = `PESO: ${ pokemon.peso }Kg`;
    imgPokemon.src = pokemon.imagem;
    pokemon.listarTipos();
    pokemon.listarEstatisticas();
    document.getElementById( 'pokemonID' ).value = '';
  }, 1000 );
}

async function buscar() {
  document.getElementById( 'img-erro' ).src = '';
  document.getElementById( 'erro' ).innerHTML = '';
  if ( numero !== '' && numero <= 807){
    const pokemonEspecifico = await pokeApi.buscar( numero );
    const poke = new Pokemon( pokemonEspecifico );
    renderizacaoPokemon( poke );
  } else {
    document.getElementById( 'img' ).src = '';
    document.getElementById( 'img-erro' ).src = 'img/error.png';
    document.getElementById( 'img-erro' ).style.width = '100%';
    document.getElementById( 'identificador' ).innerHTML = '';
    document.getElementById( 'nome' ).innerHTML = '';
    document.getElementById( 'altura' ).innerHTML = '';
    document.getElementById( 'peso' ).innerHTML = '';
    document.getElementById( 'tipos' ).innerHTML = '';
    document.getElementById( 'estatisticas' ).innerHTML = '';
    document.getElementById( 'pokemonID' ).value = '';
    const erro = document.getElementById( 'erro' );
    erro.innerHTML = 'Digite uma ID valida. Entre 1 e 807.';
  }
}

function noRepeat() {
  if ( numero !== Number( comparador ) ) {
    buscar( numero );
  }
}

const pokemonID = document.getElementById( 'pokemonID' );
pokemonID.addEventListener( 'blur', ( e ) => {
  const { target } = e;
  numero = Number( target.value );
  noRepeat( numero );
} );

const pokemonRandon = document.getElementById( 'pokemonRandon' );
pokemonRandon.addEventListener( 'click', () => {
  do {
    numero = Math.floor( ( Math.random() * 802 ) + 1 );
  } while ( numerosSorteados.includes( numero ) );
  numerosSorteados.push( numero );
  noRepeat( numero );
} );
