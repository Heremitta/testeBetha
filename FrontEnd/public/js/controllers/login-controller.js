angular.module('projetobetha').controller('LoginController', function($scope, LoginService ,$rootScope) {

    $scope.logado = false;
    $scope.login = {};
    $rootScope = $scope.logado;
    $scope.mensagem = '';   
    $scope.submeterLogin = function(){ 
        var login = $scope.login;
        $scope.validaEmail = '';
        if($scope.formulario.$valid){

            if(LoginService.validaEmail(login.email)){
                debugger;
                LoginService.logar(login)
                .then(function(dados) {
                    debugger
                    $scope.mensagem = dados.mensagem;
                    $scope.logado = dados.logado;
                })
                .catch(function(dados) {
                    $scope.mensagem = dados.mensagem;
                })
            }else{
                $scope.validaEmail = "E-mail inválido";
            }

        }
    }

    $scope.novoLogin = function(){
        $scope.validaEmail = '';
        if($scope.formulario.$valid){
            if(LoginService.validaEmail($scope.login.usuario)){
                LoginService.cadastrar($scope.login)
                .then(function(dados){
                    $scope.mensagem = dados.mensagem;
                    $scope.logado = dados.logado;
                })
                .catch(function(dados){
                    $scope.mensagem = dados.mensagem;
                })
            }else{
                $scope.validaEmail = "E-mail inválido";
            }
        }

    }


});