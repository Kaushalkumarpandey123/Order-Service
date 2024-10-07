package com.order.OrderService.dtos;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderDto {

    private String orderName;
    private List<ItemListDto> itemLists;

}
