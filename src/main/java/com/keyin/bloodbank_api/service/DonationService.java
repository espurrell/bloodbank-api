package com.keyin.bloodbank_api.service;

import com.keyin.bloodbank_api.model.Donation;
import com.keyin.bloodbank_api.repository.DonationRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.List;


    @Service
        public class DonationService {

            @Autowired
            private DonationRepository donationRepository;

            @Autowired
            private StockService stockService;

            // Add a new donation and update stock accordingly
            public Donation addDonation(Donation donation) {
                Donation savedDonation = donationRepository.save(donation);
                stockService.updateStockQuantity(donation.getPerson().getBloodtype(), donation.getQuantity());
                return savedDonation;
            }

            // Find all donations by a person
            public List<Donation> getDonationsByPersonId(int pId) {
                return donationRepository.findByPersonId(pId);
            }

            // Find donations by date
            public List<Donation> getDonationsByDate(LocalDate dDate) {
                return donationRepository.findByDate(dDate);
            }

            // Find donations by blood type
            public List<Donation> getDonationsByBloodType(String bloodType) {
                return donationRepository.findByPersonBloodtype(bloodType);
            }
        }



