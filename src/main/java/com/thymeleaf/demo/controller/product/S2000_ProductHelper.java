package com.thymeleaf.demo.controller.product;

import com.thymeleaf.demo.entities.Product;
import com.thymeleaf.demo.repo.ProductPepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class S2000_ProductHelper {

  @Autowired
  private ProductPepo repo;

  public List<Product> findAll() {
    return repo.findAll();
  }
}
