package com.tuempresa.pedidos.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.tuempresa.pedidos")
public class OrdersReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersReactiveApplication.class, args);
    }
}
