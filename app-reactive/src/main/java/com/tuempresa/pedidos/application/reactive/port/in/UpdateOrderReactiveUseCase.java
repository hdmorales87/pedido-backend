package com.tuempresa.pedidos.application.reactive.port.in;

import com.tuempresa.pedidos.domain.model.Order;
import reactor.core.publisher.Mono;

public interface UpdateOrderReactiveUseCase {
    Mono<Void> execute(Long id, Order order);
}
