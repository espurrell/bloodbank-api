package com.keyin.bloodbank_api.controller;

import com.keyin.bloodbank_api.model.Stock;
import com.keyin.bloodbank_api.service.StockService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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
        Stock stock = new Stock("O-", 10);
        when(stockService.getStockByBloodType("O-")).thenReturn(stock);

        // Act and Assert
        mockMvc.perform(get("/api/stocks/O-"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sBloodtype").value("O-"))
                .andExpect(jsonPath("$.quantity").value(10));
    }

    @Test
    void updateStockQuantity_shouldReturnUpdatedStock() throws Exception {
        // Arrange
        Stock stock = new Stock("A+", 15);
        when(stockService.updateStockQuantity("A+", 15)).thenReturn(stock);

        // Act and Assert
        mockMvc.perform(put("/api/stocks/A+/quantity")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("15"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sBloodtype").value("A+"))
                .andExpect(jsonPath("$.quantity").value(15));
    }
}

