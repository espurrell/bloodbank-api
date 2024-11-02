// src/main/java/com/example/bloodbank/controller/StockController.java

package com.keyin.bloodbank_api.controller;

import com.keyin.bloodbank_api.model.Stock;
import com.keyin.bloodbank_api.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    // Retrieve stock for a specific blood type
    @GetMapping("/{s_bloodtype}")
    public ResponseEntity<Stock> getStockByBloodType(@PathVariable String s_bloodtype) {
        Optional<Stock> stock = stockService.getStockByBloodType(s_bloodtype);
        return stock.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update stock quantity
    @PutMapping("/{s_bloodtype}")
    public ResponseEntity<Stock> updateStockQuantity(
            @PathVariable String s_bloodtype,
            @RequestParam int quantityChange) {

        Stock updatedStock = stockService.updateStockQuantity(s_bloodtype, quantityChange);
        return ResponseEntity.ok(updatedStock);
    }

    // Retrieve all stocks
    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }
}
