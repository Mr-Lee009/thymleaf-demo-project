package com.thymeleaf.demo.service;

import com.thymeleaf.demo.dto.Human;
import com.thymeleaf.demo.entities.Persons;
import com.thymeleaf.demo.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  @Autowired
  private PersonRepo personRepo;

  public Integer insert(Human human){
    Persons entity = new Persons();
    entity.setFirstName(human.getName());
    entity.setLastName("No LastName");
    entity.setCity("No city");
    entity.setAddress("No Address");
    entity = personRepo.save(entity);
    return entity.getId();
  }
}
