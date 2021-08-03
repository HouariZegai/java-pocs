package com.houarizegai.springredis.controller;

import com.houarizegai.springredis.entity.Product;
import com.houarizegai.springredis.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable int id) {
        return productRepository.deleteById(id);
    }

    @GetMapping
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable int id) {
        return productRepository.findById(id);
    }
}
