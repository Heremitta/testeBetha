package br.com.testebetha.services.telefones;

import br.com.testebetha.models.funcionarios.Funcionario;
import br.com.testebetha.models.telefones.QTelefone;
import br.com.testebetha.models.telefones.Telefone;
import br.com.testebetha.repositorys.telefones.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneService {

    @Autowired
    TelefoneRepository repository;

    public Telefone save(Telefone telefone){
        verificaTelefone(telefone);
        return repository.save(telefone);
    }
    public Telefone save(Telefone telefone, Funcionario funcionario){
        telefone.setFuncionario(funcionario);
        return this.save(telefone);
    }
    private void verificaTelefone(Telefone telefone) {
    }

    public void deleteByFuncionarioId(Long id) {
        repository.deleteAll(repository.findAll(QTelefone.telefone.funcionario.id.eq(id)));
    }
}
