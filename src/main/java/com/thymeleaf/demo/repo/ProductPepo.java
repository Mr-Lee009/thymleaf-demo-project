package com.thymeleaf.demo.repo;

import com.thymeleaf.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPepo extends JpaRepository<Product,Long> {
}
