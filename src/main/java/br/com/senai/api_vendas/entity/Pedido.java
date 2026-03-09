package br.com.senai.api_vendas.entity;



import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @NotNull(message = "O campo data do pedido não pode ser vazio")
    private LocalDateTime data_pedido;

    @Positive(message = "O campo quantidade do pedido não pode ser negativo")
    private Integer quantidade_pedido;

    @NotNull(message = "O campo status do pedido não pode ser vazio")
    private Boolean status_pedido;

    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    @JsonIgnoreProperties("pedidos")
    private Cliente cliente;

   
    @ManyToMany(mappedBy = "pedidos")
    @JsonIgnoreProperties("pedidos")
    private List<Produtos> produtos;
   

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

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produtos> produtos) {
        this.produtos = produtos;
    }

    
    
}
