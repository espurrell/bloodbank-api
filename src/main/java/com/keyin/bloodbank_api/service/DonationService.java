package com.keyin.bloodbank_api.service;

import com.keyin.bloodbank_api.model.Donation;
import com.keyin.bloodbank_api.repository.DonationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {
    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public List<Donation> getDonationsByPersonId(Integer personId) {
        return donationRepository.findByPersonId(personId);
    }
}
