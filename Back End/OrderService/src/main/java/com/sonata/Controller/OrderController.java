package com.sonata.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sonata.Modal.Orders;
import com.sonata.Repository.OrdersRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrdersRepository repo;
	
	Optional<Orders> o;
	
	@GetMapping("")
	public List<Orders> getAllOrders(){
		return repo.findAll();
	}
	
	@GetMapping("user/{id}")
	public List<Orders> userOrders(@PathVariable (value = "id") Long id){
		return repo.findByUserId(id);
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity getOrderById(@PathVariable (value = "orderId") Long orderId) {
		o = repo.findById(orderId);
		return ResponseEntity.ok().body(o);
	}
	
	@PostMapping("")
	public Orders createOrder(@RequestBody Orders order) {
		return repo.save(order);
	}
	
	@PutMapping("/{orderId}")
	public ResponseEntity updateOrder(@PathVariable (value = "orderId") Long orderId, 
			@Validated @RequestBody Orders orderDetails) {
		o = repo.findById(orderId);
		Orders o2 = o.get();
		
		o2.setOrderId(orderId);
		o2.setEventId(orderDetails.getEventId());
		o2.setOrderStatus(orderDetails.getOrderStatus());
		o2.setPromoCodeDiscount(orderDetails.getPromoCodeDiscount());
		o2.setTicketPrice(orderDetails.getTicketPrice());
		o2.setTicketQuantity(orderDetails.getTicketQuantity());
		o2.setTicketCategory(orderDetails.getTicketCategory());
		o2.setUserId(orderDetails.getUserId());
//		o2.setOrderDate(java.sql.Date.valueOf("2022-03-23"));
		o2.setOrderDate(orderDetails.getOrderDate());
		
		Orders updateO = repo.save(o2);
		return ResponseEntity.ok(updateO);
		
	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity deleteOrder(@PathVariable (value = "orderId") Long orderId) {
		repo.deleteById(orderId);
		return ResponseEntity.noContent().build();
		
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable (value = "id") Long id) {
		repo.deleteByUserId(id);
		return ResponseEntity.noContent().build();
	}
	
//	@Autowired
//	private RestTemplate restTemplate;
//	
//	@RequestMapping("/get/{userId}")
//	public List<Orders> getOrders(@PathVariable ("userId") String userId){
//		Orders orders = restTemplate.getForObject("http://orders-service/orders/get/"+userId, Orders.class);
//		return orders.getUserId().
//		
//	}
	
}
