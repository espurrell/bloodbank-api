package com.keyin.bloodbank_api.repository;

import com.keyin.bloodbank_api.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {
    Optional<Stock> findBySBloodtype(String s_bloodType);
}

