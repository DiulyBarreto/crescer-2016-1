function carregarImagensIronMaiden() {
  $('#carregarImagens').click(function() {
    $.ajax({url: 'https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50', type: 'GET'}).
    done(function(res) {
      var $lista = $('#capas');
      var albuns = res.items;
      albuns.forEach(function(album) {
        album.images.forEach(function(capa) {
          $lista.append($('<li>').append($('<img width=300px height=300px>').attr('src', capa.url)));
        });
      });
    });

  });
};

carregarImagensIronMaiden();
