package com.devsummit.microsservicos.order.controller;

import com.devsummit.microsservicos.order.model.Order;
import com.devsummit.microsservicos.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Order> createOrder(@Valid @RequestBody Order order) {
        log.info("Cadastrando uma nova ordem com as informações [{}]", order);
        return orderService.saveOrder(order);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Order> findPaymentById(@PathVariable String id) {
        log.info("Buscando pagamento com o id [{}]", id);
        return orderService.findOrderById(id);
    }


}
