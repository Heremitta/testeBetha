package br.com.testebetha.repositorys.usuarios;

import br.com.testebetha.models.usuarios.QUsuario;
import br.com.testebetha.models.usuarios.Usuario;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario,Long>, QuerydslPredicateExecutor<Usuario>, QuerydslBinderCustomizer<QUsuario> {
    @Override
    default public void customize(QuerydslBindings bindings, QUsuario usuario) {
        bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::eq);
    }


}
