package com.bg.order.controller;

import com.bg.inventory.model.Part;
import com.bg.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<?> placeOrder(@RequestBody Part part, @RequestParam boolean isDiscounted) {
        orderService.createOrder(part, isDiscounted);
        return ResponseEntity.ok().build();
    }
}
