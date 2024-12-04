package com.keyin.bloodbank_api;

import com.keyin.bloodbank_api.model.Person;
import com.keyin.bloodbank_api.model.Receive;
import com.keyin.bloodbank_api.service.ReceiveService;
import com.keyin.bloodbank_api.controller.ReceiveController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReceiveController.class)
public class ReceiveControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReceiveService receiveService;

    @Autowired
    private ObjectMapper objectMapper; // For converting objects to JSON

    private Receive receive;
    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person(1, "John Doe", "123 Main St", LocalDate.of(1985, 5, 15), "555-555-5555", "M", "O+");
        receive = new Receive(LocalDate.now(), 2, "General Hospital", person);
        receive.setRId(1); // set ID for the mock entity
    }

    // 1. Test GET /api/receive - get all receives
    @Test
    public void testGetAllReceives() throws Exception {
        List<Receive> receiveList = Arrays.asList(receive);
        when(receiveService.getAllReceives()).thenReturn(receiveList);

        mockMvc.perform(get("/api/receive"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(receiveList.size()))
                .andExpect(jsonPath("$[0].rHospital").value("General Hospital"));
    }

    // 2. Test GET /api/receive/{pId} - get receives by person ID
    @Test
    public void testGetReceivesByPersonId() throws Exception {
        List<Receive> receiveList = Arrays.asList(receive);
        when(receiveService.getReceivesByPersonId(1)).thenReturn(receiveList);

        mockMvc.perform(get("/api/receive/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(receiveList.size()))
                .andExpect(jsonPath("$[0].rHospital").value("General Hospital"));
    }

    // 3. Test POST /api/receive - add a new Receive record
    @Test
    public void testAddReceive() throws Exception {
        when(receiveService.addReceive(any(Receive.class))).thenReturn(receive);

        mockMvc.perform(post("/api/receive")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(receive)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.rHospital").value("General Hospital"))
                .andExpect(jsonPath("$.quantity").value(2));
    }

    // 4. Test PUT /api/receive/{id} - update a Receive record
    @Test
    public void testUpdateReceive() throws Exception {
        Receive updatedReceive = new Receive(LocalDate.now(), 3, "City Hospital", person);
        updatedReceive.setRId(1);
        when(receiveService.updateReceive(Mockito.eq(1), any(Receive.class))).thenReturn(updatedReceive);

        mockMvc.perform(put("/api/receive/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedReceive)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rHospital").value("City Hospital"))
                .andExpect(jsonPath("$.quantity").value(3));
    }

    // 5. Test DELETE /api/receive/{id} - delete a receive record
    @Test
    public void testDeleteReceive() throws Exception {
        when(receiveService.deleteReceive(1)).thenReturn(true);
        mockMvc.perform(delete("/api/receive/1"))
                .andExpect(status().isNoContent());
    }
}

