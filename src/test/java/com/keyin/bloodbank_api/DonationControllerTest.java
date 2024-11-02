package com.keyin.bloodbank_api;

import com.keyin.bloodbank_api.controller.DonationController;
import com.keyin.bloodbank_api.model.Donation;
import com.keyin.bloodbank_api.model.Person;
import com.keyin.bloodbank_api.repository.PersonRepository;
import com.keyin.bloodbank_api.service.DonationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DonationController.class)
@SpringBootTest
public class DonationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DonationService donationService;

    @MockBean
    private PersonRepository personRepository;

    @Test
    void addDonation_shouldReturnCreatedDonation() throws Exception {
        // Arrange
        Donation donation = new Donation();
        donation.setId(1);
        donation.setDate(LocalDate.now());
        donation.setQuantity(2);
        donation.setPerson(new Person());

        when(donationService.addDonation(Mockito.any(Donation.class))).thenReturn(donation);

        // Act and Assert
        mockMvc.perform(post("/api/donations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"d_date\":\"2024-10-01\", \"quantity\": 2, \"person\": { \"p_id\": 1 }}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.d_id").value(1))
                .andExpect(jsonPath("$.quantity").value(2));
    }

    @Test
    void getDonationsByPersonId_shouldReturnListOfDonations() throws Exception {
        // Arrange
        Donation donation = new Donation();
        donation.setId(1);
        donation.setQuantity(2);

        List<Donation> donations = Collections.singletonList(donation);
        when(donationService.getDonationsByPersonId(1)).thenReturn(Collections.singletonList(donation));

        // Act and Assert
        mockMvc.perform(get("/api/donations/person/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].p_id").value(1))
                .andExpect(jsonPath("$[0].quantity").value(2));
    }

    @Test
    void getDonationsByDate_shouldReturnListOfDonations() throws Exception {
        // Arrange
        Donation donation = new Donation();
        donation.setId(1);
        donation.setDate(LocalDate.parse("2024-10-01"));
        donation.setQuantity(2);

        when(donationService.getDonationsByDate(LocalDate.parse("2024-10-01")))
                .thenReturn(Collections.singletonList(donation));

        // Act and Assert
        mockMvc.perform(get("/api/donations/d_date/2024-10-01"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].d_id").value(1))
                .andExpect(jsonPath("$[0].d_date").value("2024-10-01"))
                .andExpect(jsonPath("$[0].quantity").value(2));
    }
}

