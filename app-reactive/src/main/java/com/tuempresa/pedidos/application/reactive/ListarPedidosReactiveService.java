package com.tuempresa.pedidos.application.reactive;

import com.tuempresa.pedidos.application.reactive.port.in.ListarPedidosReactiveUseCase;
import com.tuempresa.pedidos.domain.model.Pedido;
import com.tuempresa.pedidos.infrastructure.adapter.out.persistence.reactive.PedidoReactiveStore;
import reactor.core.publisher.Flux;

public class ListarPedidosReactiveService implements ListarPedidosReactiveUseCase {

    private final PedidoReactiveStore pedidoReactiveStore;

    public ListarPedidosReactiveService(PedidoReactiveStore pedidoReactiveStore) {
        this.pedidoReactiveStore = pedidoReactiveStore;
    }

    @Override
    public Flux<Pedido> ejecutar() {
        return pedidoReactiveStore.listar();
    }
}
