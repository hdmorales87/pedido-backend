package com.tuempresa.pedidos.infrastructure.config;

import com.tuempresa.pedidos.application.reactive.CrearPedidoReactiveService;
import com.tuempresa.pedidos.application.reactive.ListarPedidosReactiveService;
import com.tuempresa.pedidos.application.reactive.port.in.CrearPedidoReactiveUseCase;
import com.tuempresa.pedidos.application.reactive.port.in.ListarPedidosReactiveUseCase;
import com.tuempresa.pedidos.infrastructure.adapter.out.persistence.reactive.PedidoReactiveStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CrearPedidoReactiveUseCase crearPedidoReactiveUseCase(PedidoReactiveStore pedidoReactiveStore) {
        return new CrearPedidoReactiveService(pedidoReactiveStore);
    }

    @Bean
    public ListarPedidosReactiveUseCase listarPedidosReactiveUseCase(PedidoReactiveStore pedidoReactiveStore) {
        return new ListarPedidosReactiveService(pedidoReactiveStore);
    }
}
