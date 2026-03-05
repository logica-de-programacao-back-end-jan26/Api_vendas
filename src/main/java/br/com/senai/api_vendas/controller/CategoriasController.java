package br.com.senai.api_vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.api_vendas.entity.Categorias;
import br.com.senai.api_vendas.exception.Response;
import br.com.senai.api_vendas.repository.CategoriasRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasRepository Repository;

    @PostMapping
    public Response cadastrarCategoria(@Valid @RequestBody Categorias categoria) {
       Repository.save(categoria);
       return new Response(201, "Categoria cadastrada com sucesso!"); 
    }

    @GetMapping
    public List<Categorias> getALLCategorias() {
        return Repository.findAll();
    }
    @PutMapping("/{id}")
    public Response atualizarCategoria(@PathVariable long id, @RequestBody Categorias novo) {
        if(!Repository.existsById(id)) {
            return new Response(404, "Categoria não encontrada!");
        }
        Categorias categoria = Repository.findById(id).get();
        if (novo.getDescricao() != null) {
            categoria.setDescricao(novo.getDescricao());
        }
        if (novo.getNome()!=null) {
            categoria.setNome(novo.getNome());
        }
        Repository.save(categoria);
        return new Response(200, "Categoria atualizada com sucesso!");
    }
    @DeleteMapping("/{id}")
    public Response deletarCategoria(@PathVariable long id) {
        if(!Repository.existsById(id)) {
            return new Response(404, "Categoria não encontrada!");
        }
        Repository.deleteById(id);
        return new Response(204, "Categoria deletada com sucesso!");
    }
}
