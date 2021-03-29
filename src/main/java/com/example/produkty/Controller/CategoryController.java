package com.example.produkty.Controller;

import com.example.produkty.Model.Category;
import com.example.produkty.Model.CategoryRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping(value = "/categories",params = {"!sort,!page,!size"})
    ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok(categoryRepository.findAll());

    }

    @GetMapping("/categories")
    ResponseEntity<List<Category>> getAllCategories(Pageable pageable){
        return ResponseEntity.ok(categoryRepository.findAll(pageable).getContent());

    }


    @PutMapping("/categories/{id}")
    ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody @Valid Category category){
        if(!categoryRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        category.setId(id);
       categoryRepository.save(category);
        return ResponseEntity.noContent().build();

    }

    @PostMapping("/categories")
    ResponseEntity<Category> addCategory(@RequestBody @Valid Category category){
        Category result=categoryRepository.save(category);
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }

    @GetMapping("/categories/{id}")
    ResponseEntity<Category> getSingleCategory(@PathVariable int  id){

        return categoryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
