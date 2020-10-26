import PropType from 'prop-types';
import Serie from './Series';

export default class ListaSeries {
    constructor() {
      this.todos = [
        {
          "titulo": "Stranger Things",
          "anoEstreia": 2016,
          "diretor": [
            "Matt Duffer",
            "Ross Duffer"
          ],
          "genero": [
            "Suspense",
            "Ficcao Cientifica",
            "Drama"
          ],
          "elenco": [
            "Winona Ryder",
            "David Harbour",
            "Finn Wolfhard",
            "Millie Bobby Brown",
            "Gaten Matarazzo",
            "Caleb McLaughlin",
            "Natalia Dyer",
            "Charlie Heaton",
            "Cara Buono",
            "Matthew Modine",
            "Noah Schnapp"
          ],
          "temporadas": 2,
          "numeroEpisodios": 17,
          "distribuidora": "Netflix"
        },
        {
          "titulo": "Game of Thrones",
          "anoEstreia": 2011,
          "diretor": [
            "David Benioff",
            "D. B. Weiss",
            "Carolyn Strauss",
            "Frank Doelger",
            "Bernadette Caulfield",
            "George R. R. Martin"
          ],
          "genero": [
            "Fantasia",
            "Drama"
          ],
          "elenco": [
            "Peter Dinklage",
            "Nikolaj Coster-Waldau",
            "Lena Headey",
            "Emilia Clarke",
            "Kit Harington",
            "Aidan Gillen",
            "Iain Glen ",
            "Sophie Turner",
            "Maisie Williams",
            "Alfie Allen",
            "Isaac Hempstead Wright"
          ],
          "temporadas": 7,
          "numeroEpisodios": 67,
          "distribuidora": "HBO"
        },
        {
          "titulo": "The Walking Dead",
          "anoEstreia": 2010,
          "diretor": [
            "Jolly Dale",
            "Caleb Womble",
            "Paul Gadd",
            "Heather Bellson"
          ],
          "genero": [
            "Terror",
            "Suspense",
            "Apocalipse Zumbi"
          ],
          "elenco": [
            "Andrew Lincoln",
            "Jon Bernthal",
            "Sarah Wayne Callies",
            "Laurie Holden",
            "Jeffrey DeMunn",
            "Steven Yeun",
            "Chandler Riggs ",
            "Norman Reedus",
            "Lauren Cohan",
            "Danai Gurira",
            "Michael Rooker ",
            "David Morrissey"
          ],
          "temporadas": 9,
          "numeroEpisodios": 122,
          "distribuidora": "AMC"
        },
        {
          "titulo": "Band of Brothers",
          "anoEstreia": 20001,
          "diretor": [
            "Steven Spielberg",
            "Tom Hanks",
            "Preston Smith",
            "Erik Jendresen",
            "Stephen E. Ambrose"
          ],
          "genero": [
            "Guerra"
          ],
          "elenco": [
            "Damian Lewis",
            "Donnie Wahlberg",
            "Ron Livingston",
            "Matthew Settle",
            "Neal McDonough"
          ],
          "temporadas": 1,
          "numeroEpisodios": 10,
          "distribuidora": "HBO"
        },
        {
          "titulo": "The JS Mirror",
          "anoEstreia": 2017,
          "diretor": [
            "Lisandro",
            "Jaime",
            "Edgar"
          ],
          "genero": [
            "Terror",
            "Caos",
            "JavaScript"
          ],
          "elenco": [
            "Daniela Amaral da Rosa",
            "Antônio Affonso Vidal Pereira da Rosa",
            "Gustavo Lodi Vidaletti",
            "Bruno Artêmio Johann Dos Santos",
            "Márlon Silva da Silva",
            "Izabella Balconi de Moura",
            "Diovane Mendes Mattos",
            "Luciano Maciel Figueiró",
            "Igor Ceriotti Zilio",
            "Alexandra Peres",
            "Vitor Emanuel da Silva Rodrigues",
            "Raphael Luiz Lacerda",
            "Guilherme Flores Borges",
            "Ronaldo José Guastalli",
            "Vinícius Marques Pulgatti"
          ],
          "temporadas": 1,
          "numeroEpisodios": 40,
          "distribuidora": "DBC"
        },
        {
          "titulo": "10 Days Why",
          "anoEstreia": 2010,
          "diretor": [
            "Brendan Eich"
          ],
          "genero": [
            "Caos",
            "JavaScript"
          ],
          "elenco": [
            "Brendan Eich",
            "Bernardo Bosak"
          ],
          "temporadas": 10,
          "numeroEpisodios": 10,
          "distribuidora": "JS"
        },
        {
          "titulo": "Mr. Robot",
          "anoEstreia": 2018,
          "diretor": [
            "Sam Esmail"
          ],
          "genero": [
            "Drama",
            "Techno Thriller",
            "Psychological Thriller"
          ],
          "elenco": [
            "Rami Malek",
            "Carly Chaikin",
            "Portia Doubleday",
            "Martin Wallström",
            "Christian Slater"
          ],
          "temporadas": 3,
          "numeroEpisodios": 32,
          "distribuidora": "USA Network"
        },
        {
          "titulo": "Narcos",
          "anoEstreia": 2015,
          "diretor": [
            "Paul Eckstein",
            "Mariano Carranco",
            "Tim King",
            "Lorenzo O Brien"
          ],
          "genero": [
            "Documentario",
            "Crime",
            "Drama"
          ],
          "elenco": [
            "Wagner Moura",
            "Boyd Holbrook",
            "Pedro Pascal",
            "Joann Christie",
            "Mauricie Compte",
            "André Mattos",
            "Roberto Urbina",
            "Diego Cataño",
            "Jorge A. Jiménez",
            "Paulina Gaitán",
            "Paulina Garcia"
          ],
          "temporadas": 3,
          "numeroEpisodios": 30,
          "distribuidora": null
        },
        {
          "titulo": "Westworld",
          "anoEstreia": 2016,
          "diretor": [
            "Athena Wickham"
          ],
          "genero": [
            "Ficcao Cientifica",
            "Drama",
            "Thriller",
            "Acao",
            "Aventura",
            "Faroeste"
          ],
          "elenco": [
            "Anthony I. Hopkins",
            "Thandie N. Newton",
            "Jeffrey S. Wright",
            "James T. Marsden",
            "Ben I. Barnes",
            "Ingrid N. Bolso Berdal",
            "Clifton T. Collins Jr.",
            "Luke O. Hemsworth"
          ],
          "temporadas": 2,
          "numeroEpisodios": 20,
          "distribuidora": "HBO"
        },
        {
          "titulo": "Breaking Bad",
          "anoEstreia": 2008,
          "diretor": [
            "Vince Gilligan",
            "Michelle MacLaren",
            "Adam Bernstein",
            "Colin Bucksey",
            "Michael Slovis",
            "Peter Gould"
          ],
          "genero": [
            "Acao",
            "Suspense",
            "Drama",
            "Crime",
            "Humor Negro"
          ],
          "elenco": [
            "Bryan Cranston",
            "Anna Gunn",
            "Aaron Paul",
            "Dean Norris",
            "Betsy Brandt",
            "RJ Mitte"
          ],
          "temporadas": 5,
          "numeroEpisodios": 62,
          "distribuidora": "AMC"
        }
      ].map( serie => new Serie( serie.titulo, serie.anoEstreia, serie.diretor, serie.distribuidora, serie.elenco, serie.genero, serie.numeroEpisodios, serie.temporadas))
    }
    invalidas(){
      const invalidas = this.todos.filter( serie => {
          const algumCampoInvalido = Object.values( serie ).some( campo => campo === null || typeof campo === 'undefined' )
          const anoEstreiaInvalido = serie.anoEstreia > new Date().getFullYear()
          return algumCampoInvalido || anoEstreiaInvalido
      })
      return `Séries Inválidas: ${ invalidas.map( serie => serie.titulo ).join( ' - ' ) }` 
    }
    filtrarPorAno( ano ){
      return this.todos.filter( serie => {
        return serie.anoEstreia >= ano
      })
    }
    procurarPorNome( nome ){
      let encontrou = false;
      this.todos.forEach( serie => {
        let achou = serie.elenco.find( n => nome === n )
        if( achou ){
          encontrou = true
        }
      })
      return encontrou
    }
    mediaEpisodios(){
      return parseFloat( this.todos.map( serie => serie.numeroEpisodios ).reduce( (prev, cur) => prev + cur, 0 ) / this.todos.length )
    }
    totalSalarios( indice ){
      function imprimirBRLOneLine( valor ){
        return parseFloat( valor.toFixed( 2 ) ).toLocaleString('pt-BR', {
          style: 'currency',
          currency: 'BRL'
        })
      }
      const salarioDirecao = 100000 * this.todos[ indice ].diretor.length
      const salarioAtores = 40000 * this.todos[ indice ].elenco.length
      return imprimirBRLOneLine( parseFloat( salarioAtores + salarioDirecao ) )
    }
    queroGenero( genero ){
      return this.todos.filter( serie => {
        return Boolean( serie.genero.find( g => genero === g ) )
      } )
    }
    queroTitulo( titulo ){
      let palavrasTitulo = titulo.split( ' ' )
      return this.todos.filter( serie => {
        let palavrasSerie = serie.titulo.split( ' ' )
        return Boolean( palavrasSerie.find( palavra => palavra.includes( palavrasTitulo ) ) )
      } )
    }
    creditos( indice ){
      this.todos[ indice ].elenco.sort( ( a, b ) => {
        let ArrayA = a.split( ' ' )
        let ArrayB = b.split( ' ' )
        return ArrayA[ ArrayA.length - 1 ].localeCompare( ArrayB[ ArrayB.length - 1 ] )
      } )

      this.todos[ indice ].diretor.sort( ( a, b ) => {
        let ArrayA = a.split( ' ' )
        let ArrayB = b.split( ' ' )
        return ArrayA[ ArrayA.length - 1 ].localeCompare( ArrayB[ ArrayB.length - 1 ] )
      } )

      let arrayParaJuntar = []

      arrayParaJuntar.push( `${ this.todos[ indice ].titulo }` )
      arrayParaJuntar.push( `Diretores` )

      this.todos[ indice ].diretor.forEach( d => {
        arrayParaJuntar.push( `${ d }` )
      } )

      arrayParaJuntar.push( `Elenco` )

      this.todos[ indice ].elenco.forEach( e => {
        arrayParaJuntar.push( `${ e }` )
      } )

      return arrayParaJuntar;
    }
}

ListaSeries.PropType = {
    invalidas: PropType.array,
    filtrarPorAno: PropType.array,
    procurarPorNome: PropType.array,
    mediaEpisodios: PropType.array,
    totalSalarios: PropType.array,
    queroGenero: PropType.array,
    queroTitulo: PropType.array,
    creditos: PropType.array,
}
