package com.tuempresa.pedidos.application.reactive.port.in;

import com.tuempresa.pedidos.domain.model.Order;
import reactor.core.publisher.Mono;

public interface CreateOrderReactiveUseCase {
    Mono<Void> execute(Order order);
}
