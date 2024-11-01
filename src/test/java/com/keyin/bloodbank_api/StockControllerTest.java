package com.keyin.bloodbank_api;

import com.keyin.bloodbank_api.controller.StockController;
import com.keyin.bloodbank_api.model.Stock;
import com.keyin.bloodbank_api.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StockController.class)
class StockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StockService stockService;

    @Test
    void getStockByBloodType_shouldReturnStockForBloodType() throws Exception {
        // Arrange
        Stock stock = new Stock();
        when(stockService.getStockByBloodType("O-")).thenReturn(Optional.of(stock));

        // Act and Assert
        mockMvc.perform(get("/api/stocks/O-"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bloodType").value("O-"))
                .andExpect(jsonPath("$.quantity").value(10));
    }

    @Test
    void updateStockQuantity_shouldReturnUpdatedStock() throws Exception {
        // Arrange
        Stock stock = new Stock();
        when(stockService.updateStockQuantity("A+", 15)).thenReturn(stock);

        // Act and Assert
        mockMvc.perform(put("/api/stocks/A+/quantity")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("15"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bloodType").value("A+"))
                .andExpect(jsonPath("$.quantity").value(15));
    }
}

