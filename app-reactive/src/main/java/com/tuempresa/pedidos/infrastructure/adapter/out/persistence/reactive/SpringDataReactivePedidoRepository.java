package com.tuempresa.pedidos.infrastructure.adapter.out.persistence.reactive;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SpringDataReactivePedidoRepository extends ReactiveCrudRepository<PedidoRow, Long> {
}
