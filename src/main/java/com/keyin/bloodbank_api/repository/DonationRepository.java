package com.keyin.bloodbank_api.repository;

import com.keyin.bloodbank_api.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    // Fetch donations by the blood type of the associated person
    List<Donation> findByPersonPBloodtype(String p_bloodtype);

    // Fetch donations by date
    List<Donation> findByDDate(LocalDate date);

    // Fetch donations by person ID
    List<Donation> getDonationsByPersonId(int pId);
}
