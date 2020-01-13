var appCliente = angular.module("appCliente", []);

appCliente.controller("cliente-controller", function($scope, $http) {
    
    $scope.nome = "gabriel";
    $scope.sobrenome = "martins";
    $scope.clientes = [];
    $scope.cliente = {};


    $scope.listarClientes = function() {
        $http({
            method:'GET',
            url:'http://localhost:8080/clientes'
                
        }).then(function(response) {
            $scope.clientes = response.data;
            
        }, function(response) {
            console.log(response.status);
            
        });
    };
    
    $scope.listarClientes();
    
    $scope.salvarCliente = function() {
        
        var verbo = ($scope.cliente.id == null) ? "POST" : "PUT";
        
        $http({
            method: verbo,
            url:'http://localhost:8080/clientes',
            data:$scope.cliente
                
        }).then(function(response) {
            $scope.listarClientes();
            $scope.limpar();
            
        }, function(response) {
            console.log(response.status);
            console.log(response.data);
            
        }); 
    };
    
    $scope.excluirCliente = function(cliente) {
        $http({
            method:'DELETE',
            url:'http://localhost:8080/clientes/' + cliente.id
                
        }).then(function(response) {
            $scope.clientes.splice($scope.clientes.indexOf(cliente), 1);
            
        }, function(response) {
            console.log(response.status);
            
        }); 
    };
    
    $scope.preEdit = function(cliente) {
        $scope.cliente = angular.copy(cliente);
    };
    
    $scope.limpar = function() {
        $scope.cliente = {};  
    };
    
});
