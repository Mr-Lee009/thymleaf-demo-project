package com.thymeleaf.demo.service;

import com.thymeleaf.demo.config.datasource.annotation.ReadOnly;
import com.thymeleaf.demo.config.datasource.annotation.WriteOnly;
import com.thymeleaf.demo.dto.Human;
import com.thymeleaf.demo.entities.Persons;
import com.thymeleaf.demo.repo.PersonRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PersonService {

  @Autowired
  private PersonRepo personRepo;


  @WriteOnly
  public Integer insert(Human human){
    Persons entity = new Persons();
    entity.setFirstName(human.getName());
    entity.setLastName("No LastName");
    entity.setCity("No city");
    entity.setAddress("No Address");
    entity = personRepo.save(entity);
    return entity.getId();
  }

  @ReadOnly
  public List<Persons> findAll(){
    return personRepo.findAll();
  }
}
