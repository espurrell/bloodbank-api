package com.keyin.bloodbank_api.controller;

import com.keyin.bloodbank_api.model.Receive;
import com.keyin.bloodbank_api.service.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receive")
public class ReceiveController {

    @Autowired
    private ReceiveService receiveService;

    // 1. Get all receive records
    @GetMapping
    public ResponseEntity<List<Receive>> getAllReceives() {
        List<Receive> receiveList = receiveService.getAllReceives();
        return new ResponseEntity<>(receiveList, HttpStatus.OK);
    }

    // 2. Get receive records by person ID
    @GetMapping("/{pId}")
    public ResponseEntity<List<Receive>> getReceivesByPersonId(@PathVariable int pId) {
        List<Receive> receives = receiveService.getReceivesByPersonId(pId);
        return new ResponseEntity<>(receives, HttpStatus.OK);
    }

    // 3. Add a new "receive" record
    @PostMapping
    public ResponseEntity<Receive> addReceive(@RequestBody Receive receive) {
        Receive newReceive = receiveService.addReceive(receive);
        return new ResponseEntity<>(newReceive, HttpStatus.CREATED);
    }

    // 4. Update a receive record
    @PutMapping("/{id}")
    public ResponseEntity<Receive> updateReceive(@PathVariable int id, @RequestBody Receive receive) {
        Receive updatedReceive = receiveService.updateReceive(id, receive);
        if (updatedReceive != null) {
            return new ResponseEntity<>(updatedReceive, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 5. Delete a "receive" record (optional)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceive(@PathVariable int id) {
        boolean deleted = receiveService.deleteReceive(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
