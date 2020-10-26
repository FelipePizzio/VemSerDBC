/*Exercício 01

Crie uma função "calcularCirculo" que receba um objeto com os seguintes parâmetros:
{
    raio, // raio da circunferência
    tipoCalculo // se for "A" cálcula a área, se for "C" calcula a circunferência
}

*MARCOS*
function calcularCirculo({raio, tipoCalculo:tipo}){
    return Math.ceil( tipo == "A" ? Math.PI * Math.pow( raio, 2 ) : 2 * Math.PI * raio )
}

let circulo = {
    raio:3,
    tipoCalculo: "A"
}

console.log(calcularCirculo(circulo));
*/

let circulo = {
    raio: 0,
    tipo: ""
};

function calcularCirculo({ raio, tipo}) {
    if (tipo == "A") {
        // console.log(Math.PI * raio**2);
    }
    if (tipo == "C") {
        // console.log(2 * Math.PI * raio);
    }
};

circulo = {
    raio: 5,
    tipo: "A"
}
calcularCirculo(circulo);

circulo = {
    raio: 5,
    tipo: "C"
}
calcularCirculo(circulo);

/*Exercício 02

Crie uma função naoBissexto que recebe um ano (número) e verifica se ele não é bissexto. 
Exemplo:
	naoBissexto(2016) // false
    naoBissexto(2017) // true
    
*MARCOS*
function naoBissexto(ano){
    return (ano%400 === 0) || (ano%4 == 0 && ano%100 !== 0) ? false : true;
}


const teste = {
    diaAula: "Segundo",
    local: "DBC",
    bissexto(ano){
        return (ano%400 === 0) || (ano%4 == 0 && ano%100 !== 0) ? true : false;
    }
}
console.log(teste.bissexto(2015));


let bissexto = ano => (ano%400 === 0) || (ano%4 == 0 && ano%100 !== 0);
console.log(bissexto(2016));

*/

function naoBissexto(ano) {
    if ((ano%400 === 0) || (ano%4 == 0 && ano%100 !== 0)) {
        return false;
    } else {
        return true;
    }
}

// console.log(naoBissexto(2000));
// console.log(naoBissexto(2016));
// console.log(naoBissexto(2017));

/*Exercício 03

Crie uma função somarPares que recebe um array de números (não precisa fazer validação) 
e soma todos números nas posições pares do array, exemplo:

somarPares( [ 1, 56, 4.34, 6, -2 ] ) // 3.34

*MARCOS*
function somarPares(numeros){
    let resultado = 0;
    for(let i = 0; i < numeros.length; i++){
        if (i % 2 === 0) {
            resultado += numeros[i];
        }
    }
    return resultado;
}
*/

function somarPares(array) {
    let soma = 0;
    for(let i = 0; i < array.length; i++){
        if(i % 2 === 0){
            soma += array[i];
        }
    }
    return soma;
}
// console.log(somarPares([1, 56, 4.34, 6, -2]));

/*Exercício 04 - Soma diferentona

Escreva uma função adicionar que permite somar dois números através de duas chamadas diferentes 
(não necessariamente pra mesma função). Pirou? Ex:

adicionar(3)(4) // 7
adicionar(5642)(8749) // 14391
*/
/*MARCOS*/

/* function adicionar(op1){
    return function(op2){
        return op1+op2;
    }
}

console.log(adicionar(3)(4));
console.log(adicionar(5642)(8749));
*/

let adicionar = op1 => op2 => op1 + op2;
// console.log(adicionar(3)(4));
// console.log(adicionar(5642)(8749));

/* 
    const divisivelPor = divisor => numero => !(numero % divisor);
    const is_divisivel = divisivelPor(2);
    console.log(is_divisivel(20));
    console.log(is_divisivel(11));

*/

/*Exercício 05

Escreva uma função imprimirBRL que recebe um número flutuante (ex: 4.651) 
e retorne como saída uma string no seguinte formato (seguindo o exemplo): “R$ 4,66”

Outros exemplos:

imprimirBRL(0) // “R$ 0,00”
imprimirBRL(3498.99) // “R$ 3.498,99”
imprimirBRL(-3498.99) // “-R$ 3.498,99”
imprimirBRL(2313477.0135) // “R$ 2.313.477,02”

OBS: note que o arredondamento sempre deve ser feito para cima, em caso de 
estourar a precisão de dois números
OBS: o separador decimal, no Brasil, é a vírgula
OBS: o separador milhar, no Brasil, é o ponto
*/

/*MARCOS*/

