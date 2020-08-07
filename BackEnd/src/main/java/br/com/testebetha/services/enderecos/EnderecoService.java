package br.com.testebetha.services.enderecos;

import br.com.testebetha.models.enderecos.Endereco;
import br.com.testebetha.models.enderecos.QEndereco;
import br.com.testebetha.models.funcionarios.Funcionario;
import br.com.testebetha.repositorys.enderecos.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository repository;

    public Endereco save(Endereco endereco) throws ValidationException {
            verificaEndereco(endereco);
            return repository.save(endereco);
    }
    public Endereco save(Endereco endereco, Funcionario funcionario) throws ValidationException {
        endereco.setFuncionario(funcionario);
        return  this.save(endereco);
    }
    private void verificaEndereco(Endereco endereco) throws ValidationException {
        if(1 == 2 ){
            throw new ValidationException("impossiburu");
        }


    }

    public void deleteByFuncionarioId(Long id) {
        repository.deleteAll(repository.findAll(QEndereco.endereco.funcionario.id.eq(id)));
    }
}
