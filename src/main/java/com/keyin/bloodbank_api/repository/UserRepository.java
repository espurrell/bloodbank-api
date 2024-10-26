package com.keyin.bloodbank_api.repository;

import com.keyin.bloodbank_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
