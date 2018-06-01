(function ($){
    $(document).ready(function(event){
       $.ajax({
           url:'/MarketPlaceKonrad/api/Usuarios',
           method:'GET',
           contentType: 'application/json',
           dataType:'json'
       }).done(function(data){
           console.log(data);
           for(var i=0; i<data.length; i++){
               var tableRow = $('<tr>');
               //Divisiones de  las filas
               var nombre = $('<td>');
               nombre.text(data[i].nombreUsuario);
               var apellido = $('<td>');
               apellido.text(data[i].apellidoUsuario);
               var Fechanacimiento = $('<td>');
               Fechanacimiento.text(data[i].fechaNacimiento);
               var telefono = $('<td>');
               telefono.text(data[i].TelefonoUsuario);
                var correo = $('<td>');
               correo.text(data[i].MailUsuario);
                var contraseña = $('<td>');
               contraseña.text(data[i].contraseñaUsuario);
                var avatar = $('<td>');
               avatar.text(data[i].avatar);
               var tipoDoc = $('<td>');
               tipoDoc.text(data[i].tipoDocumento);
               var Rol = $('<td>');
               Rol.text(data[i].rol);
               
               
               
               var acciones = $('<td>');
               var botonEliminar = $('<button>').addClass('btn btn-danger');
               botonEliminar.text('Eliminar').attr('data-id' , data[i].idUsuario);
               botonEliminar.click(eliminar);
               
               var botonActualizar = $('<a href="/MarketPlaceKonrad/crearUsuario.html?id='+ data[i].idUsuario + '">').addClass('btn btn-primary');
               botonActualizar.text('Actualizar');
               acciones.append(botonEliminar);
               acciones.append(botonActualizar);
               
               tableRow.append(nombre);
               tableRow.append(apellido);
               tableRow.append(Fechanacimiento);
               tableRow.append(telefono);
               tableRow.append(correo);
               tableRow.append(contraseña);
               tableRow.append(avatar);
               tableRow.append(tipoDoc);
               tableRow.append(Rol);
               tableRow.append(acciones);
               
               $('#tablaUsuarios table tbody').append(tableRow);
           }
           console.log(data);
       }).fail(function(xhr,status,error){
          console.log(error); 
       });
       
       function eliminar(event){
           console.log($(this).attr('data-id'));
           $.ajax({
               url:'/MarketPlaceKonrad/api/Usuarios/' + $(this).attr('data-id'),
            method:('DELETE'),
            contentType:'application/json',
            dataType:'json'
           }).done(function (data){
               console.log('eliminado correctamente');
               window.location.reload();
           }).fail(function (xhr,status,error){
               console.log(error);
           });
       }
       
       
       
       
       
       
    });
})(jQuery);



