package com.keyin.bloodbank_api;

import com.keyin.bloodbank_api.controller.UserController;
import com.keyin.bloodbank_api.model.User;
import com.keyin.bloodbank_api.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        List<User> mockUsers = Arrays.asList(new User(), new User());
        when(userService.getAllUsers()).thenReturn(mockUsers);

        List<User> users = userController.getAllUsers();
        assertEquals(2,users.size());
    }

    @Test
    public void testCreateUser() {
        User mockUser = new User();
        mockUser.setUsername("jdoe");
        mockUser.setPassword("password123");

        when(userService.createUser(mockUser)).thenReturn(mockUser);
        ResponseEntity<User> response = userController.createUser(mockUser);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
