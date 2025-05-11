package com.thymeleaf.demo.service;

import com.thymeleaf.demo.dto.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RedisService {
  private static final String HASH_KEY = "STUDENT";

  @Autowired
  private RedisTemplate<Object, Object> redisTemplate;

  private HashOperations<Object, String, Human> hashOperations;

  @Autowired
  public RedisService(RedisTemplate<Object, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
    this.hashOperations = redisTemplate.opsForHash();
  }

  public void save(Human human) {
    hashOperations.put(HASH_KEY, human.getId(), human);
  }

  public Map<String, Human> findAll() {
    return hashOperations.entries(HASH_KEY);
  }

  public Human findById(String id) {
    return hashOperations.get(HASH_KEY, id);
  }

  public void update(Human human) {
    save(human);
  }

  public void delete(String id) {
    hashOperations.delete(HASH_KEY, id);
  }
}
