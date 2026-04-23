package com.tuempresa.pedidos.application.port.in;

import com.tuempresa.pedidos.domain.model.Order;

public interface UpdateOrderUseCase {
    void execute(Long id, Order order);
}
