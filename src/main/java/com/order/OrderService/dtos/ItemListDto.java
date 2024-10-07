package com.order.OrderService.dtos;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ItemListDto {

    private String itemName;
    private int quantity;
    private double price;
}
