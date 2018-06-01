//Llamar la aplicacion creada en app.js
var app = angular.module("productos");

app.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider){
    
    $urlRouterProvider.otherwise('/');
    
    $stateProvider.state("listarProductos",{
       url: '/producto',
       //donde se publica
       views: {
           mainView:{
               templateUrl: './js/producto/listar/listarProducto.html',
               controller: 'listarProductoCtrl'
           }
       }
    });
    
    $stateProvider.state("producto",{
       url:'/producto', 
       views:{
           mainView:{
               templateUrl: './js/producto/crearEditar/crearEditarProducto.html',
               controller: 'crearEditarProductoCtrl'
           }
       }
    });
    
    $stateProvider.state("editarProducto",{
       url:'/producto/:id', 
       views:{
           mainView:{
               templateUrl: './js/producto/crearEditar/crearEditarProducto.html',
               controller: 'crearEditarProductoCtrl'
           }
       }
    });
    
}]);