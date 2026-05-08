package com.marlonviado.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.marlonviado.dto.Order;

@Service
public class PaymentService {
	
	private static final Logger log = LoggerFactory.getLogger(PaymentService.class);
	
	public Order processPayment(Order order) throws InterruptedException {
		Thread.sleep(2000);
		log.info("Payment Completed for Order "+order.getOrderId());
		return order;
	}

}
