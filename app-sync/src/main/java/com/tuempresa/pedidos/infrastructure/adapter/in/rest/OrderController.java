package com.tuempresa.pedidos.infrastructure.adapter.in.rest;

import com.tuempresa.pedidos.application.port.in.CreateOrderUseCase;
import com.tuempresa.pedidos.application.port.in.ListOrdersUseCase;
import com.tuempresa.pedidos.application.port.in.UpdateOrderUseCase;
import com.tuempresa.pedidos.application.port.in.DeleteOrderUseCase;
import com.tuempresa.pedidos.domain.model.Order;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final ListOrdersUseCase listOrdersUseCase;
    private final UpdateOrderUseCase updateOrderUseCase;
    private final DeleteOrderUseCase deleteOrderUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase, ListOrdersUseCase listOrdersUseCase, UpdateOrderUseCase updateOrderUseCase, DeleteOrderUseCase deleteOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
        this.listOrdersUseCase = listOrdersUseCase;
        this.updateOrderUseCase = updateOrderUseCase;
        this.deleteOrderUseCase = deleteOrderUseCase;
    }

    @PostMapping
    public void create(@RequestBody Map<String, Object> request) {
        Order order = new Order(
                (String) request.get("name"),
                ((Number) request.get("total")).doubleValue()
        );
        createOrderUseCase.execute(order);
    }

    @GetMapping
    public List<Order> list() {
        return listOrdersUseCase.execute();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Map<String, Object> request) {
        Order order = new Order(
                (String) request.get("name"),
                ((Number) request.get("total")).doubleValue()
        );
        updateOrderUseCase.execute(id, order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteOrderUseCase.execute(id);
    }
}
