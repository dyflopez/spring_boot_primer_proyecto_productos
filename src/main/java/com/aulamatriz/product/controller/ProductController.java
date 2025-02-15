package com.aulamatriz.product.controller;

import com.aulamatriz.product.entities.ProductEntity;
import com.aulamatriz.product.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductEntity productEntity){
        return this.iProductService.create(productEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getById(@PathVariable("id") int id){
        return this.iProductService.findById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteById(@PathVariable("id") int id){
        return this.iProductService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>  updateById(
            @PathVariable("id") int id,
            @RequestBody ProductEntity productEntity){
        return this.iProductService.update(id, productEntity);
    }
}
