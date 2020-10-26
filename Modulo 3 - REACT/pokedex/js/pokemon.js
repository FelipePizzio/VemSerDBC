class Pokemon { // eslint-disable-line no-unused-vars
  constructor( obj ) {
    this.id = obj.id;
    this.nome = obj.name;
    this.altura = obj.height * 10;
    this.peso = obj.weight / 10;
    this.imagem = obj.sprites.front_default;
    this.tipos = obj.types;
    this.estatisticas = obj.stats;
  }

  listarTipos() {
    const tipo = document.getElementById( 'tipos' );
    tipo.innerHTML = 'TIPOS: ';
    const ul = document.createElement( 'ul' );
    tipo.appendChild( ul );
    for ( let i = 0; i < this.tipos.length; i += 1 ) {
      const li = document.createElement( 'li' );
      li.innerHTML = this.tipos[i].type.name;
      ul.appendChild( li );
    }
  }

  listarEstatisticas() {
    const estatistica = document.getElementById( 'estatisticas' );
    estatistica.innerHTML = 'ESTATISTICAS: ';
    const ul = document.createElement( 'ul' );
    estatistica.appendChild( ul );
    for ( let i = 0; i < this.estatisticas.length; i += 1 ) {
      const li = document.createElement( 'li' );
      li.innerHTML = `${ this.estatisticas[i].stat.name }:${ this.estatisticas[i].base_stat }`;
      ul.appendChild( li );
    }
  }
}
