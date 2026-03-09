package br.com.senai.api_vendas.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Produtos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   
    @NotBlank(message = "O campo nome não pode ser vazio")
    @Size(max = 80, message = "O nome deve ter no máximo 80 caracteres")
    private String nome;
    
    @Positive(message = "O campo preço não pode ser vazio")
    private Integer preco;

    @ManyToMany
    @JoinTable(
        name = "Pedidos_produtos",
        joinColumns = @JoinColumn(name = "fk_produto"),
        inverseJoinColumns = @JoinColumn(name = "fk_pedido")
    )
    @JsonIgnoreProperties("produtos")
    private List<Pedido> pedidos;
    

    @OneToMany(mappedBy = "produtos")
    @JsonIgnoreProperties("produtos")
    private List<Avaliacoes> avaliacoes;

    @ManyToOne
    @JoinColumn(name = "fk_categoria")
    @JsonIgnoreProperties("produtos")
    private Categorias categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    

    public List<Avaliacoes> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacoes> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
