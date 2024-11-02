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

    // DonationController.java
    @GetMapping("/api/donations/person/{p_id}")
    public ResponseEntity<List<Donation>> getDonationsByPersonName(@PathVariable int p_id) {
        List<Donation> donations = donationService.getDonationsByPersonId(p_id);
        return ResponseEntity.ok(donations);
    }

    // Get donations by date
    @GetMapping("/date/{d_date}")
    public ResponseEntity<List<Donation>> getDonationsByDate(@PathVariable String d_date) {
        LocalDate date = LocalDate.parse(d_date);
        List<Donation> donations = donationService.getDonationsByDate(date);
        return ResponseEntity.ok(donations);
    }

    // Get donations by blood type
    @GetMapping("/bloodType/{d_bloodtype}")
    public ResponseEntity<List<Donation>> getDonationsByBloodType(@PathVariable String d_bloodtype) {
        List<Donation> donations = donationService.getDonationsByBloodType(d_bloodtype);
        return ResponseEntity.ok(donations);
    }

}
