package br.com.senai.api_vendas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.senai.api_vendas.entity.Avaliacoes;
import br.com.senai.api_vendas.exception.Response;
import br.com.senai.api_vendas.repository.AvaliacoesRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacoesController {

    @Autowired
    private AvaliacoesRepository Repository;

    @PostMapping
    public Response cadastrarAvaliacao(@Valid @RequestBody Avaliacoes avaliacao) {
       Repository.save(avaliacao);
       return new Response(201, "Avaliação cadastrada com sucesso!");  
        
    }

    @GetMapping
    public List<Avaliacoes> getALLAvaliacoes() {
        return Repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizarAvaliacao(@PathVariable long id, @RequestBody Avaliacoes novo) {
        if(!Repository.existsById(id)) {
            return new Response(404, "Avaliação não encontrada!");
        }
        Avaliacoes avaliacao = Repository.findById(id).get();

        if(novo.getNota()!= null) {
            avaliacao.setNota(novo.getNota());
        } 
        if(novo.getComentario() != null) {
            avaliacao.setComentario(novo.getComentario());
        }
        if (novo.getCliente() != null) {
            avaliacao.setCliente(novo.getCliente());
        }
        
        Repository.save(avaliacao);
        return new Response(200, "Avaliação atualizada com sucesso!");
    }

    @DeleteMapping("/{id}")
    public Response deletarAvaliacao(@PathVariable long id) {
        if(!Repository.existsById(id)) {
            return new Response(404, "Avaliação não encontrada!");
        }
        Repository.deleteById(id);
        return new Response(204, "Avaliação deletada com sucesso!");
    }
}