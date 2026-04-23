package com.tuempresa.pedidos.application.reactive.port.in;

import com.tuempresa.pedidos.domain.model.Order;
import reactor.core.publisher.Flux;

public interface ListOrdersReactiveUseCase {
    Flux<Order> execute();
}
