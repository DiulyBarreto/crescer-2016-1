
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
