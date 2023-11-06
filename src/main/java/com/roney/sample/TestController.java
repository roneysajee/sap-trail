package com.roney.sample;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roney.sample.entity.CustomerOrder;
import com.roney.sample.entity.SiteUser;

@RestController
public class TestController {
	private UserRepository userRepo;
	private OrderRepository orderRepo;
	
	public TestController(UserRepository user, OrderRepository order) {
		this.userRepo = user;
		this.orderRepo = order;
	}
	
	@PostMapping("/users/add")
	public SiteUser createUser(@RequestBody SiteUser user) {
		
		 return userRepo.save(user);
		 
	}
	
	@PostMapping("users/{id}/orders/add")
	public CustomerOrder createOrder(@RequestBody CustomerOrder order, @PathVariable int id) {
		
		SiteUser user = new SiteUser();
		user = userRepo.getById(id);
		order.setUser(user);
		 return orderRepo.save(order);
		  
	}
	
	@GetMapping("users/{id}/orders")
	public List<CustomerOrder> showOrders(@PathVariable int id) {
		SiteUser user = userRepo.findById(id).get();
		List<CustomerOrder> orders = orderRepo.findAllByUser(user);
		
		return orders;
	}
}
