let moedas = (function () {
    //Tudo é Privado
    function imprimirMoeda(params) {
        function arredondar(numero, precisao = 2) {
            const fator = Math.pow(10, precisao);
            return Math.ceil(numero * fator) / fator;
        }
        const {
            numero,
            separadorMilhar,
            separadorDecimal,
            colocarMoeda,
            colocarNegativo
        } = params
        let qtdCasasMilhares = 3
        let StringBuffer = []
        let parteDecimal = arredondar(Math.abs(numero) % 1)
        let parteInteira = Math.trunc(numero)
        let parteInteiraString = Math.abs(parteInteira).toString()
        let parteInteiraTamanho = parteInteiraString.length
        let c = 1 //while para por o separador de milhar
        while (parteInteiraString > 0) {
            if (c % qtdCasasMilhares == 0) {
                StringBuffer.push(`${separadorMilhar}${parteInteiraString.slice( parteInteiraTamanho - c)}`)
                parteInteiraString = parteInteiraString.slice(0, parteInteiraTamanho - c)
            } else if (parteInteiraString.length < qtdCasasMilhares) {
                StringBuffer.push(parteInteiraString)
                parteInteiraString = ''
            }
            c++
        }
        StringBuffer.push(parteInteiraString)
        let decimalString = parteDecimal.toString().replace('0.', '').padStart(2, 0)
        const numeroFormatado = `${StringBuffer.reverse().join('')}${separadorDecimal}${decimalString}`
        return parteInteira >= 0 ? colocarMoeda(numeroFormatado) : colocarNegativo(numeroFormatado);
    }

    //Tudo é Publico
    return {
        imprimirBRL: (numero) =>
            imprimirMoeda({
                numero,
                separadorMilhar: '.',
                separadorDecimal: ',',
                colocarMoeda: numeroFormatado => `R$ ${ numeroFormatado }`,
                colocarNegativo: numeroFormatado => `-R$ ${ numeroFormatado }`
            }),
        imprimirGBP: (numero) =>
            imprimirMoeda({
                numero,
                separadorMilhar: ',',
                separadorDecimal: '.',
                colocarMoeda: numeroFormatado => `£ ${ numeroFormatado }`,
                colocarNegativo: numeroFormatado => `-£ ${ numeroFormatado }`
            }),
        imprimirFR: (numero) =>
            imprimirMoeda({
                numero,
                separadorMilhar: '.',
                separadorDecimal: ',',
                colocarMoeda: numeroFormatado => `${ numeroFormatado } €`,
                colocarNegativo: numeroFormatado => `-${ numeroFormatado } €`
            })
    }
})()

console.log(moedas.imprimirBRL(4.651));
console.log(moedas.imprimirBRL(0));
console.log(moedas.imprimirBRL(3498.99));
console.log(moedas.imprimirBRL(-3498.99));
console.log(moedas.imprimirBRL(2313477.0135));

console.log(moedas.imprimirGBP(0));
console.log(moedas.imprimirGBP(3498.99));
console.log(moedas.imprimirGBP(-3498.99));
console.log(moedas.imprimirGBP(2313477.0135));

console.log(moedas.imprimirFR(0));
console.log(moedas.imprimirFR(3498.99));
console.log(moedas.imprimirFR(-3498.99));
console.log(moedas.imprimirFR(2313477.0135));
