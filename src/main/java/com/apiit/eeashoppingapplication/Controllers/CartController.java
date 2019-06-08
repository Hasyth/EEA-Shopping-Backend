package com.apiit.eeashoppingapplication.Controllers;

import com.apiit.eeashoppingapplication.Models.Cart;
import com.apiit.eeashoppingapplication.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/auth/cart")
public class CartController {

    @Autowired
    CartRepository cartRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Cart> getCartItems() {

        return cartRepository.findAll();
    }

    @GetMapping(path = "/uid/{userId}")
    public @ResponseBody Iterable<Cart> getCartItemsByUserId(@PathVariable String userId) {

        return cartRepository.findAllByUserEmail(userId);
    }

    @PostMapping(path = "/add")
    public Cart addNewCartItem(@RequestBody Cart newCartItem) {
        Cart cart = null;
        for(Cart cartItem : getCartItems()){
            if(cartItem.getProduct().getProdId().equals(newCartItem.getProduct().getProdId()) && cartItem.getUserEmail().equals(newCartItem.getUserEmail())){
                cart = cartItem;
            }
        }

        if(cart == null){
            cart = newCartItem;
        }else {
            int qty = cart.getProdQty() + newCartItem.getProdQty();
            cart.setProdQty(qty);
        }
        cartRepository.save(cart);
        System.out.println(cart.getCartId() + " item added");

        return cart;
    }

    @PostMapping(path = "add/items")
    public Iterable<Cart> AddItemsToCart(@RequestBody Iterable<Cart> items){
        return cartRepository.saveAll(items);
    }
    @PutMapping
    public Cart updateCart(@RequestBody Cart cart) {

        cartRepository.save(cart);
        return cart;

    }

    @DeleteMapping("/{cartid}")
    public Iterable<Cart> deleteCartItem(@PathVariable String cartid) {

        Cart cart = cartRepository.findById(cartid).get();
        cartRepository.deleteById(cartid);
        System.out.println(cart.getCartId()+ "deleted");

        return cartRepository.findAll();

    }

    @DeleteMapping("/delete")
    public Iterable<Cart> deleteCartItems(@RequestBody Iterable<Cart> cartItems) {

        cartRepository.deleteAll(cartItems);
        return cartRepository.findAll();
    }

}
