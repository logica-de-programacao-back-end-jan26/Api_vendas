package br.com.senai.api_vendas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Avaliacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @NotBlank(message = "O campo nota não pode ser vazio")
    @Size(min = 1, max = 5, message = "A nota deve ser entre 1 e 5")
    private Integer  nota;
    
    @NotBlank(message = "O campo comentário não pode ser vazio")
    @Size(max = 200, message = "O comentário deve ter no máximo 255 caracteres")
    private String comentario;


    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    @JsonIgnoreProperties("cliente")
    private Cliente cliente;


    @ManyToOne
    @JoinColumn(name = "fk_produto")
    @JsonIgnoreProperties("produtos")
    private Produtos produtos;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Integer getNota() {
        return nota;
    }


    public void setNota(Integer nota) {
        this.nota = nota;
    }


    public String getComentario() {
        return comentario;
    }


    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Produtos getProdutos() {
        return produtos;
    }


    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }
}
