angular.module('projetobetha').controller('FuncionariosCadastroController', function($scope,recursoFuncionario, recursoExcluirFuncionario) {
    
    $scope.funcionarios = [];
    $scope.funcionario = {};
    $scope.telefones = [{ numero:"", principal: true}];
    $scope.enderecos = [{logradouro:"", principal: true}];
    $scope.mensagem = '';

    $scope.submeter = function(funcionario){
        
        funcionario.cpf = funcionario.cpf.toString();
        funcionario.telefones = $scope.telefones;
        funcionario.enderecos = $scope.enderecos;
        if(funcionarioIsValido(funcionario)){
            recursoFuncionario.cadastrar(funcionario, function(result){ 
                funcionario.id = result.id;
                $scope.funcionarios.push(funcionario);
                $scope.mensagem = 'Funcionario ' + funcionario.nome + ' Cadastrado com sucesso!';
            }, function(erro){
                console.log(erro);
                $scope.mensagem = 'Não foi possivel cadastrar o funcionario ' + funcionario.nome;
            });
        }
    }
    $scope.adicionarEndereco = function(){
        $scope.enderecos.push({});
    }
    $scope.removerEndereco = function(item){
        $scope.enderecos.splice(item,1);

    }
    $scope.adicionarTelefone = function(){
        $scope.telefones.push({});
    }
    $scope.removerTelefone = function(item){
        $scope.telefones.splice(item,1);

    }
    $scope.checkB = function(classe){
        debugger
        checkBoxs = document.querySelectorAll("."+classe);
        checkBoxs.forEach(elemento =>{
            if(elemento.checked == true){
                elemento.checked == false;
            }
        })
    }

    function funcionarioIsValido(funcionario){
        return validaContainsEndereco(funcionario) && validaContainsTelefone(funcionario) && validaCpf(funcionario)
    }

    function validaContainsEndereco(funcionario){
        return true

    } 
    
    function validaContainsTelefone(funcionario){
        return true

    }
    function validaCpf(funcionario){
        return true

    }
    

  });