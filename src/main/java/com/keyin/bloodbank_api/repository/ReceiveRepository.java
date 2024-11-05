package com.keyin.bloodbank_api.repository;

import com.keyin.bloodbank_api.model.Receive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiveRepository extends JpaRepository<Receive, Integer> {
    List<Receive> findByPersonId(int p_id);

    @Query("SELECT r FROM Receive r ORDER BY r.r_date DESC LIMIT 1")
    Receive findLastHospitalToReceiveStock();
}
