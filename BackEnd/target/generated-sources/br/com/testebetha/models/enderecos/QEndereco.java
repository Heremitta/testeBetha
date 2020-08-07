package br.com.testebetha.models.enderecos;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEndereco is a Querydsl query type for Endereco
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEndereco extends EntityPathBase<Endereco> {

    private static final long serialVersionUID = 830795173L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEndereco endereco = new QEndereco("endereco");

    public final br.com.testebetha.models.funcionarios.QFuncionario funcionario;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath logradouro = createString("logradouro");

    public final BooleanPath principal = createBoolean("principal");

    public QEndereco(String variable) {
        this(Endereco.class, forVariable(variable), INITS);
    }

    public QEndereco(Path<? extends Endereco> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEndereco(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEndereco(PathMetadata metadata, PathInits inits) {
        this(Endereco.class, metadata, inits);
    }

    public QEndereco(Class<? extends Endereco> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.funcionario = inits.isInitialized("funcionario") ? new br.com.testebetha.models.funcionarios.QFuncionario(forProperty("funcionario")) : null;
    }

}

