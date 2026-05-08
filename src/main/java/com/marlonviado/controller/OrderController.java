package com.marlonviado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marlonviado.dto.Order;
import com.marlonviado.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public String greeting() {
		return "Greeting from Docker!!!";
	}
	
	@PostMapping
	public ResponseEntity<Order> processOrder(@RequestBody Order order) {
		try {
			orderService.processOrder(order);
			orderService.notifyUser(order);
			orderService.assignVendor(order);
			orderService.packaging(order);
			orderService.assignDelivery(order);
			orderService.assignTrailerAndDispatch(order);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(order);
	}

}
