package com.thymeleaf.demo.controller.rest;

import com.thymeleaf.demo.dto.Human;
import com.thymeleaf.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/students")
public class RedisController {

  @Autowired
  private RedisService redisService;

  @PostMapping
  public void addStudent(@RequestBody Human human) {
    redisService.save(human);
  }

  @GetMapping
  public Map<String, Human> getAllStudents() {
    return redisService.findAll();
  }

  @GetMapping("/{id}")
  public Human getStudentById(@PathVariable String id) {
    return redisService.findById(id);
  }

  @PutMapping("/{id}")
  public void updateStudent(@PathVariable String id, @RequestBody Human human) {
    Human existingStudent = redisService.findById(id);
    if (existingStudent != null) {
      human.setId(id);
      redisService.update(human);
    }
  }

  @DeleteMapping("/{id}")
  public void deleteStudent(@PathVariable String id) {
    redisService.delete(id);
  }
}
