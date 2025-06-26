package com.example.InventoryService.Service;

import com.example.InventoryService.model.Inventory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface InventoryService {

    boolean isInStock(String productCode,int requiredQuantity);
    void decreaseStock(String productCode, int quantity);
    void increaseStock(String productCode,int quantity);

    Optional<Inventory> getInventoryByProductId(String productCode);
    Optional<Inventory> getInventoryByproductCode(String productCode);


}
