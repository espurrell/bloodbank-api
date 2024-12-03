package com.keyin.bloodbank_api.service;

import com.keyin.bloodbank_api.model.Receive;
import com.keyin.bloodbank_api.repository.ReceiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiveService {

    @Autowired
    private ReceiveRepository receiveRepository;

    // Get all receive records
    public List<Receive> getAllReceives() {
        return receiveRepository.findAll();
    }

// hospital to last receive stock
    public Receive getLastHospitalToReceiveStock() {
        return receiveRepository.findTopByOrderByRDateDesc();
    }

    // Get receive records by person ID
    public List<Receive> getReceivesByPersonId(int p_id) {
        return receiveRepository.findByPersonId(p_id);
    }

    // Add a new "receive" record
    public Receive addReceive(Receive receive) {
        return receiveRepository.save(receive);
    }

    // Update a receive record
    public Receive updateReceive(int id, Receive receiveDetails) {
        Optional<Receive> receiveOptional = receiveRepository.findById(id);
        if (receiveOptional.isPresent()) {
            Receive receive = receiveOptional.get();
            receive.setQuantity(receiveDetails.getQuantity());
            receive.setRDate(receiveDetails.getRDate());
            receive.setRHospital(receiveDetails.getRHospital());
            return receiveRepository.save(receive);
        }
        return null;
    }

    // Delete a receive record
    public boolean deleteReceive(int id) {
        if (receiveRepository.existsById(id)) {
            receiveRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
