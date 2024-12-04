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
        stockService.updateStockQuantity(donation.getPerson().getBloodType(), donation.getQuantity());
        return savedDonation;
    }

    // Get donations by person's ID
    public List<Donation> getDonationsByPersonId(int p_id) {
        return donationRepository.getDonationsByPersonId(p_id);
    }

    // Find donations by date
    public List<Donation> getDonationsByDate(LocalDate d_date) {
        return donationRepository.findByDDate(d_date);
    }

    // Find donations by person's blood type (updated method name)
    public List<Donation> getDonationsByBloodType(String bloodType) {
        return donationRepository.findByPersonBloodType(bloodType); // Correct method name
    }
}
