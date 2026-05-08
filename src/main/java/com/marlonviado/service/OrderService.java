package com.marlonviado.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.marlonviado.dto.Order;

@Service
public class OrderService {
	
	private static final Logger log = LoggerFactory.getLogger(OrderService.class);
	
	/*
	 * @Async annotation can only return either void or CompletableFuture 
	 */
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private PaymentService paymentService;
	
	public void processOrder(Order order) throws InterruptedException {
		order.setTransactionId(UUID.randomUUID().toString());
		log.info("Processing started...");
		if(inventoryService.checkProductAvailability(order)) {
			paymentService.processPayment(order);
			
		} else {
			throw new RuntimeException("Order Failed!");
		}
		log.info("Processing finished...");
	}

	@Async("taskExecutor")
	public CompletableFuture<Order> notifyUser(Order order) throws InterruptedException {
		Thread.sleep(3000);
		log.info("Notified the user "+ Thread.currentThread().getName());
		return CompletableFuture.completedFuture(order);
	}
	
	@Async("taskExecutor")
	public CompletableFuture<Order> assignVendor(Order order) throws InterruptedException {
		Thread.sleep(3000);
		log.info("Assign order to Vendor "+ Thread.currentThread().getName());
		return CompletableFuture.completedFuture(order);
	}
	
	@Async("taskExecutor")
	public CompletableFuture<Order> packaging(Order order) throws InterruptedException {
		Thread.sleep(3000);
		log.info("Order Packaging Completed! "+ Thread.currentThread().getName());
		return CompletableFuture.completedFuture(order);
		
	}
	
	@Async("taskExecutor")
	public CompletableFuture<Order> assignDelivery(Order order) throws InterruptedException {
		Thread.sleep(3000);
		log.info("Delivery Partner assigned! "+ Thread.currentThread().getName());
		return CompletableFuture.completedFuture(order);
	}
	
	@Async("taskExecutor")
	public CompletableFuture<Order> assignTrailerAndDispatch(Order order) throws InterruptedException {
		Thread.sleep(3000);
		log.info("Trailer assigned and already dispatch! "+ Thread.currentThread().getName());
		return CompletableFuture.completedFuture(order);
	}

}
