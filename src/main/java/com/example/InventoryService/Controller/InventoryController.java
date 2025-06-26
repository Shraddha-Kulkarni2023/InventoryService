package com.example.InventoryService.Controller;

import com.example.InventoryService.Repository.InventoryRepository;
import com.example.InventoryService.Service.InventoryService;
import com.example.InventoryService.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping("/startinventory")
    public String startinventory() {

        return "Inventory Service started";
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkStock(@RequestParam String productCode, @RequestParam int quantity) {

        boolean isAvailable = inventoryService.isInStock(productCode,quantity);
        return ResponseEntity.ok(isAvailable);
    }

    @PutMapping("/decrease")
    public ResponseEntity<String> decreaseStock(@RequestParam String productCode, @RequestParam int quantity) {

        inventoryService.decreaseStock(productCode,quantity);
        return ResponseEntity.ok("Stock Updated");

    }

    @PutMapping("/increase")
    public ResponseEntity<String> increaseStock(@RequestParam String productCode, @RequestParam int quantity) {

        inventoryService.increaseStock(productCode,quantity);
        return ResponseEntity.ok("Stock updated");
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<Inventory> getInventoryByProductCode(@PathVariable String productCode) {

        return inventoryService.getInventoryByproductCode(productCode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());



    }

    @GetMapping("/getallstock")
    public List<Inventory> getallstock() {
        return inventoryRepository.findAll();

    }




}
