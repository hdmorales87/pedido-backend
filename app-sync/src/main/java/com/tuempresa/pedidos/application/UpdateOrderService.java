package com.tuempresa.pedidos.application;

import com.tuempresa.pedidos.application.port.in.UpdateOrderUseCase;
import com.tuempresa.pedidos.domain.model.Order;
import com.tuempresa.pedidos.domain.port.out.OrderRepository;

public class UpdateOrderService implements UpdateOrderUseCase {

    private final OrderRepository orderRepository;

    public UpdateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void execute(Long id, Order order) {
        orderRepository.update(id, order).block();
    }
}
