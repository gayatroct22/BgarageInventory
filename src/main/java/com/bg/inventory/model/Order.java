package com.bg.order.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partName;

    @Enumerated(EnumType.STRING)
    private Supplier supplier;

    private int orderQuantity;
    private LocalDateTime orderDate;
    private boolean isDiscounted;

    // Getters and Setters
}
