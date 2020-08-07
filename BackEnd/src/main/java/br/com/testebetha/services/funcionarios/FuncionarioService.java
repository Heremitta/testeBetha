package br.com.testebetha.services.funcionarios;


import br.com.testebetha.dtos.funcionarios.FuncionarioDto;
import br.com.testebetha.models.enderecos.Endereco;
import br.com.testebetha.models.enderecos.QEndereco;
import br.com.testebetha.models.funcionarios.Funcionario;
import br.com.testebetha.models.funcionarios.QFuncionario;
import br.com.testebetha.models.telefones.QTelefone;
import br.com.testebetha.models.telefones.Telefone;
import br.com.testebetha.repositorys.enderecos.EnderecoRepository;
import br.com.testebetha.repositorys.funcionarios.FuncionarioRepository;
import br.com.testebetha.repositorys.telefones.TelefoneRepository;
import br.com.testebetha.services.enderecos.EnderecoService;
import br.com.testebetha.services.telefones.TelefoneService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.swing.text.html.parser.Entity;
import javax.xml.bind.ValidationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository repository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    TelefoneRepository telefoneRepository;

    @Inject
    TelefoneService telefoneService;

    @Inject
    EnderecoService enderecoService;

    public Funcionario save(Funcionario funcionario){
        verificaFuncionario(funcionario);
        return repository.save(funcionario);
    }

    public Funcionario saveDto(FuncionarioDto dto){
        Funcionario funcionario = this.save(dto.getFuncionario());

        if(dto.getTelefones() != null && !CollectionUtils.isEmpty(dto.getTelefones())){
            dto.getTelefones().forEach(telefone -> telefoneService.save(telefone,funcionario));
        }

        if(dto.getEnderecos() != null && !CollectionUtils.isEmpty(dto.getEnderecos())){
            dto.getEnderecos().forEach(endereco -> {
                try {
                    enderecoService.save(endereco,funcionario);
                } catch (ValidationException e) {
                    e.printStackTrace();
                }
            });
        }

        return funcionario;
    }

    public FuncionarioDto getCompletoById(Long id){
        QEndereco qEndereco = QEndereco.endereco;
        QTelefone qTelefone = QTelefone.telefone;
        Funcionario funcionario = repository.findById(id).get();
        List<Endereco> enderecos = (List<Endereco>) enderecoRepository.findAll(qEndereco.funcionario.id.eq(id));
        List<Telefone> telefones = (List<Telefone>) telefoneRepository.findAll(qTelefone.funcionario.id.eq(id));

        return new FuncionarioDto(funcionario,enderecos,telefones);
    }

    public List<FuncionarioDto> getCompleto(){
        List<Funcionario> funcionarios = (List<Funcionario> ) repository.findAll();
        List<Endereco> enderecos = (List<Endereco>) enderecoRepository.findAll();
        List<Telefone> telefones = (List<Telefone>) telefoneRepository.findAll();
        List<FuncionarioDto> listaDtos = new ArrayList();
        funcionarios.forEach(funcionario -> listaDtos.add(new FuncionarioDto(funcionario,
                                enderecos.stream().filter(endereco -> endereco.getFuncionario().getId().equals(funcionario.getId())).collect(Collectors.toList()),
                                telefones.stream().filter(telefone -> telefone.getFuncionario().getId().equals(funcionario.getId())).collect(Collectors.toList()))));

        return listaDtos;
    }
    private void verificaFuncionario(Funcionario funcionario) {
    }

    public void deleteById(Long id) {
        enderecoService.deleteByFuncionarioId(id);
        telefoneService.deleteByFuncionarioId(id);
        repository.deleteById(id);
    }
}
