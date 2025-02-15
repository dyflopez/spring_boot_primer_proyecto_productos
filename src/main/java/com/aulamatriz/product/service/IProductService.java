package com.aulamatriz.product.service;

import com.aulamatriz.product.entities.ProductEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductService {

    ResponseEntity<?> create (ProductEntity product);

    ResponseEntity<List<ProductEntity>> findAll();

    ResponseEntity<ProductEntity> findById(int id);

    ResponseEntity<?> update(int id, ProductEntity product);

    ResponseEntity<?> delete(int id);
}
