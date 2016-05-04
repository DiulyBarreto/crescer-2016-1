
describe('Ex 1. Doadores de Sangue!', function() {
  it('Retorna os cavaleiros que possuem tipo sanguineo = O ', function() {
    expect(obterDoadores()).toEqual([goldSaints[4], goldSaints[8], goldSaints[11]]);
  });
});

describe('Ex2. Canivete suíço!', function() {
  it('Retorna o cavaleiro com mais golpes', function() {
    expect(obterCavaleiroComMaisGolpes()).toEqual(goldSaints[5]);
  });
});

describe('Ex4. Altura média !', function() {
  it('Retorna a altura media dos cavaleiros em metros', function() {
    expect(obterAlturaMedia()).toEqual(1.86);
  });
});

describe('Ex5. Altura mediana !', function() {
  it('Retorna a altura mediana dos cavaleiros em metros', function() {
    expect(obterAlturaMediana()).toEqual(1.85);
  });
});

describe('Ex6.a. Peso Médio !', function() {
  it('Retorna o peso médio dos cavaleiro em kg', function() {
    expect(obterPesoMedio()).toEqual(84.27);
  });
});

describe('Ex6.b. Peso Médio doadores de Sangue !', function() {
  it('Retorna o peso médio dos cavaleiro que podem doar em kg', function() {
    expect(obterPesoMedioDoadores()).toEqual(80.67);
  });
});

describe('Ex7. IMC !', function() {
  it('Retorna o IMC dos cavaleiros que possuem peso registrado', function() {
    expect(obterIMC()).toEqual([22.64, 29.48, 24.62, 24.22, 24.84, 20.53, 24.54, 24.31, 23.99, 22.45, 21.50]);
  });
});

describe('Ex8. Sobrepeso !', function() {
  it('Retorna os cavaleiros que estão acima do peso', function() {
    expect(obterSobrepeso()).toEqual([goldSaints[1]]);
  });
});
