package com.tuempresa.pedidos.application.reactive;

import com.tuempresa.pedidos.application.reactive.port.in.UpdateOrderReactiveUseCase;
import com.tuempresa.pedidos.domain.model.Order;
import com.tuempresa.pedidos.domain.port.out.OrderRepository;
import reactor.core.publisher.Mono;

public class UpdateOrderReactiveService implements UpdateOrderReactiveUseCase {

    private final OrderRepository orderRepository;

    public UpdateOrderReactiveService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Mono<Void> execute(Long id, Order order) {
        return orderRepository.update(id, order);
    }
}
