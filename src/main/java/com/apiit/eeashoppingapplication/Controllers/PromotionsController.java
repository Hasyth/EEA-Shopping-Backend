package com.apiit.eeashoppingapplication.Controllers;


import com.apiit.eeashoppingapplication.Models.Category;
import com.apiit.eeashoppingapplication.Models.Promotions;
import com.apiit.eeashoppingapplication.Repositories.CategoryRepository;
import com.apiit.eeashoppingapplication.Repositories.PromotionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/promotion")
public class PromotionsController{


    @Autowired
    private PromotionsRepository promotionsRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Promotions> getPromotions() {
        return promotionsRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Promotions getPromotions(@PathVariable String id) {
        return promotionsRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public Promotions newCategory(@RequestBody Promotions promotions) {

        promotionsRepository.save(promotions);
        System.out.println(promotions.getPromName() + "is added ");

        return promotions;
    }

    @PutMapping
    public Promotions updatePromotions(@RequestBody Promotions promotions) {

        promotionsRepository.save(promotions);

        return promotions;
    }

    @DeleteMapping(path = "/{id}")
    public void deletePromotions(@PathVariable String id) {

        promotionsRepository.deleteById(id);


    }


}
