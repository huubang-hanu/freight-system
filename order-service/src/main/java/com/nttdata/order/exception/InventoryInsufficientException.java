package com.nttdata.order.exception;

import lombok.Getter;

@Getter
public class InventoryInsufficientException extends RuntimeException {

	private String itemId;

	public InventoryInsufficientException(String message, String itemId) {
		super(message);
		this.itemId = itemId;
	}
}