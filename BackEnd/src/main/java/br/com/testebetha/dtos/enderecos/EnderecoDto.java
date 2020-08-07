package br.com.testebetha.dtos.enderecos;

import br.com.testebetha.models.enderecos.Endereco;
import br.com.testebetha.models.funcionarios.Funcionario;

public class EnderecoDto {

    public EnderecoDto(){

    }

    public EnderecoDto(Long id, Boolean principal, String logradouro, Funcionario funcionario) {
        this.id = id;
        this.principal = principal;
        this.logradouro = logradouro;
        this.funcionario = funcionario;
    }

    private  Long id;
    private Boolean principal;
    private String logradouro;
    private Funcionario funcionario;

    public Endereco getEndereco(){
        return new Endereco(this.id,this.principal,this.logradouro,this.funcionario);
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String endereco) {
        this.logradouro = endereco;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
