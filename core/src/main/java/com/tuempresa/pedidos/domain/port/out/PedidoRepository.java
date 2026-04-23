package com.tuempresa.pedidos.domain.port.out;

import com.tuempresa.pedidos.domain.model.Pedido;

import java.util.List;

public interface PedidoRepository {
    void guardar(Pedido pedido);
    List<Pedido> listar();
}
