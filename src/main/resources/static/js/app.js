var appCliente = angular.module("appCliente", ["ngRoute"]);


appCliente.config(function($routeProvider, $locationProvider){
    $routeProvider
        .when('/clientes', {templateUrl:'view/cliente.html', controller: 'cliente-controller'})
        .when('/cidades', {templateUrl:'view/cidade.html', controller: 'cidade-controller'})
        .when('/estados', {templateUrl:'view/estado.html', controller: 'estado-controller'})
        .otherwise({redirectTo:'/'});
    
    $locationProvider.html5Mode(true);
});
