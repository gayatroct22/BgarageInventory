package com.bg.inventory.model;

import javax.persistence.*;

@Entity
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int availableQty;
    private int thresholdQty;
    private int minOrderQty;

    @Enumerated(EnumType.STRING)
    private Supplier supplier;

    // Getters and Setters
}
