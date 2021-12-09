package com.cart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.model.Cart;
import com.cart.service.CartService;
import com.cart.service.CartServiceImplementation;




@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	//save the cartdetails
	
			@PostMapping("/savecart")
			public Cart save(@RequestBody Cart cart) {
			Cart c = cartService.save(cart);
			return c;
			}
			
			//find allcartdetails
			@GetMapping("/allcart")
			public List<Cart> getAll(){
			return cartService.getAll();
			}
			
			//find the cartdetails by id
			@GetMapping("/allcart/{CropId}")
			public Optional<Cart> getCartById(@PathVariable  int CropId){
			return cartService.getCartById(CropId);
			}
			
			//delete the cropdetails by id
			@DeleteMapping("/delcart/{CropId}")
			public String deleteCart(@PathVariable int CropId) {
				cartService.deleteCart(CropId);
			return "Delete cartdetails with id: "+CropId;
			}
			
			//update the cropdetails by id
			@PutMapping("/update/{CropId}")
			public String updateCart(@RequestBody Cart cart,@PathVariable int CropId) {
				cartService.getCartById(CropId);
				cartService.save(cart);
			return "Update cartdetails with id: "+CropId;

			}
	
}
