/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

'use-strict';

$(function () {
    var form = $('#formCidade');
    form.unbind().submit(function(e) {
        var cidade = criarCidade(form);
        salvar(cidade);
    });
    
    $("input[data-id]").unbind().click(function(e) {
        excluir($(this).attr('data-id'));
    });
});

function criarCidade($form) {
    var formData = new FormData($form[0]);
    return {
        nomeCidade: formData.get('nome'),
        uf: formData.get('uf')
    };
};

function salvar(cidade) {
    $.ajax({
        url: '/rest/cidade/save',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({nomeCidade: cidade.nomeCidade, uf: cidade.uf}),
        dataType: 'json'
    });
}

function excluir(id) {
    var idCidade = parseInt(id);
    console.log(idCidade);
    $.ajax({
        url: '/rest/cidade/delete',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({idCidade: idCidade, nomeCidade: null, uf: null}),
        dataType: 'json'
    }).done($('input[data-id=' + id + ']').parents('tr').remove());
}
