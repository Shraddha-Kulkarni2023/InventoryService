package com.example.InventoryService.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String productCode;

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "Quantity")
    private int quantity;

    public String getProductCode() {
        return productCode;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "productCode='" + productCode + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public Inventory() {
    }

    public Inventory(Long id, String productCode, int quantity) {
        this.id = id;
        this.productCode = productCode;
        this.quantity = quantity;
    }
}
