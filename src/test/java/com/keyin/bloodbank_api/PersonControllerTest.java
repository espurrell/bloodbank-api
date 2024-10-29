package com.keyin.bloodbank_api;

import com.keyin.bloodbank_api.controller.PersonController;
import com.keyin.bloodbank_api.model.Person;
import com.keyin.bloodbank_api.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


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
}