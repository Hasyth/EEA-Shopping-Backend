package com.apiit.eeashoppingapplication.Controllers;

import com.apiit.eeashoppingapplication.Models.Category;
import com.apiit.eeashoppingapplication.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Category getCategory(@PathVariable String id) {
        return categoryRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public Category newCategory(@RequestBody Category category) {

        Category newcategory;

        newcategory = categoryRepository.save(category);
        System.out.println(newcategory.getCatName() + "is added ");

        return newcategory;
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category category) {

        categoryRepository.save(category);

        return category;
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteCategory(@PathVariable String id) {

        boolean flag;
        Category category = getCategory(id);
        if (category != null) {
            categoryRepository.deleteById(id);
            flag = true;
        } else {
            flag = false;

        }
        return flag;

    }


}
