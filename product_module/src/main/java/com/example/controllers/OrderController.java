package com.example.controllers;

import com.example.entities.order.OrderRequest;
import com.example.kafka.JsonKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.utils.constants.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/order")
public class OrderController {
    @Autowired
    JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/create")
    public ResponseEntity<String> orders(@RequestBody OrderRequest order) {
        jsonKafkaProducer.sendMessage(order);
        return ResponseEntity.ok("order sent to topic queue");
    }
}