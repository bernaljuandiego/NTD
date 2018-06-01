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
            url: '/MarketPlaceKonrad/api/residencias/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var nombre = $('#nombre').val(data.nombreResidencia);
            var direccion = $('#direccion').val(data.DireccionResidencia);
            var usuario = $('#usuario').val(data.usuario);
            var ciudad = $('#ciudad').val(data.ciudad);
            

            var id = data.codResidencia;

            $('#botonCrear').text('Actualizar Residencia').click(function (event) {
                var nombre = $('#nombre').val();
                var direccion = $('#direccion').val();
                var usuario = $('#usuario').val();
                var ciudad = $('#ciudad').val();

                $.ajax({
                    url: '/MarketPlaceKonrad/api/residencias/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nombreResidencia: nombre,
                        DireccionResidencia : direccion ,
                        usuario: usuario,
                        ciudad : ciudad ,
                        codResidencia : id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = '/MarketPlaceKonrad/residencia.html';
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
                var direccion = $('#direccion').val();
                var usuario = $('#usuario').val();
                var ciudad = $('#ciudad').val();
            
            $.ajax({
                url: '/MarketPlaceKonrad/api/residencias',
                contentType: 'application/json',
                data: JSON.stringify({
                    nombreResidencia: nombre,
                        DireccionResidencia : direccion ,
                        usuario: usuario,
                        ciudad : ciudad 
                   
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/MarketPlaceKonrad/residencia.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }


})(jQuery);

