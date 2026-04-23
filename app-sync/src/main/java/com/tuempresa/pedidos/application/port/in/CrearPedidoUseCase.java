package com.tuempresa.pedidos.application.port.in;

import com.tuempresa.pedidos.domain.model.Pedido;

public interface CrearPedidoUseCase {
    void ejecutar(Pedido pedido);
}
