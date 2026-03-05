package br.com.senai.api_vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.api_vendas.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
