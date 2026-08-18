package com.dineshonjava.prodos.repository;

import com.dineshonjava.prodos.domain.Product;

public interface ProductRepository {

    //operation methods for fetching and saving data
    Iterable<Product> findAll();
    Product findOne(String id);

    Product save(Product product);


}
