package com.example.inventroyservicemicroservice.repositories;

import com.example.inventroyservicemicroservice.modles.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findBySkuCode(String skuCode);
}
