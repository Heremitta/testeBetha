package br.com.testebetha.models.usuarios;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;


import javax.persistence.*;


@Data
@Entity
@SelectBeforeUpdate
@DynamicUpdate
@Table(name = "USUARIOS")
public class Usuario {
    public Usuario(){

    }
    public Usuario(Long id, String nome, String email, String senha) {
        this.setId(id);
        this.email = email;
        this.senha = senha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
    @SequenceGenerator(initialValue = 1,sequenceName = "USUARIO_SEQ",allocationSize = 1,  name = "USUARIO_SEQ")
    private Long id;


    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

}
