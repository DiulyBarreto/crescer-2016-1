function buscarArtistaDeVerdade() {
  $('#buscarArtistaDeVerdade').click(function() {
    var $artista = $('input:text').val();
    var id;
    $.ajax({url: 'https://api.spotify.com/v1/search?q='+$artista+'&type=artist',type: 'GET'}).done(function(artistaEncontrado) {
        var artista = artistaEncontrado.artists;
        id = artista.items[0].id;

        if($artista.toLowerCase() === "justin bieber") {
          var sorteio = (Math.random() * 10);
          console.log(sorteio);
          if (sorteio > 2) {
              id = "douchebag";
          }
        }

        $.ajax({url: 'https://api.spotify.com/v1/artists/'+id+'/albums?limit=50', type: 'GET'}).then(function onSucess(res) {
          var $lista = $('#capas');
          var albuns = res.items;
          albuns.forEach(function(album) {
            var capa = album.images[1];
            $lista.append($('<li>').append($('<img>').attr('src', capa.url)));
          });
        },
        function onError(res) {
          alert("Caro usuário, devido a um erro <"+res.status+">, não foi possível pesquisar por "+"<"+$artista+">");
        });
  });
});
};
buscarArtistaDeVerdade();
