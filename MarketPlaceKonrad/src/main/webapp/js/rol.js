(function ($){
    $(document).ready(function(event){
       $.ajax({
           url:'/MarketPlaceKonrad/api/Roles',
           method:'GET',
           contentType: 'application/json',
           dataType:'json'
       }).done(function(data){
           console.log(data);
           for(var i=0; i<data.length; i++){
               var tableRow = $('<tr>');
               //Divisiones de  las filas
               var nombre = $('<td>');
               nombre.text(data[i].nombreRol);
               
               
               
               
               var acciones = $('<td>');
               var botonEliminar = $('<button>').addClass('btn btn-danger');
               botonEliminar.text('Eliminar').attr('data-id' , data[i].idRol);
               botonEliminar.click(eliminar);
               
               var botonActualizar = $('<a href="/MarketPlaceKonrad/crearRol.html?id='+ data[i].idRol + '">').addClass('btn btn-primary');
               botonActualizar.text('Actualizar');
               acciones.append(botonEliminar);
               acciones.append(botonActualizar);
               
               tableRow.append(nombre);           
               tableRow.append(acciones);
               
               $('#tablaRoles table tbody').append(tableRow);
           }
           console.log(data);
       }).fail(function(xhr,status,error){
          console.log(error); 
       });
       
       function eliminar(event){
           console.log($(this).attr('data-id'));
           $.ajax({
               url:'/MarketPlaceKonrad/api/Roles/' + $(this).attr('data-id'),
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


