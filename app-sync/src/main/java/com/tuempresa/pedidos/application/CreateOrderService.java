package com.tuempresa.pedidos.application;

import com.tuempresa.pedidos.application.port.in.CreateOrderUseCase;
import com.tuempresa.pedidos.domain.model.Order;
import com.tuempresa.pedidos.domain.port.out.OrderRepository;

public class CreateOrderService implements CreateOrderUseCase {

    private final OrderRepository orderRepository;

    public CreateOrderService(OrderRepository repo) {
        this.orderRepository = repo;
    }

    @Override
    public void execute(Order order) {
        orderRepository.save(order).block();
    }
}
