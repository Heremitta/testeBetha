
package br.com.testebetha.resources.usuarios;

        import br.com.testebetha.models.usuarios.Usuario;
        import br.com.testebetha.models.usuarios.QUsuario;
        import br.com.testebetha.models.telefones.Telefone;
        import br.com.testebetha.repositorys.usuarios.UsuarioRepository;
        import com.querydsl.core.types.Predicate;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.querydsl.binding.QuerydslPredicate;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import javax.inject.Inject;
        import javax.transaction.Transactional;
        import javax.websocket.server.PathParam;
        import java.util.Optional;

@RestController
@RequestMapping(path = "usuario")
public class UsuariosResource {

    @Autowired
    UsuarioRepository repository;

//    @Inject
//    UsuarioService service;

    @GetMapping
    public ResponseEntity getUsuario(@QuerydslPredicate(root = Usuario.class) Predicate predicate){
        Optional<Usuario> usuario =  repository.findOne(predicate);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity save(@RequestBody Usuario usuario){
        return ResponseEntity.ok(repository.save(usuario));
    }

}
