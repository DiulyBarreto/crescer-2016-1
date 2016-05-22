'use strict';

function carregarDadosNaPagina() {
    $.ajax({ url: urlCavaleiroGet, type: 'GET'/*, timeout: 2000 */ })
    .then(
        function onSuccess(res) {
            console.log(res.data);
            var $cavaleiros = $('#cavaleiros');
            res.data.forEach(function (cava) {
                $cavaleiros.append(
                    criarHtmlCavaleiro(cava)
                );
            });
        },
        function onError(res) {
            console.error(':(');
            console.error(res);

            var criarSpanComErro = function (msg) {
                return $('<span>').text(msg).addClass('erro');
            };

            $('#feedback')
            .append(criarSpanComErro(res.status))
            .append($('<br>'))
            .append(criarSpanComErro(res.statusText));
        }
    )
    .always(function (res) {
        console.log('acabouuuuuuuu');
    });
};
carregarDadosNaPagina();

function criarHtmlCavaleiro(cava) {
    return $('<li>')
        .append(cava.Nome)
        .append(
            $('<button>')
                .attr('data-cavaleiro-id', cava.Id)
                .click(editarCavaleiroNoServidor)
                .text('Editar')
        )
        .append(
            $('<button>')
                .attr('data-cavaleiro-id', cava.Id)
                .click(excluirCavaleiroNoServidor)
                .text('Excluir')
        );
    // <button data-cavaleiro-id="7" onclick='excluirCavaleiroNoServidor();'>Excluir</button>
}

function criarCavaleiroNoServidor(cavaleiro) {
    $.ajax({
        url: urlCavaleiroPost,
        type: 'POST',
        data: cavaleiro
    }).done(function (res) {
            $.get('/Cavaleiro/GetById', { id: res.id })
                .done(function (detalhe) {
                    cavaleiro = detalhe.data;
                });
        });
}


function excluirCavaleiroNoServidor() {
    var cavaleiroId = parseInt($(this).attr('data-cavaleiro-id'));
    $.ajax({
        url: '/Cavaleiro/Delete' /*+  $.param({ id: cavaleiroId }),*/,
        type: 'DELETE',
        data: { id: cavaleiroId }
    });
};

function editarCavaleiroNoServidor() {
    var cavaleiroId = parseInt($(this).attr('data-cavaleiro-id'));

    $.get('/Cavaleiro/GetById', { id: cavaleiroId })
        .done(function (detalhe) {
            // TODO: Implementar atualização a partir de um formulário ou campos na tela, e não hard-coded
            cavaleiroHardCoded = detalhe.data;
            cavaleiroHardCoded.Nome = 'Novo nome após update ' + new Date().getTime();
            cavaleiroHardCoded.AlturaCm = 205;
            cavaleiroHardCoded.Signo = 3;
            cavaleiroHardCoded.TipoSanguineo = 2;
            // Estamos enviando a data UTC (sem timezone) para que seja corretamente armazenada e posteriormente exibida de acordo com o fuso-horário da aplicação cliente que consumir os dados
            cavaleiroHardCoded.DataNascimento = new Date(Date.UTC(2010, 9, 10)).toISOString();
            if (cavaleiroHardCoded.Golpes.length > 0) {
                cavaleiroHardCoded.Golpes[0] = cavaleiroHardCoded.Golpes[0] || {};
                cavaleiroHardCoded.Golpes[0].Nome = 'Voadora do Sub-Zero Brasileiro'
                cavaleiroHardCoded.Golpes[1] = cavaleiroHardCoded.Golpes[1] || {};
                cavaleiroHardCoded.Golpes[1].Nome = 'Cólera dos 42 dragões';
                cavaleiroHardCoded.Golpes[2] = { Nome: 'Novo golpe aterrador' };
            }
            cavaleiroHardCoded.LocalNascimento.Texto = 'Porto Alegre';
            cavaleiroHardCoded.LocalTreinamento.Texto = 'Alvorada';
            if (cavaleiroHardCoded.Imagens.length > 0) {
                cavaleiroHardCoded.Imagens[0] = cavaleiroHardCoded.Imagens[0] || {};
                cavaleiroHardCoded.Imagens[0].Url = 'https://cloud.githubusercontent.com/assets/526075/15443404/5c97dde6-1ebe-11e6-8ae6-83372051dda7.png';
                cavaleiroHardCoded.Imagens[0].IsThumb = true;
                cavaleiroHardCoded.Imagens[1] = cavaleiroHardCoded.Imagens[1] || {};
                cavaleiroHardCoded.Imagens[1].Url = 'https://cloud.githubusercontent.com/assets/526075/15443410/6e9ba586-1ebe-11e6-8b90-64aca9e18a32.png';
                cavaleiroHardCoded.Imagens[1].IsThumb = false;
            }

            $.ajax({
                url: '/Cavaleiro/Put',
                type: 'PUT',
                data: cavaleiroHardCoded
            });
        });
};


$(function () {
    
    // Adicionando campos para imagens
    var $novasImagens = $('#novasImagens');

    $('#btnAdicionarImg').click(function () {
        var $novoLi = gerarElementoLiComInputs();
        $novasImagens.append($novoLi);
    });

    $('#btnAdicionarGolpe').click(function () {
        $('#novosGolpes').append(gerarElementoLiComInputTexto());
    });

    var $frmNovoCavaleiro = $('#frmNovoCavaleiro');
    $frmNovoCavaleiro.submit(function (e) {
        var cavaleiro = converterFormParaCavaleiro($frmNovoCavaleiro);
        criarCavaleiroNoServidor(cavaleiro);
        $frmNovoCavaleiro[0].reset();

        return e.preventDefault();
    });

});



/*.done(function (res) {
    console.log(res.data);
        var $cavaleiros = $('#cavaleiros');
        res.data.forEach(function (cava) {
            $cavaleiros.append(
                $('<li>').append(cava.Nome)
            );
        });
})
.fail(function (res) {
    console.error(':(');
    console.error(res);

    var criarSpanComErro = function (msg) {
        return $('<span>').text(msg).addClass('erro');
    };

    $('#feedback')
    .append(criarSpanComErro(res.status))
    .append($('<br>'))
    .append(criarSpanComErro(res.statusText));
});*/

