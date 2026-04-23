package com.tuempresa.pedidos.infrastructure.adapter.out.persistence.reactive;

import com.tuempresa.pedidos.domain.model.Pedido;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PedidoReactiveStore {
    Mono<Void> guardar(Pedido pedido);
    Flux<Pedido> listar();
}
