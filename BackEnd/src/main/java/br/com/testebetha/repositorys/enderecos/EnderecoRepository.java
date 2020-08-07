package br.com.testebetha.repositorys.enderecos;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import br.com.testebetha.models.enderecos.Endereco;
import br.com.testebetha.models.enderecos.QEndereco;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco,Long>, QuerydslPredicateExecutor<Endereco>, QuerydslBinderCustomizer<QEndereco> {

    @Override
    default public void customize(QuerydslBindings bindings, QEndereco endereco) {
        bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
}
