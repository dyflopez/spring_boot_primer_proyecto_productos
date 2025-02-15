package com.aulamatriz.product.service.impl;

import com.aulamatriz.product.entities.ProductEntity;
import com.aulamatriz.product.repository.ProductRepository;
import com.aulamatriz.product.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<?> create(ProductEntity product) {

        ProductEntity newProduct = this.productRepository.save(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newProduct);
    }

    @Override
    public ResponseEntity<List<ProductEntity>> findAll() {

        var products = this.productRepository.findAll();
        return ResponseEntity
                .ok(products);
    }

    @Override
    public ResponseEntity<ProductEntity> findById(int id) {
        Optional<ProductEntity> products =  this.productRepository.findById(id);
        if(products.isPresent()){
            return ResponseEntity
                    .ok(products.get());
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @Override
    public ResponseEntity<?> update(int id, ProductEntity product) {
        Optional<ProductEntity> products =  this.productRepository.findById(id);
        if(products.isPresent()){
            ProductEntity productEntity = products.get();
            productEntity.setName(product.getName());
            productEntity.setPrice(product.getPrice());
            productEntity.setDescription(product.getDescription());
            productEntity.setStock(product.getStock());
            ProductEntity newProduct = this.productRepository.save(productEntity);
            return ResponseEntity
                    .ok(newProduct);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        Optional<ProductEntity> optionalProduct =  this.productRepository.findById(id);
        if(optionalProduct.isPresent()){
            this.productRepository.deleteById(id);
            return ResponseEntity.ok().body("price deleted");
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Product not found");
    }
}
