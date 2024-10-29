package com.keyin.bloodbank_api.repository;

import com.keyin.bloodbank_api.model.Donation;
import com.keyin.bloodbank_api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;


@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findDonationsByPersonId(Long personId);

    List<Donation> findByPersonBloodType(String bloodType);

    List<Donation> findByDate(LocalDate date);

    List<Donation> findByPersonId(Integer personId);
}
