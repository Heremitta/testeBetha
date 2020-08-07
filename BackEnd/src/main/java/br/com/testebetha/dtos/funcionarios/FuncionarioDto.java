package br.com.testebetha.dtos.funcionarios;

import br.com.testebetha.dtos.enderecos.EnderecoDto;
import br.com.testebetha.dtos.telefones.TelefoneDto;
import br.com.testebetha.models.enderecos.Endereco;
import br.com.testebetha.models.funcionarios.Funcionario;
import br.com.testebetha.models.telefones.Telefone;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.List;

public class FuncionarioDto {

    public FuncionarioDto(){

    }

    public FuncionarioDto(Funcionario funcionario, List<Endereco> enderecos, List<Telefone> telefones) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.cpf = funcionario.getCpf();
        this.dataNasc = funcionario.getDataNasc();
        this.enderecos = enderecos;
        this.telefones = telefones;
    }

    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNasc;
    private List<Telefone> telefones;
    private List<Endereco> enderecos;

    @JsonIgnore
    public Funcionario getFuncionario(){
        return new Funcionario(this.id, this.nome, this.cpf,this.dataNasc);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
