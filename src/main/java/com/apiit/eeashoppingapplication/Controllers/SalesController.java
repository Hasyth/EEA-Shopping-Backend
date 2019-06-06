package com.apiit.eeashoppingapplication.Controllers;

import com.apiit.eeashoppingapplication.Models.Sales;
import com.apiit.eeashoppingapplication.Repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class SalesController {

    @RestController
    @RequestMapping("/sales")
    public class SalesOrderController {
        @Autowired
        SalesRepository salesRepository;

        @GetMapping(path = "/{id}")
        public Optional<Sales> findProduct(@PathVariable int id) {
            return salesRepository.findById(id);
        }

        @GetMapping
        public List<Sales> findAllProducts() {
            return salesRepository.findAll();
        }

        @GetMapping(path = "/user/{userId}")
        public Iterable<Sales> findOrdersByUserId(@PathVariable int userId) {
            return salesRepository.findAllByUserId(userId);
        }

        @PostMapping(path = "/add")
        public Sales saveProduct(@RequestBody Sales orderProduct) {

            return salesRepository.save(orderProduct);
        }

        @PutMapping
        public Sales updateProduct(@RequestBody Sales orderProduct) {
            return salesRepository.save(orderProduct);
        }

        @DeleteMapping(path = "/{id}")
        public boolean deleteProduct(@PathVariable int id) {
            if (salesRepository.existsById(id)) {
                salesRepository.deleteById(id);
                return true;
            }
            return false;
        }
    }
}