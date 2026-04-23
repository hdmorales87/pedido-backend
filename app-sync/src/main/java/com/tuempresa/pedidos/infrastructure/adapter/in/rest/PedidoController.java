package com.tuempresa.pedidos.infrastructure.adapter.in.rest;

import com.tuempresa.pedidos.application.port.in.CrearPedidoUseCase;
import com.tuempresa.pedidos.application.port.in.ListarPedidosUseCase;
import com.tuempresa.pedidos.domain.model.Pedido;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin
public class PedidoController {

    private final CrearPedidoUseCase crearPedidoUseCase;
    private final ListarPedidosUseCase listarPedidosUseCase;

    public PedidoController(CrearPedidoUseCase crearPedidoUseCase, ListarPedidosUseCase listarPedidosUseCase) {
        this.crearPedidoUseCase = crearPedidoUseCase;
        this.listarPedidosUseCase = listarPedidosUseCase;
    }

    @PostMapping
    public void crear(@RequestBody Map<String, Object> request) {
        Pedido pedido = new Pedido(
                (String) request.get("nombre"),
                ((Number) request.get("total")).doubleValue()
        );
        crearPedidoUseCase.ejecutar(pedido);
    }

    @GetMapping
    public List<Pedido> listar() {
        return listarPedidosUseCase.ejecutar();
    }
}
