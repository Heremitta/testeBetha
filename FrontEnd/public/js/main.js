var logado = false;
angular.module('projetobetha', ['minhasDiretivas','ngAnimate','ngRoute','meusServicos'])
.config(function($routeProvider, $locationProvider){

    $locationProvider.html5Mode(true);
 
    $routeProvider.when('/login',{
        templateUrl:'partials/login.html',
        controller:'LoginController'
    })

    $routeProvider.when('/login/novo',{
        templateUrl:'partials/login-novo.html',
        controller:'LoginController'
    })

    $routeProvider.when('/funcionarios',{
        templateUrl:'partials/funcionarios.html',
        controller:'FuncionariosController'
    })
    $routeProvider.when('/funcionarios/novo',{
        templateUrl:'partials/funcionarios-novo.html',
        controller:'FuncionariosCadastroController'
    })
    
    $routeProvider.otherwise({redirectTo:'/funcionarios'});
})