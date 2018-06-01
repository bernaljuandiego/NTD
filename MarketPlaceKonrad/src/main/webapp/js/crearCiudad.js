(function ($) {
    var getUrlParameter = function getUrlParameter(sParam) {
        var sPageUrl = decodeURIComponent(window.location.search.substring(1)),
                sURLVariables = sPageUrl.split('&'),
                sParameterName,
                i;
        for (var i = 0; i < sURLVariables.length; i++) {
            sParameterName = sURLVariables[i].split('=');
            if (sParameterName[0] === sParam) {
                return sParameterName[1] === undefined ? true : sParameterName[1];
            }
        }
    };

    if (getUrlParameter('id')) {
        $.ajax({
            url: '/MarketPlaceKonrad/api/ciudades/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var ciudad = $('#ciudad').val(data.nomCiudad);
            var pais = $('#pais').val(data.pais);
            

            var id = data.codCiudad;

            $('#botonCrear').text('Actualizar Ciudad').click(function (event) {
                var ciudad = $('#ciudad').val();
                var pais = $('#pais').val();
               

                $.ajax({
                    url: '/MarketPlaceKonrad/api/ciudades/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nomCiudad : ciudad,
                        pais : pais ,
                        codCiudad: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = '/MarketPlaceKonrad/ciudad.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            })
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var ciudad = $('#ciudad').val();
            var pais = $('#pais').val();
            
            $.ajax({
                url: '/MarketPlaceKonrad/api/ciudades',
                contentType: 'application/json',
                data: JSON.stringify({
                    nomCiudad: ciudad,
                    pais : pais
                   
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/MarketPlaceKonrad/ciudad.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }


})(jQuery);



