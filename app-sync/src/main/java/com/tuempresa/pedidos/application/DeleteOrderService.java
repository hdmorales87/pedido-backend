package com.tuempresa.pedidos.application;

import com.tuempresa.pedidos.application.port.in.DeleteOrderUseCase;
import com.tuempresa.pedidos.domain.port.out.OrderRepository;

public class DeleteOrderService implements DeleteOrderUseCase {

    private final OrderRepository orderRepository;

    public DeleteOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void execute(Long id) {
        orderRepository.delete(id).block();
    }
}