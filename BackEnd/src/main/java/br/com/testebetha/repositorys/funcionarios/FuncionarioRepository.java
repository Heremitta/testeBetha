package br.com.testebetha.repositorys.funcionarios;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import br.com.testebetha.models.funcionarios.Funcionario;
import br.com.testebetha.models.funcionarios.QFuncionario;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario,Long>, QuerydslPredicateExecutor<Funcionario>, QuerydslBinderCustomizer<QFuncionario> {

    @Override
    default public void customize(QuerydslBindings bindings, QFuncionario funcionario) {
        bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }

}
