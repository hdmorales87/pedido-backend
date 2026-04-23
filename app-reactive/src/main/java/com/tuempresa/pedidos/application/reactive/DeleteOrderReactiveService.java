package com.tuempresa.pedidos.application.reactive;

import com.tuempresa.pedidos.application.reactive.port.in.DeleteOrderReactiveUseCase;
import com.tuempresa.pedidos.domain.port.out.OrderRepository;
import reactor.core.publisher.Mono;

public class DeleteOrderReactiveService implements DeleteOrderReactiveUseCase {

    private final OrderRepository orderRepository;

    public DeleteOrderReactiveService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Mono<Void> execute(Long id) {
        return orderRepository.delete(id);
    }
}