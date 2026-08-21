package com.dineshonjava.prodos.repository;

import com.dineshonjava.prodos.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

  //Fetch products by brand
  //?1 First positional parameter (the actual value is passed at runtime)
  @Query("select p from Product p where p.brand = ?1")
  List<Product> findByBrand(String brand);

  // Fetch products by name and type
  @Query("select p from Product p where p.name = ?1 and p.type = ?2")
  List<Product> findByNameAndType(String name, String type);

}
