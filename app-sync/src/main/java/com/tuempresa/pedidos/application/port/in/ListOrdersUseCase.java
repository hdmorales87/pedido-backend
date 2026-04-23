package com.tuempresa.pedidos.application.port.in;

import com.tuempresa.pedidos.domain.model.Order;

import java.util.List;

public interface ListOrdersUseCase {
    List<Order> execute();
}
