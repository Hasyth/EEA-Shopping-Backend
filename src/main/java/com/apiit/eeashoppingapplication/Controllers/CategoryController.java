package com.apiit.eeashoppingapplication.Controllers;

import com.apiit.eeashoppingapplication.Models.Category;
import com.apiit.eeashoppingapplication.Repositories.CategoryRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping(path = "/public/all")
    public @ResponseBody Iterable<Category> getCategories() {

        return categoryRepository.findAll();
    }


//   @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(path = "/auth/add")
    public Category addNewCategory(@RequestBody String categoryName) {

        Category category = new Category();
       category.setCatName(categoryName);
        categoryRepository.save(category);
        System.out.println(category.getCatName() + "is added ");

        return category;
    }

   //@PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(path = "/auth")
    public Category updateCategory(@RequestBody Category category) {

        categoryRepository.save(category);
        System.out.println(category.getCatName() + " is updated");
        return category;
    }

   // @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(path = "/auth/{id}")
    public boolean deleteCategory(@PathVariable int id) {

        Optional<Category> cat = categoryRepository.findById(id);
        if(cat.isPresent())
            categoryRepository.deleteById(id);
        System.out.println(cat.get().getCatName() + " is deleted");
        return cat.isPresent();
    }


}
