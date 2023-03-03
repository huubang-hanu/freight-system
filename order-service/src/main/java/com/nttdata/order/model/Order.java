package com.nttdata.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	private String id;
	private String itemId;
	private Integer quantity;
	private long createAt;
}
