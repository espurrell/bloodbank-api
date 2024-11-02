package com.keyin.bloodbank_api.repository;

import com.keyin.bloodbank_api.model.Donation;
import com.keyin.bloodbank_api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByBloodType(String bloodType);

    @Query("SELECT d FROM Donation d WHERE d.person.id = :p_id")
    List<Donation> findDonationsByPersonId(int p_id);
}
