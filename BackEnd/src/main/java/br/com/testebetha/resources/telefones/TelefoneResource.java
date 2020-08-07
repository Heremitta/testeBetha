package br.com.testebetha.resources.telefones;

import br.com.testebetha.models.funcionarios.Funcionario;
import br.com.testebetha.models.funcionarios.QFuncionario;
import br.com.testebetha.models.telefones.QTelefone;
import br.com.testebetha.models.telefones.Telefone;
import br.com.testebetha.services.telefones.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.testebetha.repositorys.telefones.TelefoneRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "telefone")
public class TelefoneResource {

    @Autowired
    TelefoneRepository repository;

    @Inject
    TelefoneService service;

    @GetMapping
    public List<Telefone> getTelefones(@PathParam(value = "id") Long id){
        List<Telefone> telefone = (List<Telefone>) repository.findAll(QTelefone.telefone.funcionario.id.eq(id));
        return telefone;
    }

    @PostMapping
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity save(@RequestBody Telefone telefone){
        return ResponseEntity.ok(service.save(telefone));
    }

}
