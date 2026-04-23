package com.tuempresa.pedidos.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tuempresa.pedidos.application.CrearPedidoService;
import com.tuempresa.pedidos.application.ListarPedidosService;
import com.tuempresa.pedidos.application.port.in.CrearPedidoUseCase;
import com.tuempresa.pedidos.application.port.in.ListarPedidosUseCase;
import com.tuempresa.pedidos.domain.port.out.PedidoRepository;

@Configuration
public class BeanConfig {

    @Bean
    public CrearPedidoUseCase crearPedidoUseCase(PedidoRepository pedidoRepository) {
        return new CrearPedidoService(pedidoRepository);
    }

    @Bean
    public ListarPedidosUseCase listarPedidosUseCase(PedidoRepository pedidoRepository) {
        return new ListarPedidosService(pedidoRepository);
    }
}
