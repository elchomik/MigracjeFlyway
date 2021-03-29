package com.example.produkty.Model;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository {

    List<Category> findAll();
    Optional<Category> findById(Integer id);

    Page<Category> findAll(Pageable pageable);

    Category save(Category category);

    boolean existsById(Integer id);
}
