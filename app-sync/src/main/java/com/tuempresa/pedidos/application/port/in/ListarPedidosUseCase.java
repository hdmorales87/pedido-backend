package com.tuempresa.pedidos.application.port.in;

import com.tuempresa.pedidos.domain.model.Pedido;

import java.util.List;

public interface ListarPedidosUseCase {
    List<Pedido> ejecutar();
}
