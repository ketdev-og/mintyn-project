package com.orders.mintyn_order.controller;

import com.orders.mintyn_order.dto.MintynOrder;
import com.orders.mintyn_order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.orders.mintyn_order.utils.constants.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<MintynOrder>> orders() {
        List<MintynOrder> orders = orderService.orders();
        return ResponseEntity.ok(orders);
    }
}
