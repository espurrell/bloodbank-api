package com.keyin.bloodbank_api.service;


import com.keyin.bloodbank_api.model.Stock;
import com.keyin.bloodbank_api.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    // Retrieve stock by blood type
    public Optional<Stock> getStockByBloodType(String bloodType) {
        return stockRepository.findBySBloodtype(bloodType);
    }

    // Update the quantity for a given blood type
    public Stock updateStockQuantity(String bloodType, int quantityChange) {
        Stock stock = stockRepository.findBySBloodtype(bloodType)
                .orElse(new Stock());

        stock.setBloodType(bloodType);
        stock.setQuantity(stock.getQuantity() + quantityChange);

        return stockRepository.save(stock);
    }

    // Get all stocks
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
}

