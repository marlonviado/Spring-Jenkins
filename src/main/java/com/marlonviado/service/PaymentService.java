package com.marlonviado.service;

import org.springframework.stereotype.Service;
import com.marlonviado.dto.Order;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {
	
	public Order processPayment(Order order) throws InterruptedException {
		Thread.sleep(2000);
		log.info("Payment Completed for Order "+order.getOrderId());
		return order;
	}

}
