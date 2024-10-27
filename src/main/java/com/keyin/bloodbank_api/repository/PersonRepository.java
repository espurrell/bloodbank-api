package com.keyin.bloodbank_api.repository;

import com.keyin.bloodbank_api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
