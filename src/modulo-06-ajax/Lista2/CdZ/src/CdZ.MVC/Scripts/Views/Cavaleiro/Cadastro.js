'use strict';




function converterFormParaCavaleiro($form) {

    // Obtém o objeto nativo Form através da posição 0 no objeto jQuery e cria um FormData a partir dele
    var formData = new FormData($form[0]);

    var novasImagens = [];
    $('#novasImagens li').each(function (/*i, e*/) {
        novasImagens.push({
            url: $(this).find('input[name=urlImagem]').val(),
            isThumb: $(this).find('input[name=isThumb]').is(':checked')
        });
    });

    var novosGolpes = [];
    $('#novosGolpes li').each(function (i) {
        novosGolpes.push({Nome: $(this).find('input[name=golpe]').val()});
    });

    var localNasc = { Texto: formData.get('localNascimento') };
    var localTrein = { Texto: formData.get('localTreinamento')};

    return {
        nome: formData.get('nome'),
        tipoSanguineo: formData.get('tipoSanguineo'),
        imagens: novasImagens,
        // toISOString: https://developer.mozilla.org/pt-BR/docs/Web/JavaScript/Reference/Global_Objects/Date/toISOString
        dataNascimento: formData.get('dataNascimento'),
        alturaCm: parseFloat(formData.get('alturaMetros')) * 100,
        pesoLb: parseFloat(formData.get('pesoKg')) * 2.20462262,
        signo: formData.get('signo'),
        localNascimento: localNasc,
        localTreinamento: localTrein,
        golpes: novosGolpes
    };

};

function renderizarCavaleiroNaTela(cavaleiro) {
    var $img = $('<img>').attr('src', obterThumb(cavaleiro).url);
    $('#cavaleiros')
      .append(
        $('<li>').append(
          $img.fadeIn()
        )
      );
    htmlHelpers.adicionarBtnExcluir(cavaleiro.id, $img);
};

function gerarElementoLiComInputs() {
    var $novoTxt = $('<input>').attr('name', 'urlImagem').attr('type', 'text').attr('placeholder', 'Ex: bit.ly/shiryu.png');
    var $novoCheckbox =
      // Dentro de um label para pode vincular o texto ao checkbox
      $('<label>').append(
        $('<input>')
        .attr('type', 'checkbox')
        .attr('name', 'isThumb')
        .attr('checked', 'checked')
      ).append('É thumbnail?');
    return $('<li>').append($novoTxt).append($novoCheckbox);
};

function gerarElementoLiComInputTexto() {
    var $novoTxt = $('<input>').attr('name', 'golpe').attr('type', 'text').attr('placeholder', 'Ex: Pó de diamante');
    return $('<li>').append($novoTxt);
};

function obterThumb(cavaleiro) {
    // Pegando a primeira imagem que é thumbnail
    var resultado = cavaleiro.imagens.filter(function (i) {
        return i.isThumb;
    });
    // url padrão caso não tenha foto
    var thumbnailPadrao = { url: 'https://i.ytimg.com/vi/trKzSiBOqt4/hqdefault.jpg', isThumb: true };
    return resultado.length > 0 ? resultado[0] : thumbnailPadrao;
};
