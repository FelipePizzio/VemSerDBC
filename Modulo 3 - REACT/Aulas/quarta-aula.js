/* let vemSer = {
    local: 'DBC',
    ano: '2020',
    imprimirInformacoes: function(quantidade, modulo) {
        return `Argumentos: ${ this.local } | ${ this.ano } | ${ quantidade } | ${ modulo }`;
    }
}
console.log(vemSer.imprimirInformacoes(20, 3)); */

/*class Jedi {
    constructor(nome) {
        this.nome = nome
    }
    atacarComSabre() {
        setTimeout(() => {
            console.log(`${this.nome} atacou com sabre!`)
        }, 1000);
    }
    atacarComSabreSelf() {
        let self = this
        setTimeout(function () {
            console.log(`${self.nome} atacou com sabre 2!`)
        }, 2000);
    }
}
let windu = new Jedi("Windu");
windu.atacarComSabre();
windu.atacarComSabreSelf();
console.log(windu); */

/* let defer = new Promise((resolve, reject) => {
    setTimeout(() => {
        if (true) {
            resolve('Foi Resolvido');
        } else {
            reject('Erro');
        }
    }, 2000);
});

defer
    .then((data) => {
        console.log(data)
        return "Novo Resultado"
    })
    .then((data) => console.log(data))
    .catch((erro) => console.log(erro)); */

let pokemon = fetch(`https://pokeapi.co/api/v2/pokemon/`);

pokemon
    .then(data => data.json())
    .then(data => console.log(data.results));
