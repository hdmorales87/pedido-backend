package com.tuempresa.pedidos.infrastructure.adapter.in.rest;

import com.tuempresa.pedidos.application.reactive.port.in.CrearPedidoReactiveUseCase;
import com.tuempresa.pedidos.application.reactive.port.in.ListarPedidosReactiveUseCase;
import com.tuempresa.pedidos.domain.model.Pedido;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin
public class PedidoReactiveController {

    private final CrearPedidoReactiveUseCase crearPedidoReactiveUseCase;
    private final ListarPedidosReactiveUseCase listarPedidosReactiveUseCase;

    public PedidoReactiveController(CrearPedidoReactiveUseCase crearPedidoReactiveUseCase,
                                    ListarPedidosReactiveUseCase listarPedidosReactiveUseCase) {
        this.crearPedidoReactiveUseCase = crearPedidoReactiveUseCase;
        this.listarPedidosReactiveUseCase = listarPedidosReactiveUseCase;
    }

    @PostMapping
    public Mono<Void> crear(@RequestBody Map<String, Object> request) {
        Pedido pedido = new Pedido(
                (String) request.get("nombre"),
                ((Number) request.get("total")).doubleValue()
        );
        return crearPedidoReactiveUseCase.ejecutar(pedido);
    }

    @GetMapping
    public Flux<Pedido> listar() {
        return listarPedidosReactiveUseCase.ejecutar();
    }
}
