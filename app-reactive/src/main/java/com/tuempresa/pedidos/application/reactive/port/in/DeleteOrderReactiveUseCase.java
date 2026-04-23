package com.tuempresa.pedidos.application.reactive.port.in;

import reactor.core.publisher.Mono;

public interface DeleteOrderReactiveUseCase {
    Mono<Void> execute(Long id);
}