package com.tuempresa.pedidos.infrastructure.adapter.out.persistence.reactive;

import com.tuempresa.pedidos.domain.model.Pedido;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReactivePedidoRepositoryAdapter implements PedidoReactiveStore {

    private final SpringDataReactivePedidoRepository springDataReactivePedidoRepository;

    public ReactivePedidoRepositoryAdapter(SpringDataReactivePedidoRepository springDataReactivePedidoRepository) {
        this.springDataReactivePedidoRepository = springDataReactivePedidoRepository;
    }

    @Override
    public Mono<Void> guardar(Pedido pedido) {
        PedidoRow pedidoRow = new PedidoRow();
        pedidoRow.setNombre(pedido.getNombre());
        pedidoRow.setTotal(pedido.getTotal());
        return springDataReactivePedidoRepository.save(pedidoRow).then();
    }

    @Override
    public Flux<Pedido> listar() {
        return springDataReactivePedidoRepository.findAll()
                .map(pedidoRow -> new Pedido(pedidoRow.getNombre(), pedidoRow.getTotal()));
    }
}
