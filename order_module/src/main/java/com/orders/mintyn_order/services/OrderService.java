package com.orders.mintyn_order.services;


import com.orders.mintyn_order.dto.MintynOrder;
import com.orders.mintyn_order.entities.order.OrderRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface OrderService {
    MintynOrder createOrder(OrderRequest order);

    List<MintynOrder> orders(Date startDate, Date endDate);
}
