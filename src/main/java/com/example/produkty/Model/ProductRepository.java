package com.example.produkty.Model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository {

    List<Product> findAll();

    Optional<Product> findById(Integer id);

    boolean existsById(Integer id);

    Product save(Product product);

    Page<Product> findAll(Pageable pageable);

    List<Product> findByName(String name);

    void deleteById(Integer id);
}
