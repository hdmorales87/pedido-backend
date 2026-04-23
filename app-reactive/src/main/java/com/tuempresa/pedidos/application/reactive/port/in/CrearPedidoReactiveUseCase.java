package com.tuempresa.pedidos.application.reactive.port.in;

import com.tuempresa.pedidos.domain.model.Pedido;
import reactor.core.publisher.Mono;

public interface CrearPedidoReactiveUseCase {
    Mono<Void> ejecutar(Pedido pedido);
}
