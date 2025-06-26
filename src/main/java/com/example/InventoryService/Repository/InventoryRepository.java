package com.example.InventoryService.Repository;

import com.example.InventoryService.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    @Query("SELECT i FROM Inventory i WHERE i.productCode = :productCode")
    Optional<Inventory> findByProductCode(@Param("productCode") String productCode);

    void deleteAll();

}
