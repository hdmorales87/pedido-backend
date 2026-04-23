package com.tuempresa.pedidos.domain.port.out;

import com.tuempresa.pedidos.domain.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderRepository {
    Mono<Void> save(Order order);
    Flux<Order> findAll();
    Mono<Void> update(Long id, Order order);
    Mono<Void> delete(Long id);
}
