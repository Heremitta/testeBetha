package br.com.testebetha.models.funcionarios;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@SelectBeforeUpdate
@DynamicUpdate
@Table(name = "FUNCIONARIOS")
public class Funcionario {

    public Funcionario(){

    }

    public Funcionario(Long id, String nome, String cpf, LocalDate dataNasc) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCIONARIO_SEQ")
    @SequenceGenerator(initialValue = 1,sequenceName = "FUNCIONARIO_SEQ",allocationSize = 1,  name = "FUNCIONARIO_SEQ")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate dataNasc;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }
}
