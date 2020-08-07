package br.com.testebetha.resources.funcionarios;

import br.com.testebetha.dtos.funcionarios.FuncionarioDto;
import br.com.testebetha.models.funcionarios.QFuncionario;
import br.com.testebetha.models.funcionarios.Funcionario;
import br.com.testebetha.services.funcionarios.FuncionarioService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.testebetha.repositorys.funcionarios.FuncionarioRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping(path = "funcionario")
public class FuncionarioResource {

    @Autowired
    FuncionarioRepository repository;

    @Inject
    FuncionarioService service;


    @PostMapping
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity saveCompleto(@RequestBody FuncionarioDto dto){
        return ResponseEntity.ok(service.saveDto(dto));
    }

    @GetMapping
    public ResponseEntity getCompleto(){
        return ResponseEntity.ok(service.getCompleto());
    }

    @GetMapping(path = "buscaid")
    public ResponseEntity getFuncionario(@PathParam(value = "id")Long id){
        Optional<Funcionario> funcionario = repository.findOne(QFuncionario.funcionario.id.eq(id));
        return ResponseEntity.ok(funcionario.isPresent()?funcionario.get():null);
    }
    @GetMapping(path = "list")
    public ResponseEntity getFuncionario(@QuerydslPredicate(root = Funcionario.class) Predicate predicate){
        return ResponseEntity.ok(repository.findAll(predicate));
    }

    @PostMapping(path = "outro")
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity saveFuncionario(@RequestBody Funcionario funcionario){
        return ResponseEntity.ok(service.save(funcionario));
    }

    @DeleteMapping
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity excluirFuncionario(@PathParam(value = "id") Long id){
        try{
            service.deleteById(id);
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok().build();
    }
    @PutMapping
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity alterarFuncionario(@RequestBody FuncionarioDto dto){
        return ResponseEntity.ok(service.saveDto(dto));
    }
}
