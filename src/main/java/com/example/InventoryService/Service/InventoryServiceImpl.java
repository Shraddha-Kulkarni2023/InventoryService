package com.example.InventoryService.Service;

import com.example.InventoryService.Repository.InventoryRepository;
import com.example.InventoryService.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;


    @Override
    public boolean isInStock(String productCode, int requiredQuantity) {
        return inventoryRepository.findByProductCode(productCode)
                .map(inv -> inv.getQuantity() >= requiredQuantity)
                .orElse(false);
    }

    @Override
    public void decreaseStock(String productCode, int quantity) {

        Inventory inventory = inventoryRepository.findByProductCode(productCode)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if(inventory.getQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }
        inventory.setQuantity(inventory.getQuantity() - 1);
        inventoryRepository.save(inventory);

    }

    @Override
    public void increaseStock(String productCode, int quantity) {

        Inventory inventory = inventoryRepository.findByProductCode(productCode)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        inventory.setQuantity(inventory.getQuantity() + 1);
        inventoryRepository.save(inventory);

    }

    @Override
    public Optional<Inventory> getInventoryByProductId(String productCode) {
        Optional<Inventory> inventory = inventoryRepository.findByProductCode(productCode);
        return inventory;
    }

    @Override
    public Optional<Inventory> getInventoryByproductCode(String productCode) {
        Optional<Inventory> inventory1 = inventoryRepository.findByProductCode(productCode);
        return inventory1;
    }
}
