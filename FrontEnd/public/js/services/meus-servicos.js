angular.module('meusServicos', ['ngResource'])
.factory('recursoLogin',function($resource){

    return $resource = $resource('http://localhost:8080/api/usuario', null,{
        logar: {
            method: 'GET'
        },
        cadastrar:{
            method: 'POST'
        }
    })
})
.factory('LoginService', function(recursoLogin, $q, $rootScope){

    var vm = this;

    var evento = 'Logado';

    vm.logar = function(login) {
        return $q(function(resolve, reject) {
                recursoLogin.logar({email : login.email, senha: login.senha }, function(){
                    $rootScope.$broadcast(evento);
                    resolve({
                        mensagem: 'Logado com sucesso!',
                        logado: true
                    });
                },function(erro) {
                    console.log(erro);
                    reject({
                        mensagem : 'Não foi possivel efetuar login!'
                    });
                })
        });
    }
    vm.cadastrar = function(login){
        return $q(function(resolve, reject){
            recursoLogin.cadastrar({email: login.usuario, senha: login.senha}, function(){
                $rootScope.$broadcast(evento);
                resolve({
                    mensagem: 'Cadastro efetuado com sucesso!',
                    logado: true
                });
            }, function(erro){
                console.log(erro);
                reject({
                    mensagem: 'Não foi possivel efetuar o cadastro!'
                })
            })

        })
    }

    vm.validaEmail = function validacaoEmail(field) {
        var usuario = field.substring(0, field.indexOf("@"));
        var dominio = field.substring(field.indexOf("@")+ 1, field.length);
        if ((usuario.length >=1) &&
            (dominio.length >=3) && 
            (usuario.search("@")==-1) && 
            (dominio.search("@")==-1) &&
            (usuario.search(" ")==-1) && 
            (dominio.search(" ")==-1) &&
            (dominio.search(".")!=-1) &&      
            (dominio.indexOf(".") >=1)&& 
            (dominio.lastIndexOf(".") < dominio.length - 1)) {
            return true
        }
        else{
            return false
        }
    }
    return vm;
})
.factory('recursoFuncionario',function($resource){

    return $resource = $resource('http://localhost:8080/api/funcionario', null,{
        buscar: {
            method: 'GET'
        },
        cadastrar:{
            method: 'POST'
        },
        alterar:{
            method: 'PUT'
        },
    })
})
.factory('recursoExcluirFuncionario',function($resource){

    return $resource = $resource('http://localhost:8080/api/funcionario', null);
})
.factory('FuncionarioService',function(recursoFuncionario, $q, $rootScope){

    var vm = this;

    var evento = 'Funcionario';

    vm.cadastrar = function(funcionario) {
        return $q(function(resolve, reject) {
                if(vm.validaCPF(funcionario.cpf)){
                    recursoFuncionario.cadastrar({nome : funcionario.nome, cpf : funcionario.cpf, data_nasc: funcionario.dataNasc, telefones: funcionario.telefones, enderecos: funcionario.enderecos}, function(){
                        $rootScope.$broadcast(evento);
                        resolve({
                            mensagem: 'Funcionario cadastrado com sucesso!',
                            logado: true
                        });
                    },function(erro) {
                        console.log(erro);
                        reject({
                            mensagem : 'Não foi possivel efetuar login!'
                        });
                    })
                }
        });
    }
    vm.validaCPF = function(cpf) {
        if (typeof cpf !== "string") return false
        cpf = cpf.replace(/[\s.-]*/igm, '')
        if (
            !cpf ||
            cpf.length != 11 ||
            cpf == "00000000000" ||
            cpf == "11111111111" ||
            cpf == "22222222222" ||
            cpf == "33333333333" ||
            cpf == "44444444444" ||
            cpf == "55555555555" ||
            cpf == "66666666666" ||
            cpf == "77777777777" ||
            cpf == "88888888888" ||
            cpf == "99999999999" 
        ) {
            return false
        }
        var soma = 0
        var resto
        for (var i = 1; i <= 9; i++) 
            soma = soma + parseInt(cpf.substring(i-1, i)) * (11 - i)
        resto = (soma * 10) % 11
        if ((resto == 10) || (resto == 11))  resto = 0
        if (resto != parseInt(cpf.substring(9, 10)) ) return false
        soma = 0
        for (var i = 1; i <= 10; i++) 
            soma = soma + parseInt(cpf.substring(i-1, i)) * (12 - i)
        resto = (soma * 10) % 11
        if ((resto == 10) || (resto == 11))  resto = 0
        if (resto != parseInt(cpf.substring(10, 11) ) ) return false
        return true
    }
    
})