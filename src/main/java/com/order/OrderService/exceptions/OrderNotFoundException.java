package com.order.OrderService.exceptions;

public class OrderNotFoundException extends RuntimeException {
    private static final String message = "Order not found";
    public OrderNotFoundException() {
        this(message);
    }
    public OrderNotFoundException(String message) {
        super(message);
    }
}
