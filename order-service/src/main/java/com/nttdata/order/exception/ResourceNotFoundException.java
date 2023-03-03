package com.nttdata.order.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException{
	private String itemId;

	public ResourceNotFoundException(String message, String itemId) {
		super(message);
		this.itemId = itemId;
	}
}
