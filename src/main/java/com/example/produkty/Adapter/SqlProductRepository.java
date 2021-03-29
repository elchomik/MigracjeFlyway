package com.example.produkty.Adapter;

import com.example.produkty.Model.Product;
import com.example.produkty.Model.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlProductRepository extends ProductRepository, JpaRepository<Product,Integer> {

    @Override
    @Query(nativeQuery = true,value = "select count(*) from product where id:=id")
    boolean existsById(@Param("id") Integer id);

    @Override
    @Query("select distinct p from Product p join fetch p.categories")
    List<Product> findAll();
}
