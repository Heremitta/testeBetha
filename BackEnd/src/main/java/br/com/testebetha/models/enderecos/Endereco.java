package br.com.testebetha.models.enderecos;

import br.com.testebetha.models.funcionarios.QFuncionario;
import br.com.testebetha.models.telefones.Telefone;
import br.com.testebetha.repositorys.enderecos.EnderecoRepository;
import br.com.testebetha.repositorys.telefones.TelefoneRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import br.com.testebetha.models.funcionarios.Funcionario;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.websocket.server.PathParam;
import java.util.List;

@Data
@Entity
@SelectBeforeUpdate
@DynamicUpdate
@Table(name = "ENDERECOS")
public class Endereco {

    public Endereco(){

    }

    public Endereco(Long id, Boolean principal, String endereco, Funcionario funcionario) {
        this.id = id;
        this.principal = principal;
        this.logradouro = endereco;
        this.funcionario = funcionario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(initialValue = 1,sequenceName = "ENDERECO_SEQ",allocationSize = 1,  name = "ENDERECO_SEQ")
    private Long id;

    @Column
    private Boolean principal = false;

    @Column(nullable = false)
            private String logradouro;

    @ManyToOne(optional = false)
    @JoinColumn(name = "FUNCIONARIO_ID")
    @JsonIgnore
    private Funcionario funcionario;



}
