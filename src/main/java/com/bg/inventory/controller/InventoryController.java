package com.bg.inventory.controller;

import com.bg.inventory.model.Part;
import com.bg.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/parts")
    public List<Part> getAllParts() {
        return inventoryService.getAllParts();
    }

    @PostMapping("/parts")
    public Part addPart(@RequestBody Part part) {
        return inventoryService.addPart(part);
    }

    @PutMapping("/parts/{id}/quantity")
    public ResponseEntity<?> updatePartQuantity(@PathVariable Long id, @RequestParam int qty) {
        inventoryService.updatePartQuantity(id, qty);
        return ResponseEntity.ok().build();
    }
}
