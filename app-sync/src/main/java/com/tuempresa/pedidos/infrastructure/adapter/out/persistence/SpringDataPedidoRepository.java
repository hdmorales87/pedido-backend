package com.tuempresa.pedidos.infrastructure.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPedidoRepository extends JpaRepository<PedidoEntity, Long> {}
