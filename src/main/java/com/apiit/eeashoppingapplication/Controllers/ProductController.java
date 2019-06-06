package com.apiit.eeashoppingapplication.Controllers;

import com.apiit.eeashoppingapplication.Repositories.ProductRepository;
import com.apiit.eeashoppingapplication.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class   ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(path = "/auth/add")
    public Product addNewProduct(@RequestBody Product product){
        productRepository.save(product);
        System.out.println(product.getProdName() + " is added");

        return product;
    }


    @GetMapping(path = "/public/all")
    public @ResponseBody Iterable<Product> getProducts() {
        System.out.println("Fetching all products");
        return productRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Product getProduct(@PathVariable String id) {
        System.out.println("Fetching product " + id);
        return productRepository.findById(id).get();
    }

    @GetMapping(path = "/public/category/{cat_id}")
    public Iterable getProductsFromCategory(@PathVariable String cat_id){
        System.out.println("Fetching products from category "+cat_id);
        return productRepository.findAllByProdCategoryId(cat_id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(path = "/auth")
    public boolean updateProduct(@RequestBody Product product){

        Optional<Product> prod = productRepository.findById(product.getProdId());
        if (prod.isPresent()) {
            productRepository.save(product);
            System.out.println(product.getProdName() + " is updated");
            return true;

        }{
            System.out.println(product.getProdName()+ " is not updated");
            return false;
        }




    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/auth/{id}")
    public Boolean deleteProduct(@PathVariable String id){

        boolean flag = false;

        productRepository.deleteById(id);

        flag = true;


        return flag;
    }
    /*@DeleteMapping(path = "/{id}")
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
    }*/

}
