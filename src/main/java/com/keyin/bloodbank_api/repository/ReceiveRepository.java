package com.keyin.bloodbank_api.repository;

import com.keyin.bloodbank_api.model.Receive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiveRepository extends JpaRepository<Receive, Integer> {
    List<Receive> findByPersonId(int personId);
}
