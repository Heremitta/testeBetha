package br.com.testebetha.models.telefones;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import br.com.testebetha.models.funcionarios.Funcionario;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Data
@Entity
@SelectBeforeUpdate
@DynamicUpdate
@Table(name = "TELEFONES")
public class Telefone {

    public Telefone(){

    }

    public Telefone(Long id, Boolean principal, String numero, Funcionario funcionario) {
        this.id = id;
        this.principal = principal;
        this.numero = numero;
        this.funcionario = funcionario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TELEFONE_SEQ")
    @SequenceGenerator(initialValue = 1,sequenceName = "TELEFONE_SEQ",allocationSize = 1,  name = "TELEFONE_SEQ")
    private Long id;

    @Column
    private Boolean principal = false;

    @Column
    private String numero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "FUNCIONARIO_ID")
    @JsonIgnore
    private Funcionario funcionario;

}
