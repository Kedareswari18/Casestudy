package com.example.controller;

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


import com.example.model.Orders;
import com.example.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	OrderService orderservice;

	//save the cartdetails
	
	@PostMapping("/saveorder")
	public Orders save(@RequestBody Orders order) {
		return orderservice.addOrder(order);
	
	}
	
	//find allorderdetails
	@GetMapping("/allorder")
	public List<Orders> getAll(){
	return orderservice.getAllOrders();
	}
	
	//find the orderdetails by id
	@GetMapping("/allorder/{customerId}")
	public Optional<Orders> getCartById(@PathVariable  int customerId){
	return orderservice.getOrderById(customerId);
	}
	
	//delete the orderdetails by id
	@DeleteMapping("/delorder/{customerId}")
	public String deleteCart(@PathVariable int customerId) {
		orderservice.deleteOrder(customerId);
	return "Delete cartdetails with id: "+customerId;
	}
	
	//update the cropdetails by id
	@PutMapping("/update/{customerId}")
	public String updateOrder(@RequestBody Orders order,@PathVariable int customerId) {
		
		orderservice.updateOrder(order,customerId);
	return "Update cartdetails with id: "+customerId;

	}



}
