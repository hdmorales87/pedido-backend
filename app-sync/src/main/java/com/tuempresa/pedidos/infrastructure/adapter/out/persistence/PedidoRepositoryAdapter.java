package com.tuempresa.pedidos.infrastructure.adapter.out.persistence;

import com.tuempresa.pedidos.domain.model.Pedido;
import com.tuempresa.pedidos.domain.port.out.PedidoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoRepositoryAdapter implements PedidoRepository {

    private final SpringDataPedidoRepository springDataPedidoRepository;

    public PedidoRepositoryAdapter(SpringDataPedidoRepository springDataPedidoRepository) {
        this.springDataPedidoRepository = springDataPedidoRepository;
    }

    @Override
    public void guardar(Pedido pedido) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setNombre(pedido.getNombre());
        pedidoEntity.setTotal(pedido.getTotal());
        springDataPedidoRepository.save(pedidoEntity);
    }

    @Override
    public List<Pedido> listar() {
        return springDataPedidoRepository.findAll().stream()
                .map(pedidoEntity -> new Pedido(pedidoEntity.getNombre(), pedidoEntity.getTotal()))
                .toList();
    }
}
