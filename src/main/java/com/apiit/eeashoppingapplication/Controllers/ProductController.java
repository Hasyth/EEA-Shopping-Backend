package com.apiit.eeashoppingapplication.Controllers;

import com.apiit.eeashoppingapplication.Repositories.ProductRepository;
import com.apiit.eeashoppingapplication.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class   ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Product> getProducts() {
        System.out.println("Fetching all products");
        return productRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Product getProduct(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return productRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public Product newProduct(@RequestBody Product product) {

        Product newproduct;


        newproduct = productRepository.save(product);
        System.out.println(newproduct.getProdName() + "is added ");

        return newproduct;
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {

            return productRepository.save(product);

    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteProduct(@PathVariable String id) {

        boolean flag;
        Product product = getProduct(id);
        if(product != null){
            productRepository.deleteById(id);
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }

}
