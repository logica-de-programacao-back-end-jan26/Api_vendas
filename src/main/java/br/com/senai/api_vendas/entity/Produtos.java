package br.com.senai.api_vendas.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Produtos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   
    @NotBlank(message = "O campo nome não pode ser vazio")
    @Size(max = 80, message = "O nome deve ter no máximo 80 caracteres")
    private String nome;
    
    @NotBlank(message = "O campo descrição não pode ser vazio")
    private int preco;

    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos;

    @ManyToOne(mappedBy = "produtos")
    private List<Avaliacoes> avaliacoes;

    @ManyToOne
    @JoinColumn(name = "fk_categoria")
    private Categorias categoria;

}
