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
            url: '/MarketPlaceKonrad/api/Roles/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var nombre = $('#nombre').val(data.nombreRol);
            

            var id = data.idRol;

            $('#botonCrear').text('Actualizar Usuario').click(function (event) {
                var nombre = $('#nombre').val();
               

                $.ajax({
                    url: '/MarketPlaceKonrad/api/Roles/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nombreRol: nombre,
                        idRol: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = '/MarketPlaceKonrad/rol.html';
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
                url: '/MarketPlaceKonrad/api/Roles',
                contentType: 'application/json',
                data: JSON.stringify({
                    nombreRol: nombre
                   
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/MarketPlaceKonrad/rol.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }


})(jQuery);

