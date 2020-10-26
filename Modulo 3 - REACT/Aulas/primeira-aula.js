//console.log("o/", "o/");

var nomeDaVariavel = "valor";
let nomeDaLet = "ValorLet";
const nomeDaConst = "ValorConst";

var nomeDaVariavel = "Valor3";
nomeDaLet = "ValorLet2";

const nomeDaConst2 = {
    nome: "Felipe",
    idade: 27
};

Object.freeze(nomeDaConst2);

nomeDaConst2.nome = "Felipe P.";

//console.log(nomeDaConst2);

function nomeDaFuncao(){
    //nomeDaVariavel = "valor";
    let nomeDaLet = "ValorLet2";
}

//console.log(nomeDaLet);

//function somar(){}


//valor2 = # , valor default caso seja passado apenas um valor pra função
function somar(valor1, valor2 = 1){
    console.log(valor1 + valor2);
}

//somar(3);
//somar(3, 2);

// console.log(1 + 1);
// console.log(1 + "1");

function ondeMoro(cidade){
    // console.log("Eu moro em " + cidade+".");
    console.log(`Eu moro em ${cidade}.`);
}

// ondeMoro("Porto Alegre");

function fruteira(){
    let texto = "Banana"
                + "\n"
                +"Ameixa"
                +"\n"
                +"Goiaba"
                +"\n"
                +"Pessego"
                +"\n";

    let newTexto = `
        Banana
        Ameixa
        Goiaba
        Pessego
        `;

    console.log(texto);
    console.log(newTexto);
}

// fruteira();

let eu = {
    nome: "Felipe",
    idade: 27,
    altura: 1.74
};

function quemSou(pessoa){
    console.log(`Meu nome é ${pessoa.nome}, tenho ${pessoa.idade} anos e ${pessoa.altura} de altura`);
}

// quemSou(eu);

let funcaoSomarValores = function(a, b){
    return a + b;
}


let add = funcaoSomarValores
let resultado = add(3, 5)

// console.log(resultado);

const { nome:n, idade:i } = eu
// console.log(nome, idade);
// console.log(n, i);

const array = [1, 3, 4, 8]; 
const [n1, ,n3, n2, n4 = 18] = array;
// console.log(n1, n2, n3, n4);

function testarPessoa({ nome, idade, altura }){
    console.log(nome, idade, altura);
}

// testarPessoa(eu);

let a1 = 42;
let b1 = 15;
let c1 = 99;
let d1 = 109;

// let aux = a1;
// a1 = b1;
// b1 = aux;

// console.log(a1, b1, c1, d1);

[a1, b1, c1, d1] = [b1, d1, a1, c1];

// console.log(a1, b1, c1, d1);