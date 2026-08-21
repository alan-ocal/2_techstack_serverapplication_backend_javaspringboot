package com.dineshonjava.prodos.controller;

import com.dineshonjava.prodos.domain.Product;
import com.dineshonjava.prodos.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository ;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        productRepository .findAll().forEach(i -> products.add(i));
        return products;
    }
    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable String id) {
        return productRepository.findById(id).isPresent() ? productRepository.findById(id).get() : null;
    }

    @GetMapping("/products/brand/{brand}")
    public List<Product> findByBrand(@PathVariable String brand) {
        return productRepository.findByBrand(brand);
    }

    @GetMapping("/products/name/{name}/type/{type}")
    public List<Product> findByNameAndType(@PathVariable String name, @PathVariable String type) {
        return productRepository.findByNameAndType(name, type);
    }


}
