var appCliente = angular.module("appCliente", ["ngRoute"]);


appCliente.config(function($routeProvider, $locationProvider){
    $routeProvider
        .when('/cliente', {templateUrl:'view/cliente.html', controller: 'cliente-controller'})
        .otherwise({redirectTo:'/'});
    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('!');
});
