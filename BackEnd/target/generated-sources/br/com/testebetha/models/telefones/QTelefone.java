package br.com.testebetha.models.telefones;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTelefone is a Querydsl query type for Telefone
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTelefone extends EntityPathBase<Telefone> {

    private static final long serialVersionUID = 1926119079L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTelefone telefone = new QTelefone("telefone");

    public final br.com.testebetha.models.funcionarios.QFuncionario funcionario;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath numero = createString("numero");

    public final BooleanPath principal = createBoolean("principal");

    public QTelefone(String variable) {
        this(Telefone.class, forVariable(variable), INITS);
    }

    public QTelefone(Path<? extends Telefone> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTelefone(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTelefone(PathMetadata metadata, PathInits inits) {
        this(Telefone.class, metadata, inits);
    }

    public QTelefone(Class<? extends Telefone> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.funcionario = inits.isInitialized("funcionario") ? new br.com.testebetha.models.funcionarios.QFuncionario(forProperty("funcionario")) : null;
    }

}

