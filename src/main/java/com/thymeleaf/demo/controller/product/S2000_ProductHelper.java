package com.thymeleaf.demo.controller.product;

import com.thymeleaf.demo.entities.Product;
import com.thymeleaf.demo.repo.ProductPepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class S2000_ProductHelper {

  @Autowired
  private ProductPepo repo;

  public List<Product> findAll() {
    return repo.findAll();
  }

  /**
   * find all product with pageable
   * @param pageable pageable
   * @return page of product
   */
  public Page<Product> findAllPageable(Pageable pageable) {
    return repo.findAll(pageable);
  }

  /**
   * delete product by id
   * @param id product id
   */
  public void deletedProductById(Long id) {
    repo.deleteById(id);
  }

  /**
   * find product by id
   * @param id product id
   */
  public Product findById(Long id) {
    return repo.findById(id).get();
  }

  /**
   * Delete product by list of id
   * @param product_ids
   */
  public void deleteInListId(List<Long> ids) {
    repo.deleteAllById(ids);
  }
}
