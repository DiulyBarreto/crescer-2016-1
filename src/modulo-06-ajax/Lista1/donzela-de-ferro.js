function carregarImagensIronMaiden() {
  $('#carregarImagens').click(function() {
    $.ajax({url: 'https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50', type: 'GET'}).
    done(function(res) {
      var $lista = $('#capas');
      var albuns = res.items;
      albuns.forEach(function(album) {
        var capa = album.images[1];
        $lista.append($('<li>').append($('<img>').attr('src', capa.url)));
      });
    });

  });
};
carregarImagensIronMaiden();
