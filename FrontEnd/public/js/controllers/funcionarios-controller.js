angular.module('projetobetha').controller('FuncionariosController', function($scope,recursoFuncionario, recursoExcluirFuncionario,$rootScope) {
    debugger;
    if($scope.logado) window.location.href = 'http://localhost:3000/login';
    console.log($rootScope.logado)
    $scope.funcionarios = [];
    $scope.telefones = [{ numero:"", principal: true}];
    $scope.enderecos = [{logradouro:"", principal: true}];
    $scope.filtro = '';
    $scope.mensagem = '';
    $scope.isDisabled = true;
    recursoFuncionario.query(function(funcionarios){
        funcionarios.forEach(funcionario => {
            $scope.funcionarios.push(funcionario)
        });
        // console.log($scope.funcionarios)
    })
    $scope.remover = function(funcionario){
        recursoExcluirFuncionario.delete({id : funcionario.id}, function(){
            var indiceFuncionario = $scope.funcionarios.indexOf(funcionario);   
            $scope.funcionarios.splice(indiceFuncionario,1);
            $scope.mensagem = 'Funcionario ' + funcionario.nome + ' foi removido com sucesso!';
        }, function(erro){
            console.log(erro);
            $scope.mensagem = 'Não foi possivel remover funcionario ' + funcionario.nome;
        });


    }
    $scope.alterarFuncionario = function(funcionario){
        recursoFuncionario.alterar(funcionario,function(result){
            debugger
            $scope.mensagem = 'Funcionario ' + funcionario.nome + ' foi alterado com sucesso!';
        }, function(erro){
            console.log(erro);
            $scope.mensagem = 'Não foi possivel alterar funcionario ' + funcionario.nome;
        })
    }
    $scope.botaoAlterar = function(){
        $scope.isDisabled = !$scope.isDisabled;
    }

  });