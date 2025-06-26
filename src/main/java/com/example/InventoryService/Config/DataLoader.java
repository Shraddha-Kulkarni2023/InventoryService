package com.example.InventoryService.Config;

import com.example.InventoryService.Repository.InventoryRepository;
import com.example.InventoryService.model.Inventory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {

        return args -> {

            inventoryRepository.deleteAll();
            inventoryRepository.save(new Inventory(null,"H1001", 78));
            inventoryRepository.save(new Inventory(null,"S1230",50));
            inventoryRepository.save(new Inventory(null,"A2345", 67));
            inventoryRepository.save(new Inventory(null,"D2901",30));
            inventoryRepository.save(new Inventory(null, "E2109",60));
        };

    }
}
