package br.com.senai.api_vendas.entity;



import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PastOrPresent(message = "A data do pedido deve ser no presente")
    @NotBlank(message = "O campo data do pedido não pode ser vazio")
    private LocalDateTime data_pedido;

    @NotBlank(message = "O campo quantidade do pedido não pode ser vazio")
    private Integer quantidade_pedido;

    @NotBlank(message = "O campo status do pedido não pode ser vazio")
    private Boolean status_pedido;

    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "fk_produto")
    private Produtos produto;

    @ManyToMany(mappedBy = "Pedidos_produtos")
    Set<Produtos> produtos;
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(LocalDateTime data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Integer getQuantidade_pedido() {
        return quantidade_pedido;
    }

    public void setQuantidade_pedido(Integer quantidade_pedido) {
        this.quantidade_pedido = quantidade_pedido;
    }

    public Boolean getStatus_pedido() {
        return status_pedido;
    }

    public void setStatus_pedido(Boolean status_pedido) {
        this.status_pedido = status_pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    
    
}
