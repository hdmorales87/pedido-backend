package com.tuempresa.pedidos.infrastructure.config;

import com.tuempresa.pedidos.application.reactive.CreateOrderReactiveService;
import com.tuempresa.pedidos.application.reactive.ListOrdersReactiveService;
import com.tuempresa.pedidos.application.reactive.UpdateOrderReactiveService;
import com.tuempresa.pedidos.application.reactive.DeleteOrderReactiveService;
import com.tuempresa.pedidos.application.reactive.port.in.CreateOrderReactiveUseCase;
import com.tuempresa.pedidos.application.reactive.port.in.ListOrdersReactiveUseCase;
import com.tuempresa.pedidos.application.reactive.port.in.UpdateOrderReactiveUseCase;
import com.tuempresa.pedidos.application.reactive.port.in.DeleteOrderReactiveUseCase;
import com.tuempresa.pedidos.domain.port.out.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateOrderReactiveUseCase createOrderReactiveUseCase(OrderRepository orderRepository) {
        return new CreateOrderReactiveService(orderRepository);
    }

    @Bean
    public ListOrdersReactiveUseCase listOrdersReactiveUseCase(OrderRepository orderRepository) {
        return new ListOrdersReactiveService(orderRepository);
    }

    @Bean
    public UpdateOrderReactiveUseCase updateOrderReactiveUseCase(OrderRepository orderRepository) {
        return new UpdateOrderReactiveService(orderRepository);
    }

    @Bean
    public DeleteOrderReactiveUseCase deleteOrderReactiveUseCase(OrderRepository orderRepository) {
        return new DeleteOrderReactiveService(orderRepository);
    }
}
