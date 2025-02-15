package com.aulamatriz.product.repository;

import com.aulamatriz.product.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<ProductEntity, Integer> {
}
