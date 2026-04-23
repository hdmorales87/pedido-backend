package com.tuempresa.pedidos.application.reactive.port.in;

import com.tuempresa.pedidos.domain.model.Pedido;
import reactor.core.publisher.Flux;

public interface ListarPedidosReactiveUseCase {
    Flux<Pedido> ejecutar();
}
