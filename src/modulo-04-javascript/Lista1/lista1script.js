
// Exercício 1
var daisyGame = function(numero) {
  if(numero % 2 === 0) {
    console.log('Love me not.');
  }else {
    console.log('Love me.');
  }
}

// Testes exercício 1
daisyGame(4); // deve imprimir 'Love me not'.
daisyGame(7); // deve imprimir 'Love me'.
daisyGame('6'); // deve imprimir 'Love me not'.
daisyGame('1'); // deve imprimir 'Love me'.
