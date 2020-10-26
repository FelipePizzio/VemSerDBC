export default class Episodio {
    constructor( id, nome, duracao, temporada, ordemEpisodio, thumbURL ) {
        this.id = id
        this.nome = nome
        this.duracao = duracao
        this.temporada = temporada
        this.ordem = ordemEpisodio
        this.url = thumbURL
        this.qtdVezesAssistido = 0
        this.nota = 0
    }
    validarNota( nota ) {
        nota = parseInt( nota )
        return 1 <= nota && nota <= 5
    }
    marcarComoAssistido() {
        this.assistido = true;
        this.qtdVezesAssistido += 1;
    }
    classificarEpisodio( pontuacao ) {
        this.nota = parseInt( pontuacao );
        this.assistido = true;
    }
    get duracaoEmMin() {
        return `${ this.duracao } min`
    }
    get temporadaEpisodio() {
        return `S${ this.temporada.toString().padStart( 2, '0' ) }:${ this.ordem.toString().padStart( 2, '0' ) }`
    }
}