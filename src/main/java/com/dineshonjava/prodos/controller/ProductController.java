package com.dineshonjava.prodos.controller;

import com.dineshonjava.prodos.domain.Product;
import com.dineshonjava.prodos.repository.JdbcProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private JdbcProductRepository jdbcProductRepository;

    public ProductController(JdbcProductRepository jdbcProductRepository) {
        this.jdbcProductRepository = jdbcProductRepository;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        jdbcProductRepository.findAll().forEach(i -> products.add(i));
        return products;
    }
}
