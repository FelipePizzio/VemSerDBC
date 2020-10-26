let infoPokemon;
let numero;
let comparador;
const numerosSorteados = [];

function listarTipos() {
  const tipos = document.getElementById( 'tipos' );
  tipos.innerHTML = 'Tipos: ';
  const ul = document.createElement( 'ul' );
  tipos.appendChild( ul );
  for ( let i = 0; i < infoPokemon.types.length; i += 1 ) {
    const li = document.createElement( 'li' );
    li.innerHTML = infoPokemon.types[i].type.name;
    ul.appendChild( li );
  }
}

function listarEstatisticas() {
  const estatisticas = document.getElementById( 'estatisticas' );
  estatisticas.innerHTML = 'Estatisticas: ';
  const ul = document.createElement( 'ul' );
  estatisticas.appendChild( ul );
  for ( let i = 0; i < infoPokemon.stats.length; i += 1 ) {
    const li = document.createElement( 'li' );
    li.innerHTML = `${ infoPokemon.stats[i].stat.name }:${ infoPokemon.stats[i].base_stat }`;
    ul.appendChild( li );
  }
}
function imprimirPokemon() {
  setTimeout( () => {
    const imagem = document.getElementById( 'img' );
    const id = document.getElementById( 'identificador' );
    const nome = document.getElementById( 'nome' );
    const altura = document.getElementById( 'altura' );
    const peso = document.getElementById( 'peso' );
    imagem.src = infoPokemon.sprites.front_default;
    id.innerHTML = `ID: ${ infoPokemon.id }`;
    comparador = infoPokemon.id;
    nome.innerHTML = `Nome: ${ infoPokemon.name }`;
    altura.innerHTML = `Altura: ${ infoPokemon.height * 10 }cm`;
    peso.innerHTML = `Peso: ${ infoPokemon.weight / 10 }Kg`;
    listarTipos();
    listarEstatisticas();
    document.getElementById( 'pokemonID' ).value = '';
  }, 1000 );
}
function buscarPokemon() {
  document.getElementById( 'img-erro' ).src = '';
  document.getElementById( 'erro' ).innerHTML = '';
  if ( numero !== '' && numero <= 807 ) {
    const pokemon = fetch( `https://pokeapi.co/api/v2/pokemon/${ numero }` );
    pokemon
      .then( ( data ) => data.json() )
      .then( ( data ) => {
        infoPokemon = data;
      } );
    imprimirPokemon();
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
    buscarPokemon( numero );
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
