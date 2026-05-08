package com.marlonviado.service;

import org.springframework.stereotype.Service;

import com.marlonviado.dto.Order;

@Service
public class InventoryService {
	
	public boolean checkProductAvailability(Order order) {
		return order.getQuantity() < 100 ? true : false;
	}

}
