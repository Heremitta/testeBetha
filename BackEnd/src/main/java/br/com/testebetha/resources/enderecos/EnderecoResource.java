package br.com.testebetha.resources.enderecos;

import br.com.testebetha.models.enderecos.Endereco;
import br.com.testebetha.models.funcionarios.Funcionario;
import br.com.testebetha.models.enderecos.QEndereco;
import br.com.testebetha.services.enderecos.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.testebetha.repositorys.enderecos.EnderecoRepository;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping(path = "endereco")
public class EnderecoResource {


    @Autowired
    EnderecoRepository repository;

    @Inject
    EnderecoService service;

    @GetMapping
    public List<Endereco> getEnderecos(@PathParam(value = "FUNCIONARIO_ID") Long id){
        List<Endereco> enderecos = (List<Endereco>) repository.findAll(QEndereco.endereco.funcionario.id.eq(id));
        return enderecos;

    }
    public ResponseEntity save (@RequestBody Endereco endereco) throws ValidationException {
        return ResponseEntity.ok(service.save((endereco)));
    }

}
