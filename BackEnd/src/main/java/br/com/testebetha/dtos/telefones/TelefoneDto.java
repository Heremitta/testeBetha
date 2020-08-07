package br.com.testebetha.dtos.telefones;

import br.com.testebetha.models.funcionarios.Funcionario;

import br.com.testebetha.models.telefones.Telefone;
import br.com.testebetha.repositorys.telefones.TelefoneRepository;


import java.util.Optional;

public class TelefoneDto {

    public TelefoneDto(){

    }

    public TelefoneDto(Long id, Boolean principal, String numero, Funcionario funcionario) {
        this.id = id;
        this.principal = principal;
        this.numero = numero;
        this.funcionario = funcionario;
    }

    private Long id;
    private Boolean principal;
    private String numero;
    private Funcionario funcionario;

    public Telefone getTelefone(){
        return new Telefone(this.id,this.principal,this.numero,this.funcionario);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
