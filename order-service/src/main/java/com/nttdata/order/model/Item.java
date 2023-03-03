package com.nttdata.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	private String id;
	private String name;
	private Integer quantity;
	private long price;

}
