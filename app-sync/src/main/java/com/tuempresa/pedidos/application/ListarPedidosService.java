package com.tuempresa.pedidos.application;

import com.tuempresa.pedidos.application.port.in.ListarPedidosUseCase;
import com.tuempresa.pedidos.domain.model.Pedido;
import com.tuempresa.pedidos.domain.port.out.PedidoRepository;

import java.util.List;

public class ListarPedidosService implements ListarPedidosUseCase {

    private final PedidoRepository pedidoRepository;

    public ListarPedidosService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> ejecutar() {
        return pedidoRepository.listar();
    }
}
