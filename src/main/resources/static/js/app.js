var appCliente = angular.module("appCliente", []);

appCliente.controller("index-controller", function($scope, $http) {
    
    $scope.nome = "gabriel";
    $scope.sobrenome = "martins";
    
    $http({
        method:'GET',
        url:'http://localhost:8080/clientes'
            
    }).then(function(response) {
        $scope.clientes = response.data;
        
    }, function(response) {
        console.log(response.status);
        
    });
    
});
