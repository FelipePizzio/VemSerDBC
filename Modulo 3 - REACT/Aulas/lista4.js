/* Exercício 01

Criar uma função que receba um multiplicador e vários valores a serem multiplicados, o retorno deve ser um array!
Ex.:
multiplicar(5, 3, 4) // [15, 20]   
multiplicar(5, 3, 4, 5) // [15, 20, 25]

function multiplicar(mult, ...valores){
    return valores.map( valor => mult * valor);
}
*/
function multiplicar(...valores) {
    let resultado = [];
    for (i = 1; i < valores.length; i++) {
        resultado[i - 1] = valores[0] * valores[i];
    }
    return resultado;
}
/* console.log(multiplicar(5, 3, 4));
console.log(multiplicar(5, 3, 4, 5)); */

/*
Exercício 02

Criar um formulário de contato no site de vocês (Nome, email, telefone, assunto), 
ao sair do input de nome tem que garantir que tenha no minimo 10 caracteres, 
garantir que em email tenha @ e ao clicar no botão de enviar tem que garantir que não tenha campos em branco.
*/

function validacao(e) {
    let target = e.target;
    let msg = '';
    switch (target.name) {
        case "nome":
            if (target.value == '') {
                msg = "Esse campo não pode ser vazio"
            }
            break;
        case "email":
            if (target.value.indexOf('@') == -1 || target.value.indexOf('.') == -1 || target.value == '') {
                msg = "Esse campo deve conter um email valido"
            }
            break;
        default:
            break;
    }
    let erro = document.getElementById(`msg-erro-${target.name}`)
    erro.innerHTML = msg;
}
let vazio = document.getElementsByClassName('vazio');
for (let i = 0; i < vazio.length; i++) {
    vazio[i].addEventListener('blur', (e) => validacao(e));
}

/* let inputName = document.getElementById('name')
inputName.addEventListener('blur', () => {
    if (inputName.value == "" || inputName.value.length < 10) {
        alert("Nome deve ter no minimo 10 caracteres");
        return false;
    }
});

let inputEmail = document.getElementById('email')
inputEmail.addEventListener('blur', () => {
    if (inputEmail.value.indexOf("@") == -1 || inputEmail.value.indexOf(".") == -1 ||
        inputEmail.value == "") {
        alert("Deve ser um Email valido");
        return false;
    }
}); */