function buscarArtista() {
  $('#buscarArtista').click(function() {
    var $artista = $('input:text').val();
    console.log($artista);
      $.ajax({url: 'https://api.spotify.com/v1/search?q='+$artista+'&type=artist',type: 'GET'}).done(function(artistaEncontrado) {
        var artista = artistaEncontrado.artists;
        console.log(artista);
        artista.items.forEach(function(item) {
          var id = item.id;
          $.ajax({url: 'https://api.spotify.com/v1/artists/'+id+'/albums?limit=50', type: 'GET'}).done(function(res) {
            var $lista = $('#capas');
            var albuns = res.items;
            albuns.forEach(function(album) {
              var capa = album.images[1];
              $lista.append($('<li>').append($('<img>').attr('src', capa.url)));
            });
          });
        });

      });

  });
};
buscarArtista();
