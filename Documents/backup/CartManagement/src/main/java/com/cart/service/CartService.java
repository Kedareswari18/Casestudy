package com.cart.service;

import java.util.List;
import java.util.Optional;

import com.cart.model.Cart;



public interface CartService {
	
	public Cart save( Cart crop);
	public List<Cart> getAll();
	public Optional<Cart> getCartById(int CropId);
	public String deleteCart( int CropId);
	public String updateCart( Cart crop, int CropId);


}
