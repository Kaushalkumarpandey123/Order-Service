package com.order.OrderService.services;

import com.order.OrderService.commonUtils.OrderUtil;
import com.order.OrderService.daos.OrderDao;
import com.order.OrderService.dtos.OrderDto;
import com.order.OrderService.exceptions.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderService(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    public void placeOrder(OrderDto orderDto) {
        orderDao.save(OrderUtil.convertIntoOrder(orderDto));
    }

    public OrderDto getOrder(long orderId) {
//        Optional<Order> orderOptional = orderDao.findById(orderId);
//        if (orderOptional.isEmpty()) {
//            throw new OrderNotFoundException("Oh, Dear. The order: " + orderId + " is not present in our database.");
//        }
//        return OrderUtil.convertIntoOrderDto(orderOptional.get());
        return orderDao.findById(orderId)
                .map(OrderUtil::convertIntoOrderDto)
                .orElseThrow(() -> new OrderNotFoundException("Oh, Dear. The order: " + orderId + " is not present in our database."));
    }

    public String cancleOrder(long orderId) {
        if(!orderDao.existsById(orderId)){
            throw new OrderNotFoundException("Oh, Dear. The order: " + orderId + " is not present in our database.");
        }
        orderDao.deleteById(orderId);
        return "Order of id " + orderId + " is cancalled successfully";
    }
}
