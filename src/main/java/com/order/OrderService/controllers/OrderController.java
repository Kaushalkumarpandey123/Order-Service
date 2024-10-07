package com.order.OrderService.controllers;

import com.order.OrderService.dtos.OrderDto;
import com.order.OrderService.services.OrderService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/Orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/test")
    public String testOrder(){
        return "Order Service is running...";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderDto orderDto){
        orderService.placeOrder(orderDto);
        return "Order placed successfully.";
    }

    @GetMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto getOrder(@PathVariable long orderId){
        return orderService.getOrder(orderId);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public String cancleOrder(@PathVariable long orderId){
        return orderService.cancleOrder(orderId);
    }

}
