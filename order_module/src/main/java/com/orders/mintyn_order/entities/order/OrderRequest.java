package com.orders.mintyn_order.entities.order;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequest {
    Set<String> products =new HashSet<>();
    Long totalPrice;
    String customerName;
    String customerPhone;
}
