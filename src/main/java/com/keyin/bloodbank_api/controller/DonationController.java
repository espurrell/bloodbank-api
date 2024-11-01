// src/main/java/com/example/bloodbank/controller/DonationController.java

package com.keyin.bloodbank_api.controller;

import com.keyin.bloodbank_api.model.Donation;
import com.keyin.bloodbank_api.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/donations")
public class DonationController {

    @Autowired
    private DonationService donationService;

    // Add a new donation
    @PostMapping
    public ResponseEntity<Donation> addDonation(@RequestBody Donation donation) {
        Donation savedDonation = donationService.addDonation(donation);
        return ResponseEntity.ok(savedDonation);
    }

    // Get all donations by a person
    @GetMapping("/person/{pId}")
    public ResponseEntity<List<Donation>> getDonationsByPersonId(@PathVariable int pId) {
        List<Donation> donations = donationService.getDonationsByPersonId(pId);
        return ResponseEntity.ok(donations);
    }

    // Get donations by date
    @GetMapping("/date/{dDate}")
    public ResponseEntity<List<Donation>> getDonationsByDate(@PathVariable String dDate) {
        LocalDate date = LocalDate.parse(dDate);
        List<Donation> donations = donationService.getDonationsByDate(date);
        return ResponseEntity.ok(donations);
    }

    // Get donations by blood type
    @GetMapping("/bloodType/{bloodType}")
    public ResponseEntity<List<Donation>> getDonationsByBloodType(@PathVariable String bloodType) {
        List<Donation> donations = donationService.getDonationsByBloodType(bloodType);
        return ResponseEntity.ok(donations);
    }
}
