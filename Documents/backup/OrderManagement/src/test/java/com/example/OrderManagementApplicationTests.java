package com.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.Orders;
import com.example.repository.OrderRepository;
import com.example.service.OrderService;


@RunWith(SpringRunner.class)
@SpringBootTest
class OrderManagementApplicationTests {
	
	@Autowired
	private OrderService orderService;
	
	@MockBean
	private OrderRepository orderRepository;
	
	@Test
	public void getAllOrdersTest()
	{
	when(orderRepository.findAll()).thenReturn(Stream.of
	(new Orders(1,"2021-07-25",1,200,"paytm","paid",2,1,"Mango","Anirban Dey","801374773","Kolkata","West Bengal",2334411)
	,new Orders(1,"2021-07-25",123,2347,"Paypal","Paid",2,1,"Apple","Sawan","345678","delhi","ncr",2334411))
	.collect(Collectors.toList()));
	assertEquals(2,orderService.getAllOrders().size());
	}

	

}
