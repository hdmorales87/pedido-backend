package com.tuempresa.pedidos.application;

import com.tuempresa.pedidos.application.port.in.CrearPedidoUseCase;
import com.tuempresa.pedidos.domain.model.Pedido;
import com.tuempresa.pedidos.domain.port.out.PedidoRepository;

public class CrearPedidoService implements CrearPedidoUseCase {

    private final PedidoRepository pedidoRepository;

    public CrearPedidoService(PedidoRepository repo) {
        this.pedidoRepository = repo;
    }

    public void ejecutar(Pedido pedido) {
        pedidoRepository.guardar(pedido);
    }
}
