package com.bookstore.controller;

import com.bookstore.model.CartItem;
import com.bookstore.repository.CartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    private final CartRepository cartRepository;

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // Get all cart items
    @GetMapping
    public List<CartItem> getCartItems() {
        return cartRepository.findAll();
    }

    // Add item to cart
    @PostMapping
    public CartItem addToCart(@RequestBody CartItem cartItem) {

        return cartRepository.save(cartItem);
    }

    // Remove item from cart
    @DeleteMapping("/{id}")
    public void removeFromCart(@PathVariable Long id) {

        cartRepository.deleteById(id);
    }
}
