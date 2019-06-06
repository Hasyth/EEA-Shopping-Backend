package com.apiit.eeashoppingapplication.Controllers;

import com.apiit.eeashoppingapplication.Models.*;
import com.apiit.eeashoppingapplication.Repositories.ProductRepository;
import com.apiit.eeashoppingapplication.Repositories.UserRepository;
import com.apiit.eeashoppingapplication.Repositories.UsertypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    UsertypeRepository usertypeRepository;

    @PostMapping("/public/register")
    public User addNewUser(@RequestBody UserForm user){

        Usertype type = usertypeRepository.findById(user.usertype).get();
        Set<Usertype> roleSet = new HashSet<>();
        roleSet.add(type);

        User newUser = new User();
        newUser.userName = user.userName;
        newUser.address = user.address;
        newUser.contact = user.contact;
        newUser.email = user.email;
        newUser.image = user.image;
        newUser.password = user.password;
        newUser.usertype = roleSet;
        userRepository.save(newUser);
        System.out.println(newUser.userName + " is added");

        return newUser;
    }


    @PostMapping("/public/authenticate")
    public User findByEmail (@RequestBody Authentication auth){
        User user;
        if(userRepository.existsByEmail(auth.getEmail())){
            if(userRepository.findUserByEmail(auth.getEmail()).get().getPassword().equals(auth.getPassword())){
                user = userRepository.findUserByEmail(auth.getEmail()).get();
            }else {
                user = null;
            }
        }else{
            user = null;
        }

        return user;
    }


    @GetMapping("/{uid}")
    public User getUser(@PathVariable String uid){
        System.out.println("Fetching all products");
        return userRepository.findById(uid).get();
    }


    @GetMapping("/email/{email}")
    public User getUserByEmail (@PathVariable String email){
        System.out.println("Fetching all products");
        return userRepository.findUserByEmail(email).get();
    }

    @GetMapping("check/{email}")
    public Boolean isEmailExist(@PathVariable String email){
        System.out.println("Checking email is available");

        return userRepository.existsByEmail(email);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/auth/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        System.out.println("Fetching all products");
        return userRepository.findAll();
    }

    @PutMapping(path = "/auth")
    public User updateUser(@RequestBody User user) {

        User newuser = userRepository.save(user);
        System.out.println(newuser.userName + " is updated");

        return newuser;
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteUser(@PathVariable String id) {

        Optional u = userRepository.findById(id);
        if(u.isPresent())
            userRepository.deleteById(id);

        System.out.println(u.get().toString() + " is deleted");

        return u.isPresent();


    }
}
