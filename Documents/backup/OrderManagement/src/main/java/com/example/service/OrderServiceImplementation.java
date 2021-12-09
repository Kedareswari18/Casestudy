package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customexception.OrderServiceException;
import com.example.model.Orders;
import com.example.repository.OrderRepository;

@Service
public class OrderServiceImplementation implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	

	//Add order
	@Override
	public Orders addOrder(Orders order) {
	if(order.getCropDetails().isEmpty()) {
	throw new OrderServiceException("601","Crop Details is empty");
	}else if (order.getAddress().isEmpty()) {
	throw new OrderServiceException("602","Address list is empty");
	}
	Orders orders = orderRepository.save(order);
	return orders;
	}



	//Get All orders
	@Override
	public List<Orders> getAllOrders() {
	List<Orders> allorders = orderRepository.findAll();
	if(allorders.isEmpty()) {
	throw new OrderServiceException("603","Order List is completely empty");
	}
	else {
	return allorders;
	}
	}

	//Get order by id
	@Override
	public Optional<Orders> getOrderById(int customerId) {
	Optional<Orders> findOrderById= orderRepository.findById(customerId);
	if(findOrderById.isEmpty()) {
	throw new OrderServiceException("604","No order found under this Id");
	}else {
	return orderRepository.findById(customerId) ;
	}
	}




	//delete id by id
	@Override
	public String deleteOrder(int customerId) {
	boolean isOrderExist = orderRepository.existsById(customerId);
	if(isOrderExist) {
	orderRepository.deleteById(customerId);
	return "Deleted order with id: "+customerId;
	}else {
	throw new OrderServiceException("605","Unable to delete as order not found with this Id");
	}

	}




	//update data with id
	@Override
	public String updateOrder(Orders order, int customerId) {
	boolean isOrderExist = orderRepository.existsById(customerId);
	if(isOrderExist) {
	orderRepository.save(order);
	return "Updated Order with id: "+customerId;
	}else {
	throw new OrderServiceException("606","Unable to update as order not found with this Id");
	}

	}

	
}
