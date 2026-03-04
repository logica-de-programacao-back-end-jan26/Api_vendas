package br.com.senai.api_vendas.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    
    @NotBlank(message = "O campo telefone não pode ser vazio")
    @Size(max = 15, message = "O telefone deve ter no máximo 15 caracteres")
    private String telefone;
    
    
    @NotBlank(message = "O campo email não pode ser vazio")
    @Size(max = 80, message = "O email deve ter no máximo 80 caracteres")
    private String email;
    
    
    @NotBlank(message = "O campo nome não pode ser vazio")
    @Size(max = 80, message = "O nome deve ter no máximo 80 caracteres")
    private String nome;
    
    
    @NotBlank(message = "O campo endereço não pode ser vazio")
    @Size(max = 255, message = "O endereço deve ter no máximo 255 caracteres")
    private String endereco;
    

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "cliente")
    private List<Avaliacoes> avaliacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Avaliacoes> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacoes> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    
}
