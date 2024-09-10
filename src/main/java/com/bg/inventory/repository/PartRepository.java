package com.bg.inventory.repository;

import com.bg.inventory.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    List<Part> findByAvailableQtyLessThan(int thresholdQty);
}
