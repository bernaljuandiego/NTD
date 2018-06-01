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
            url: '/MarketPlaceKonrad/api/Paises/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var nombre = $('#nombre').val(data.nombrePais);
            

            var id = data.codPais;

            $('#botonCrear').text('Actualizar Pais').click(function (event) {
                var nombre = $('#nombre').val();
               

                $.ajax({
                    url: '/MarketPlaceKonrad/api/Paises/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nombrePais : nombre,
                        codPais: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = '/MarketPlaceKonrad/pais.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            })
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var nombre = $('#nombre').val();
            
            $.ajax({
                url: '/MarketPlaceKonrad/api/Paises',
                contentType: 'application/json',
                data: JSON.stringify({
                    nombrePais: nombre
                   
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/MarketPlaceKonrad/pais.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }


})(jQuery);


