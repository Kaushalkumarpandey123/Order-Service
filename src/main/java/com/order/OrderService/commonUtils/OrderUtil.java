package com.order.OrderService.commonUtils;

import com.order.OrderService.dtos.ItemListDto;
import com.order.OrderService.dtos.OrderDto;
import com.order.OrderService.models.ItemList;
import com.order.OrderService.models.Order;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderUtil {

    public static Order convertIntoOrder(OrderDto orderDto) {
        return Order
                .builder()
                .orderName(orderDto.getOrderName())
                .itemLists(orderDto
                        .getItemLists()
                        .stream()
                        .map(OrderUtil::convertIntoItemList)
                        .collect(Collectors.toList()))
                .build();
    }

    private static ItemList convertIntoItemList(ItemListDto itemListDto) {
        return ItemList
                .builder()
                .itemName(itemListDto.getItemName())
                .price(itemListDto.getPrice())
                .quantity(itemListDto.getQuantity())
                .build();
    }

    private static ItemListDto convertIntoItemListDto(ItemList itemList) {
        return ItemListDto
                .builder()
                .itemName(itemList.getItemName())
                .price(itemList.getPrice())
                .quantity(itemList.getQuantity())
                .build();
    }

    public static OrderDto convertIntoOrderDto(Order order){
        return OrderDto
                .builder()
                .orderName(order.getOrderName())
                .itemLists(order
                        .getItemLists()
                        .stream()
                        .map(OrderUtil::convertIntoItemListDto)
                        .collect(Collectors.toList()))
                .build();
    }

}
