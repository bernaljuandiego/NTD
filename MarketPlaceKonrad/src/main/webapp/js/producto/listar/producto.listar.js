var productoModule = angular.module('productoModule');

productoModule.controller('listarProductoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state){
    
    $scope.productos = new Array();
    
    $http.get('api/producto').then(function (response){
        console.log(response);
        $scope.productos = response.data;
    }, function (error){
       console.log(error); 
    });
      
    $scope.eliminar= function(id){
        
       $http.delete('api/producto/' + id).then(function (response){
           $state.reload();
       }, function(error){
           console.log(error);
       });
    }
}]);