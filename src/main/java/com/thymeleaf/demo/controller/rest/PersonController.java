package com.thymeleaf.demo.controller.rest;

import com.thymeleaf.demo.dto.Human;
import com.thymeleaf.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/api/person")
public class PersonController {
  @Autowired
  PersonService personService;

  @GetMapping("/add")
  public String add() {
    Random random = new Random();
    Integer success = personService.insert(
        Human.builder()
        .old(random.nextInt(1, 100))
        .phone("0977777")
        .salary(random.nextDouble(100, 10000))
        .name("ducla "+ random.nextInt(1, 100))
        .build());
    return success > 0 ? "insert ok " + success : "false";
  }

  @GetMapping("/find-all")
  public Object findAll(){
    return personService.findAll();
  }
}
