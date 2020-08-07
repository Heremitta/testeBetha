package br.com.testebetha.repositorys.telefones;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import br.com.testebetha.models.telefones.QTelefone;
import br.com.testebetha.models.telefones.Telefone;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;

public interface TelefoneRepository extends CrudRepository<Telefone,Long>, QuerydslPredicateExecutor<Telefone>, QuerydslBinderCustomizer<QTelefone> {

    @Override
    default public void customize(QuerydslBindings bindings, QTelefone telefone) {
        bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
}
