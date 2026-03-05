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
import br.com.senai.api_vendas.entity.Pedido;
import br.com.senai.api_vendas.exception.Response;
import br.com.senai.api_vendas.repository.PedidoRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @PostMapping
    public Response cadastrarPedido(@Valid @RequestBody Pedido pedido) {
        repository.save(pedido);
        return new Response(201, "Pedido cadastrado com sucesso");
    }

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizarPedido(@PathVariable long id, @RequestBody Pedido novo) {
        if (!repository.existsById(id)) {
            return new Response(404, "Pedido não encontrado!");
        }
        Pedido pedido = repository.findById(id).get();

        if (novo.getQuantidade_pedido() !=null) {
            pedido.setQuantidade_pedido(novo.getQuantidade_pedido());
        }
        if (novo.getStatus_pedido() != null) {
            pedido.setStatus_pedido(novo.getStatus_pedido());
        }
        if (novo.getData_pedido() != null) {
            pedido.setData_pedido(novo.getData_pedido());
        }

        repository.save(pedido);
       
        return new Response(200, "Pedido atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public Response deletarPedido(@PathVariable long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Pedido não encontrado!");
        }
        repository.deleteById(id);
        return new Response(200, "Pedido deletado com sucesso!");
    }

}
