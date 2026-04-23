package com.tuempresa.pedidos.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tuempresa.pedidos.application.CreateOrderService;
import com.tuempresa.pedidos.application.ListOrdersService;
import com.tuempresa.pedidos.application.UpdateOrderService;
import com.tuempresa.pedidos.application.DeleteOrderService;
import com.tuempresa.pedidos.application.port.in.CreateOrderUseCase;
import com.tuempresa.pedidos.application.port.in.ListOrdersUseCase;
import com.tuempresa.pedidos.application.port.in.UpdateOrderUseCase;
import com.tuempresa.pedidos.application.port.in.DeleteOrderUseCase;
import com.tuempresa.pedidos.domain.port.out.OrderRepository;

@Configuration
public class BeanConfig {

    @Bean
    public CreateOrderUseCase createOrderUseCase(OrderRepository orderRepository) {
        return new CreateOrderService(orderRepository);
    }

    @Bean
    public ListOrdersUseCase listOrdersUseCase(OrderRepository orderRepository) {
        return new ListOrdersService(orderRepository);
    }

    @Bean
    public UpdateOrderUseCase updateOrderUseCase(OrderRepository orderRepository) {
        return new UpdateOrderService(orderRepository);
    }

    @Bean
    public DeleteOrderUseCase deleteOrderUseCase(OrderRepository orderRepository) {
        return new DeleteOrderService(orderRepository);
    }
}
