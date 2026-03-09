package br.com.senai.api_vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.api_vendas.entity.Produtos;
import br.com.senai.api_vendas.exception.Response;
import br.com.senai.api_vendas.repository.ProdutosRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    

    @Autowired
    private ProdutosRepository repository;

    @PostMapping
    public Response cadastrarProdutos(@Valid @RequestBody Produtos produtos){
        repository.save(produtos);
        return new Response(201, "Produto cadastrado com sucesso");
    }

    @GetMapping
    public List<Produtos> getALLProdutos(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizarProdutos(@PathVariable Long id, @Valid @RequestBody Produtos novo){
      if (!repository.existsById(id)) {
        return new Response(404, "Produto não encontrado!");
      }

      Produtos produto = repository.findById(id).get();

      if (novo.getNome() != null) {
        produto.setNome(novo.getNome());
      }
      if (novo.getPreco() != null) {
        produto.setPreco(novo.getPreco());
      }
      
        repository.save(produto);
        return new Response(200, "Produto atualizado com sucesso");
        
      }

      @DeleteMapping("/{id}")
      public Response deletarProdutos(@PathVariable Long id){
        if (!repository.existsById(id)) {
          return new Response(404, "Produto não encontrado!");
        }
        repository.deleteById(id);
        return new Response(200, "Produto deletado com sucesso");
      }
    }

