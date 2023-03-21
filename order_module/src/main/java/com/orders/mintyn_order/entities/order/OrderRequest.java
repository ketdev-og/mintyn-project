package com.orders.mintyn_order.entities.order;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class OrderRequest {
    Set<String> products =new HashSet<>();
    Long totalPrice;
    String customerName;
    String customerPhone;
}
