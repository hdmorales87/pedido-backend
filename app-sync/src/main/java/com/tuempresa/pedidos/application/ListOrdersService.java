package com.tuempresa.pedidos.application;

import com.tuempresa.pedidos.application.port.in.ListOrdersUseCase;
import com.tuempresa.pedidos.domain.model.Order;
import com.tuempresa.pedidos.domain.port.out.OrderRepository;

import java.util.List;

public class ListOrdersService implements ListOrdersUseCase {

    private final OrderRepository orderRepository;

    public ListOrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> execute() {
        return orderRepository.findAll().collectList().block();
    }
}
