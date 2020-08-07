angular.module('minhasDiretivas', [])
    .directive('meuPainel', function(){
        var ddo = {};
        ddo.restrict = "AE"; 

        ddo.scope = {
            titulo : '@'
        };
        ddo.transclude = true;
        ddo.templateUrl = 'js/directives/templates/meu-painel.html';

        return ddo;
    }).directive('meuBotaoPerigo', function(){
        var ddo = {};
       ddo.restrict = "E";

       ddo.scope = {
           nome: '@',
           acao: '&'
       }
       ddo.template = '<button ng-click="acao(foto)" class="btn btn-danger btn-block apagar">{{nome}}</button>'

        return ddo;
    })
    .directive('telefones', function(){
        var ddo = {};
        ddo.restrict = "E"; 

        ddo.scope = {
            telefone : '=',
            acao : '&',
            remove : '=',
            check : '='
        };
        ddo.transclude = true;
        ddo.templateUrl = 'js/directives/templates/telefones.html';

        return ddo;
    })
    .directive('enderecos', function(){
        var ddo = {};
        ddo.restrict = "E"; 

        ddo.scope = {
            endereco : '=',
            acao : '&',
            remove : '=',
            check : '='
        };
        ddo.transclude = true;
        ddo.templateUrl = 'js/directives/templates/enderecos.html';

        return ddo;
    })