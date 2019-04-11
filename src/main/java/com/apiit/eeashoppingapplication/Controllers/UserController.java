package com.apiit.eeashoppingapplication.Controllers;

import com.apiit.eeashoppingapplication.Models.Product;
import com.apiit.eeashoppingapplication.Models.User;
import com.apiit.eeashoppingapplication.Repositories.ProductRepository;
import com.apiit.eeashoppingapplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getUsers() {
        System.out.println("Fetching all products");
        return userRepository.findAll();
    }

    @GetMapping(path = "/id")
    public User getUser(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return userRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public User newUser(@RequestBody User user) {

        userRepository.save(user);
        System.out.println(user.getUserName()+ "is added ");

        return user;
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {

        userRepository.save(user);

        return user;
    }

    @DeleteMapping(path = "/id")
    public void deleteUser(@PathVariable String id) {

        userRepository.deleteById(id);

    }
}
