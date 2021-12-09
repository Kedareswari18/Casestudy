package com.cart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.model.Cart;
import com.cart.repository.CartRepository;
import com.example.customexception.ItemException;

@Service
public class CartServiceImplementation implements CartService{
	@Autowired
	private CartRepository cartRepository;
	
	//save cartdetails
	@Override
	public Cart save(Cart cart) {
		if(cart.getItems().isEmpty())
		{
			throw new ItemException("601","Input Field Is Blank");
		}
		Cart c=cartRepository.save(cart);
		return c;
	}
	
	//find all cartdetails
	@Override
	public List<Cart> getAll(){
		return cartRepository.findAll();
		/*
		 * List<Cart> carts= cartRepository.findAll(); if(carts.isEmpty()) { throw new
		 * ItemException("700","Crop List Does Not Exist"); } else { return
		 * cartRepository.findAll(); }
		 */
	}
	
	//find the cartdetails by id
	@Override
	public Optional<Cart> getCartById(int CropId){
		Optional<Cart> findById=cartRepository.findById(CropId);
		if(findById.isEmpty())
		{
			throw new ItemException("602","Input Field Is Empty");
		}
		else {
		return findById;
		}
	}
	
	//delete the cartdetails by id
	@Override
	public String deleteCart( int CropId) {
		boolean isPresent=cartRepository.existsById(CropId);
		if(isPresent)
		{
		cartRepository.deleteById(CropId);
		return "Delete cartdetails with id: "+CropId;
		}
		else
		{
			throw new ItemException("603","Data is not found DataBase");
		}
	}
	
	//update the cropdetails by id
	@Override
	public String updateCart( Cart crop, int CropId) {
		boolean isPresent=cartRepository.existsById(CropId);
		if(isPresent) {
		cartRepository.save(crop);
		return "Update cartdetails with id: "+CropId;
		}
		else
		{
			throw new ItemException("604","Data not existing in DataBase");
		}
	}
	
}
