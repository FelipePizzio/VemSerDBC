function cardapioIFood(veggie = true, comLactose = true) {
  const cardapio = [
    'enroladinho de salsicha',
    'cuca de uva'
  ]
  if ( comLactose ) {
    cardapio.push('pastel de queijo');
  }
  cardapio.push('pastel de carne', 'empada de legumes marabijosa');
  if (veggie) {
    cardapio.splice(cardapio.indexOf('enroladinho de salsicha'), 1)
    cardapio.splice(cardapio.indexOf('pastel de carne'), 1)
  }
  let resultadoFinal = cardapio.map(alimento => alimento.toUpperCase());
  return resultadoFinal;
}
console.log(cardapioIFood()); // esperado: [ 'CUCA DE UVA', 'PASTEL DE QUEIJO', 'EMPADA DE LEGUMES MARABIJOSA' ]