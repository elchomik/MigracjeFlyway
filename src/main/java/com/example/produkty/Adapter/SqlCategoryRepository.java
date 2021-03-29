package com.example.produkty.Adapter;

import com.example.produkty.Model.Category;
import com.example.produkty.Model.CategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlCategoryRepository extends CategoryRepository, JpaRepository<Category,Integer> {

    @Override
    boolean existsById(Integer id);
}
