package com.bg.inventory.service;

import com.bg.inventory.model.Part;
import com.bg.inventory.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private PartRepository partRepository;

    public List<Part> getAllParts() {
        return partRepository.findAll();
    }

    public Part addPart(Part part) {
        return partRepository.save(part);
    }

    public void updatePartQuantity(Long id, int qty) {
        Part part = partRepository.findById(id).orElseThrow(() -> new RuntimeException("Part not found"));
        part.setAvailableQty(qty);
        partRepository.save(part);
    }

    public List<Part> checkLowInventoryParts() {
        return partRepository.findByAvailableQtyLessThan(10); // Example threshold check
    }
}
