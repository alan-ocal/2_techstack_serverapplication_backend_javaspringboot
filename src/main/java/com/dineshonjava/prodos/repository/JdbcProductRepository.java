package com.dineshonjava.prodos.repository;

import org.springframework.stereotype.Repository;
import com.dineshonjava.prodos.domain.Product;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcProductRepository implements ProductRepository {

    //Springframework provides the JdbcTemplate class to simplify JDBC operations.
    private JdbcTemplate jdbcTemplate;

    //injects JdbcTemplate via the constructor
    public JdbcProductRepository(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Iterable<Product> findAll(){
        return jdbcTemplate.query("select id, name, type from Product", this::mapRowToProduct);
    }

    @Override
    public Product findOne(String id) {
        String sql = "select id, name, type from Product where id = ?";
        //calling the queryForObject method of the JdbcTemplate class and mapped the result set to a Product object
        return jdbcTemplate.queryForObject(sql, this::mapRowToProduct, id);
    }

    @Override
    public Product save(Product product) {
        String sql = "insert into Product (id, name, type) values (?, ?, ?)";
        jdbcTemplate.update(sql,
                product.getId(),
                product.getName(),
                product.getType());
        return product;
    }

    //mapping rows a ResultSet on a per row basis
    private Product mapRowToProduct(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("type"));
    }

}
