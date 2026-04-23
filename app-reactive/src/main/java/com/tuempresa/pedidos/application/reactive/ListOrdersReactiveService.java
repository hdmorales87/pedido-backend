package com.tuempresa.pedidos.application.reactive;

import com.tuempresa.pedidos.application.reactive.port.in.ListOrdersReactiveUseCase;
import com.tuempresa.pedidos.domain.model.Order;
import com.tuempresa.pedidos.domain.port.out.OrderRepository;
import reactor.core.publisher.Flux;

public class ListOrdersReactiveService implements ListOrdersReactiveUseCase {

    private final OrderRepository orderRepository;

    public ListOrdersReactiveService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Flux<Order> execute() {
        return orderRepository.findAll();
    }
}
