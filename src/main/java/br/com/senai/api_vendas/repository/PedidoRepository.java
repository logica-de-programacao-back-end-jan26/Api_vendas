package br.com.senai.api_vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.api_vendas.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
