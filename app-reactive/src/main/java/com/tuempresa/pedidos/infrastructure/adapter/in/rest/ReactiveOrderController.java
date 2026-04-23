package com.tuempresa.pedidos.infrastructure.adapter.in.rest;

import com.tuempresa.pedidos.application.reactive.port.in.CreateOrderReactiveUseCase;
import com.tuempresa.pedidos.application.reactive.port.in.ListOrdersReactiveUseCase;
import com.tuempresa.pedidos.application.reactive.port.in.UpdateOrderReactiveUseCase;
import com.tuempresa.pedidos.application.reactive.port.in.DeleteOrderReactiveUseCase;
import com.tuempresa.pedidos.domain.model.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class ReactiveOrderController {

    private final CreateOrderReactiveUseCase createOrderReactiveUseCase;
    private final ListOrdersReactiveUseCase listOrdersReactiveUseCase;
    private final UpdateOrderReactiveUseCase updateOrderReactiveUseCase;
    private final DeleteOrderReactiveUseCase deleteOrderReactiveUseCase;

    public ReactiveOrderController(CreateOrderReactiveUseCase createOrderReactiveUseCase,
                                    ListOrdersReactiveUseCase listOrdersReactiveUseCase,
                                    UpdateOrderReactiveUseCase updateOrderReactiveUseCase,
                                    DeleteOrderReactiveUseCase deleteOrderReactiveUseCase) {
        this.createOrderReactiveUseCase = createOrderReactiveUseCase;
        this.listOrdersReactiveUseCase = listOrdersReactiveUseCase;
        this.updateOrderReactiveUseCase = updateOrderReactiveUseCase;
        this.deleteOrderReactiveUseCase = deleteOrderReactiveUseCase;
    }

    @PostMapping
    public Mono<Void> create(@RequestBody Map<String, Object> request) {
        Order order = new Order(
                (String) request.get("name"),
                ((Number) request.get("total")).doubleValue()
        );
        return createOrderReactiveUseCase.execute(order);
    }

    @GetMapping
    public Flux<Order> list() {
        return listOrdersReactiveUseCase.execute();
    }

    @PutMapping("/{id}")
    public Mono<Void> update(@PathVariable Long id, @RequestBody Map<String, Object> request) {
        Order order = new Order(
                (String) request.get("name"),
                ((Number) request.get("total")).doubleValue()
        );
        return updateOrderReactiveUseCase.execute(id, order);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return deleteOrderReactiveUseCase.execute(id);
    }
}
