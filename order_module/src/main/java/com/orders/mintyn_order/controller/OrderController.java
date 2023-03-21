package com.orders.mintyn_order.controller;

import com.orders.mintyn_order.dto.MintynOrder;
import com.orders.mintyn_order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static com.orders.mintyn_order.utils.constants.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<MintynOrder>> orders(@RequestParam Date startDate, @RequestParam Date endDate) {
        List<MintynOrder> orders = orderService.orders(startDate, endDate);

        return ResponseEntity.ok(orders);
    }
}
