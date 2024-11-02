package com.keyin.bloodbank_api.repository;

import com.keyin.bloodbank_api.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    // Fetch donations by the blood type of the associated person
    @Query("SELECT d FROM Donation d WHERE d.person.p_bloodtype = :bloodtype")
    List<Donation> findByPersonBloodType(@Param("bloodtype") String bloodtype);

    // Fetch donations by date
    @Query("SELECT d FROM Donation d WHERE d.d_date = :date")
    List<Donation> findByDDate(LocalDate date);

    // DonationRepository.java
    @Query("SELECT d FROM Donation d WHERE d.person.p_id = :p_id")
    List<Donation> getByPersonId(@Param("p_id") int p_id);

    @Query("SELECT d FROM Donation d WHERE d.person.p_id = :p_id")
    List<Donation> getDonationsByPersonId(int pId);
}
