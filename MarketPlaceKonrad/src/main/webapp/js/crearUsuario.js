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
            url: '/MarketPlaceKonrad/api/Usuarios/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var nombre = $('#nombre').val(data.nombreUsuario);
            var apellido = $('#apellido').val(data.apellidoUsuario);
            var fechanacimiento = $('#fecha_nacimiento').val(data.fechaNacimiento);
            var telefono = $('#telefono').val(data.TelefonoUsuario);
            var correo = $('#correo').val(data.MailUsuario);
            var contraseña = $('#contraseña').val(data.contraseñaUsuario);
            var avatar = $('#avatar').val(data.avatar);
            var tipodoc = $('#tdocumento').val(data.tipoDocumento);
            var rol = $('#rol').val(data.rol);

            var id = data.idUsuario;

            $('#botonCrear').text('Actualizar Usuario').click(function (event) {
                var nombre = $('#nombre').val();
                var apellido = $('#apellido').val();
                var fechanacimiento = $('#fecha_nacimiento').val();
                var telefono = $('#telefono').val();
                var correo = $('#correo').val();
                var contraseña = $('#contraseña').val();
                var avatar = $('#avatar').val();
                var tipodoc = $('#tdocumento').val();
                var rol = $('#rol').val();

                $.ajax({
                    url: '/MarketPlaceKonrad/api/Usuarios/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nombreUsuario: nombre,
                        apellidoUsuario: apellido,
                        fechaNacimiento: fechanacimiento,
                        TelefonoUsuario: telefono,
                        MailUsuario: correo,
                        contraseñaUsuario: contraseña,
                        avatar: avatar,
                        tipoDocumento: tipodoc,
                        rol: rol,
                        idUsuario: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = '/MarketPlaceKonrad/usuario.html';
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
            var apellido = $('#apellido').val();
            var fechanacimiento = $('#fecha_nacimiento').val();
            var telefono = $('#telefono').val();
            var correo = $('#correo').val();
            var contraseña = $('#contraseña').val();
            var avatar = $('#avatar').val();
            var tipodoc = $('#tdocumento').val();
            var rol = $('#rol').val();
            $.ajax({
                url: '/MarketPlaceKonrad/api/Usuarios',
                contentType: 'application/json',
                data: JSON.stringify({
                    nombreUsuario: nombre,
                    apellidoUsuario: apellido,
                    fechaNacimiento: fechanacimiento,
                    TelefonoUsuario: telefono,
                    MailUsuario: correo,
                    contraseñaUsuario: contraseña,
                    avatar: avatar,
                    tipoDocumento : tipodoc,
                    rol : rol
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/MarketPlaceKonrad/usuario.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }


})(jQuery);

