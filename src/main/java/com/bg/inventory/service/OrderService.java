package com.bg.order.service;

import com.bg.inventory.model.Part;
import com.bg.order.model.Order;
import com.bg.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Part part, boolean isDiscounted) {
        Order order = new Order();
        order.setPartName(part.getName());
        order.setSupplier(part.getSupplier());
        order.setOrderQuantity(part.getMinOrderQty());
        order.setOrderDate(LocalDateTime.now());
        order.setIsDiscounted(isDiscounted);
        return orderRepository.save(order);
    }
}
