'use strict';

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

// Exercício 2
var maiorTexto = function(texto) {
  if(texto !== null) {
    maior = texto[0];
    for(var i = 1; i < texto.length; i++) {
      if(texto[i].length > maior.length)
        maior = texto[i];
    }
  }

  return maior;
}

// Testes exercício 2
array = null;
console.log(maiorTexto(array)); // deve imprimir undefinied
array = ["Adão", "Adão", "Adão"];
console.log("Maior texto: " + maiorTexto(array)); // deve imprimir "Adão"
array = [];
console.log(maiorTexto(array)); //deve imprimir undefinied
var array = ["Diuly", "Projeto Crescer", "Unisinos", "Teste Função Maior Texto"];
var maior = maiorTexto(array); // deve imprimir "Teste Função Maior Texto"
console.log("Maior texto: " + maior);


// Exercício 3
var imprime = function(array, fn) {
  if(typeof fn === 'function') {
    for(var i = 0; i < array.length; i++) {
      fn(array[i]);
    }
  }
}

// Testes exercício 3
imprime(
    // primeiro parâmetro: array
    [ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ],
    // segundo parâmetro: função
    function(instrutor) {
     console.log('olá querido instrutor:', instrutor)
    }
  );

imprime([ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ], 3.15); // deve imprimir "O tipo do segundo parametro não é função"
imprime([], function(instrutor) { console.log('olá querido instrutor:', instrutor)});


// Exercício 4
var somar = function(num1) {
  return function(num2) {
    return num1 + num2;
  }
}

// Testes exercício 4
console.log(somar(3)(4)); // imprimir 7

// Exercício 5
var fiboSum = function(x) {
  if(x === 2 || x ===1) {
    return 1;
  }

  return (fiboSum(x-1) + fiboSum(x-2));
}

// Testes exercício 5
console.log("FiboSum de 3: " + fiboSum(3)); // deve imprimir 2
console.log("FiboSum de 5: " + fiboSum(5)); // deve imprimir 5

// Exercício 6
var queroCafe = function(mascada, listaPrecos) {
  var precosBons = new Array();
  for(var i = 0; i < listaPrecos.length; i++) {
      if(listaPrecos[i] <= mascada)
        precosBons.push(listaPrecos[i]);

      }

  return precosBons.sort().toString();
}



// Testes exercício 6
var valores = queroCafe(3.14, [5.16, 2.12, 1.15, 3.11, 17.5]); // '1.15,2.12,3.11'
console.log(valores);

valores = queroCafe(2, [0, 78, -12, 7, '1', '2']); // -12,0,1,2
console.log(valores);

valores = queroCafe(12, []); // imprime nada
console.log(valores);

// Exercício 7 - CORREÇÃO INSTRUTORES
function contarPorTipo(obj, tipo) {
  function getType(value) {
     return value === null ? 'null' : typeof value !== 'undefined' && value.constructor === Array ? 'array' : typeof value;
  }

  var cont = 0;
  for(var i in obj) {
    if(getType(obj[i]) === tipo)
      cont++;
  }

  return cont;
}

// Testes exercício 7
var goku = { nome: 'Goku', classe: 'Saiyajin', humano: false, saiyajin: true };
console.log(contarPorTipo(goku, 'string')); // imprimir 2

goku = { nome: 'Goku', classe: 'Saiyajin', ki: 999500, humano: false, saiyajin: true };
console.log(contarPorTipo(goku, 'number')); // imprimir 1

goku = { nome: 'Goku', classe: 'Saiyajin', humano: false, saiyajin: true };
console.log(contarPorTipo(goku, 'boolean')); // imprimir 2

goku = { nome: 'Goku', classe: { descricao: 'Saiyajin' }, anoNascimento: new Date(1987, 1, 1), humano: false, filhos: [ 'Gohan', 'Goten' ], golpes: [ 'Kamehameha', 'Genki-dama' ] };
console.log(contarPorTipo(goku, 'object')); // imprimir 2

goku = { nome: 'Goku', classe: undefined, anoNascimento: undefined, humano: undefined };
console.log(contarPorTipo(goku, 'undefined')); // imprimir 3

goku = { nome: 'Goku', classe: null, anoNascimento: new Date(1987, 1, 1), humano: undefined };
console.log(contarPorTipo(goku, 'null')); // imprimir 1

goku = { nome: 'Goku', classe: null, anoNascimento: undefined, kamehameha: function() {} };
console.log(contarPorTipo(goku, 'function')); // imprimir 1

goku = { nome: 'Goku', kaioken: undefined, classe: null, anoNascimento: new Date(1987, 1, 1), kamehameha: function() {}, filhos: [ 'Gohan', 'Goten' ], golpes: [ 'Kamehameha', 'Genki-dama' ] };
console.log(contarPorTipo(goku, 'array')); // imprimir 2
