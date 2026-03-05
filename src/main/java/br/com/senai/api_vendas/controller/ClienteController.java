package br.com.senai.api_vendas.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.senai.api_vendas.entity.Cliente;
import br.com.senai.api_vendas.exception.Response;
import br.com.senai.api_vendas.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository Repository;

    @PostMapping
    public Response cadastrarCliente(@Valid @RequestBody Cliente cliente) {
       Repository.save(cliente);
       return new Response(201, "Cliente cadastrado com sucesso!"); 
    }

    @GetMapping
    public List<Cliente>getAllClientes(){
        return Repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizarCliente(@PathVariable long id, @RequestBody Cliente novo) {
        if(!Repository.existsById(id)) {
            return new Response(404, "Cliente não encontrado!");
        }
        Cliente cliente = Repository.findById(id).get();
    
    if (novo.getTelefone() != null) {
        cliente.setTelefone(novo.getTelefone());
    }
    if (novo.getEmail() != null) {
    cliente.setEmail(novo.getEmail());
    }
    if (novo.getNome() != null) {
        cliente.setNome(novo.getNome());
    }
    if (novo.getEndereco() != null) {
        cliente.setEndereco(novo.getEndereco());
    }
        Repository.save(cliente);
        return new Response(200, "Cliente atualizado com sucesso!");
    }
    @DeleteMapping("/{id}")
    public Response deletarCliente(@PathVariable long id) {
        if(!Repository.existsById(id)) {
            return new Response(404, "Cliente não encontrado!");
        }
        Repository.deleteById(id);
        return new Response(200, "Cliente deletado com sucesso!");
    }
}