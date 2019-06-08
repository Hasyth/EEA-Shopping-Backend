package com.apiit.eeashoppingapplication.Controllers;


import com.apiit.eeashoppingapplication.Models.Category;
import com.apiit.eeashoppingapplication.Models.Promotion;
import com.apiit.eeashoppingapplication.Repositories.CategoryRepository;
import com.apiit.eeashoppingapplication.Repositories.PromotionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/promotion")
public class PromotionsController{


    @Autowired
    private PromotionsRepository promotionsRepository;

    @GetMapping(path = "/public/all")
    public @ResponseBody Iterable<Promotion> getPromotions() {

        return promotionsRepository.findAll();
    }

    @GetMapping(path = "/public/{id}")
    public Promotion getPromotions(@PathVariable String id) {
        return promotionsRepository.findById(id).get();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(path = "/auth/new")
    public Promotion newCategory(@RequestBody Promotion promotions) {

         Promotion newpromotions = promotionsRepository.save(promotions);
        System.out.println(newpromotions.getPromName() + "is added ");

        return newpromotions;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(path = "/auth")
    public Promotion updatePromotions(@RequestBody Promotion promotions) {

        System.out.println(promotions.getPromName() +" is updating");
        return promotionsRepository.save(promotions);


    }

    @PreAuthorize(("hasAnyRole('ADMIN')"))
    @DeleteMapping( "/auth/{id}")
    public boolean deletePromotions(@PathVariable String id) {


        Optional p = promotionsRepository.findById(id);
        if(p.isPresent()){
            promotionsRepository.deleteById(id);
            System.out.println(p.get() + " is deleted");
            return true;
        }
        else {
            return false;
        }
        /*boolean flag;
        Promotions category = getPromotions(id);
        if (category != null) {
            promotionsRepository.deleteById(id);
            flag = true;
        } else {
            flag = false;

        }
        return flag;*/


    }


}
