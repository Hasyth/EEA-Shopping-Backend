package com.apiit.eeashoppingapplication.Controllers;

import com.apiit.eeashoppingapplication.Models.Cart;

import com.apiit.eeashoppingapplication.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    private CartRepository cartRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Cart> getCartItems() {
        return cartRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Cart getCartItem(@PathVariable String id) {
        return cartRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public Cart newCartItem(@RequestBody Cart cart) {

        cartRepository.save(cart);
        System.out.println(cart.getCartId() + "is added ");

        return cart;
    }

    @PutMapping
    public Cart updateCart(@RequestBody Cart cart) {

        cartRepository.save(cart);

        return cart;

    }

    @DeleteMapping(path = "/{id}")
    public void deleteCart(@PathVariable String id) {

        cartRepository.deleteById(id);

    }



}
