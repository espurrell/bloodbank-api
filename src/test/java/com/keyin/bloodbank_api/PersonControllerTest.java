package com.keyin.bloodbank_api;

import com.keyin.bloodbank_api.controller.PersonController;
import com.keyin.bloodbank_api.model.Donation;
import com.keyin.bloodbank_api.model.Person;
import com.keyin.bloodbank_api.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PersonControllerTest {

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonService personService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllPersons() {
        List<Person> mockPersons = Arrays.asList(new Person(), new Person());
        when(personService.getAllPersons()).thenReturn(mockPersons);

        ResponseEntity<List<Person>> response = personController.getAllPersons();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testCreatePerson() {
        Person mockPerson = new Person();
        mockPerson.setName("John Doe");

        when(personService.createPerson(mockPerson)).thenReturn(mockPerson);
        ResponseEntity<Person> response = personController.createPerson(mockPerson);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("John Doe", response.getBody().getName());
    }

    @Test
    public void testGetDonationByPersonId() {
        // Mocking Person and Donation objects
        int personId = 1;
        Person mockPerson = new Person();
        mockPerson.setId(personId);
        mockPerson.setName("John Doe");

        Donation donation1 = new Donation();
        donation1.setId(101);
        donation1.setDate(LocalDate.of(2023, 1, 10));
        donation1.setTime(LocalTime.of(10, 30));
        donation1.setQuantity(500);
        donation1.setPerson(mockPerson);

        Donation donation2 = new Donation();
        donation2.setId(102);
        donation2.setDate(LocalDate.of(2023, 2, 15));
        donation2.setTime(LocalTime.of(14, 45));
        donation2.setQuantity(450);
        donation2.setPerson(mockPerson);

        List<Donation> mockDonations = Arrays.asList(donation1, donation2);

        // Mocking the service call
        when(personService.getDonationsByPersonId(personId)).thenReturn(mockDonations);

        // Controller call
        ResponseEntity<List<Donation>> response = personController.getDonationsByPersonId(personId);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals(101, response.getBody().get(0).getId());
        assertEquals(102, response.getBody().get(1).getId());
        assertEquals(500, response.getBody().get(0).getQuantity());
        assertEquals(450, response.getBody().get(1).getQuantity());
    }

}