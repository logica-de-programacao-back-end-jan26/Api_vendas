package br.com.senai.api_vendas.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.api_vendas.entity.Avaliacoes;

public interface AvaliacoesRepository extends JpaRepository<Avaliacoes, Long> {
    
}
