package com.bg.scheduler;

import com.bg.inventory.model.Part;
import com.bg.inventory.service.InventoryService;
import com.bg.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
public class OrderScheduler {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private OrderService orderService;

    @Scheduled(cron = "0 0 0 * * ?") // Every midnight at 12:00 AM
    public void scheduleDiscountedOrders() {
        List<Part> parts = inventoryService.checkLowInventoryParts();
        for (Part part : parts) {
            if (part.getSupplier() == Supplier.SUPPLIER_B) {
                orderService.createOrder(part, true);
            }
        }
    }
}
