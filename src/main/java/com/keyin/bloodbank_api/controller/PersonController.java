package com.keyin.bloodbank_api.controller;

import com.keyin.bloodbank_api.model.Person;
import com.keyin.bloodbank_api.service.PersonService;
import com.keyin.bloodbank_api.model.Donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    @GetMapping("/{p_id}/donations")
    public ResponseEntity<List<Donation>> getDonationsByPersonId(@PathVariable int p_id) {
        List<Donation> donations = personService.getDonationsByPersonId(p_id);
        return ResponseEntity.ok(donations);
    }

    @GetMapping("/bloodType/{bloodType}")
    public ResponseEntity<List<Person>> getPersonsByBloodType(@PathVariable String bloodType) {
        List<Person> personByBloodType = personService.getPersonByBloodType(bloodType);
        return ResponseEntity.ok(personByBloodType);
    }
}
