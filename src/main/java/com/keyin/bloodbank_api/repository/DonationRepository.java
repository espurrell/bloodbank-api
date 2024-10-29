package com.keyin.bloodbank_api.repository;

import com.keyin.bloodbank_api.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;


@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findDonationsByPersonId(Long personId);




    }

