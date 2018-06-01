var productoModule = angular.module('productoModule');
//Asociar el controlador al modulo
productoModule.controller('crearEditartoProduCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        var id = $state.params.id;

        if(id){
            $http.get('api/producto/'+id).then(function(response){
                $scope.producto = response.data;
            }, function(error){
               console.log(error);
            });
        }
        
        $scope.producto = {};

        $scope.crearProducto = function () {
            if ($scope.producto.nomProducto && $scope.producto.valorUnitario && $scope.producto.garantia && $scope.producto.stockDisponible &&$scope.producto.tipoProducto.codTipoProducto && $scope.producto.marca.codMarca && $scope.producto.proveedor.nitProovedor) {
                $http.post('api/producto', JSON.stringify($scope.producto)).then(function (response) {
                    $scope.producto = {};
                    $state.go('listarProducto');
                }, function (error) {
                    console.log(error);
                });
            }
        };

        $scope.editarProducto = function () {
            if ($scope.producto.nomProducto && $scope.producto.valorUnitario && $scope.producto.garantia && $scope.producto.stockDisponible &&$scope.producto.tipoProducto.codTipoProducto && $scope.producto.marca.codMarca && $scope.producto.proveedor.nitProovedor) {
                $http.put('api/producto/' + id, JSON.stringify($scope.producto)).then(function (response) {
                    $scope.producto = {};
                    $state.go('listarProducto');
                }, function (error) {
                    console.log(error);
                });
            }
        }
    }]);
