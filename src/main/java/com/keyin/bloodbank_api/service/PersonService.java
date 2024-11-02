package com.keyin.bloodbank_api.service;

import com.keyin.bloodbank_api.repository.DonationRepository;
import com.keyin.bloodbank_api.model.Person;
import com.keyin.bloodbank_api.repository.PersonRepository;
import com.keyin.bloodbank_api.model.Donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DonationRepository donationRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getPersonByBloodType(String bloodType) {
        return personRepository.findByBloodType(bloodType);
    }

    public List<Donation> getDonationsByPersonId(int p_id) {
        return donationRepository.getDonationsByPersonId(p_id);
    }
}
