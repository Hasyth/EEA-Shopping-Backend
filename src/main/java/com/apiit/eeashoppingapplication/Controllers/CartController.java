package com.apiit.eeashoppingapplication.Controllers;

import com.apiit.eeashoppingapplication.Models.Cart;

import com.apiit.eeashoppingapplication.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public Cart newCartItem(@RequestBody Cart newcart) {
        Cart cartItem;
        Optional<Cart> cartOptional = cartRepository.findById(newcart.getCartId());
        if(cartOptional.isPresent()){
            cartItem = cartOptional.get();
            cartItem.setProdQty(cartItem.getProdQty() + newcart.getProdQty());
            updateCart(cartItem);
        }else {
            cartItem = cartRepository.save(newcart);
        }

        System.out.println(cartItem.getCartId() + "is added ");

        return cartItem;
    }

    @PutMapping
    public Cart updateCart(@RequestBody Cart cart) {

        return  cartRepository.save(cart);

    }

    @DeleteMapping(path = "/{id}")
    public void deleteCart(@PathVariable String id) {

        cartRepository.deleteById(id);

    }



}
