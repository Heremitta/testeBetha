package br.com.testebetha.models.funcionarios;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFuncionario is a Querydsl query type for Funcionario
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFuncionario extends EntityPathBase<Funcionario> {

    private static final long serialVersionUID = -781888803L;

    public static final QFuncionario funcionario = new QFuncionario("funcionario");

    public final StringPath cpf = createString("cpf");

    public final DatePath<java.time.LocalDate> dataNasc = createDate("dataNasc", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public QFuncionario(String variable) {
        super(Funcionario.class, forVariable(variable));
    }

    public QFuncionario(Path<? extends Funcionario> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFuncionario(PathMetadata metadata) {
        super(Funcionario.class, metadata);
    }

}

