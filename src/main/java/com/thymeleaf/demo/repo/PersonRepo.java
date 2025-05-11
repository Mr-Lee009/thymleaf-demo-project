package com.thymeleaf.demo.repo;

import com.thymeleaf.demo.entities.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Persons, Integer> {

}
