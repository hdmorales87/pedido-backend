package com.tuempresa.pedidos.application.reactive;

import com.tuempresa.pedidos.application.reactive.port.in.CrearPedidoReactiveUseCase;
import com.tuempresa.pedidos.domain.model.Pedido;
import com.tuempresa.pedidos.infrastructure.adapter.out.persistence.reactive.PedidoReactiveStore;
import reactor.core.publisher.Mono;

public class CrearPedidoReactiveService implements CrearPedidoReactiveUseCase {

    private final PedidoReactiveStore pedidoReactiveStore;

    public CrearPedidoReactiveService(PedidoReactiveStore pedidoReactiveStore) {
        this.pedidoReactiveStore = pedidoReactiveStore;
    }

    @Override
    public Mono<Void> ejecutar(Pedido pedido) {
        return pedidoReactiveStore.guardar(pedido);
    }
}
