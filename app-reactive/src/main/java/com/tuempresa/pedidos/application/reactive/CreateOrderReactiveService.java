package com.tuempresa.pedidos.application.reactive;

import com.tuempresa.pedidos.application.reactive.port.in.CreateOrderReactiveUseCase;
import com.tuempresa.pedidos.domain.model.Order;
import com.tuempresa.pedidos.domain.port.out.OrderRepository;
import reactor.core.publisher.Mono;

public class CreateOrderReactiveService implements CreateOrderReactiveUseCase {

    private final OrderRepository orderRepository;

    public CreateOrderReactiveService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Mono<Void> execute(Order order) {
        return orderRepository.save(order);
    }
}
