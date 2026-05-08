package com.marlonviado.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor(staticName="Of")
@NoArgsConstructor
@ToString
public class Order {
	
	private String orderId;
	private String item;
	private String amount;
	private int quantity;
	private String transactionId;

}
