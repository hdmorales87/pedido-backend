package com.tuempresa.pedidos.application.port.in;

import com.tuempresa.pedidos.domain.model.Order;

public interface CreateOrderUseCase {
    void execute(Order order);
}
