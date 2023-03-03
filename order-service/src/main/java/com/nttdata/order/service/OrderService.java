package com.nttdata.order.service;

import com.nttdata.order.client.RestClientService;
import com.nttdata.order.exception.InventoryInsufficientException;
import com.nttdata.order.exception.ResourceNotFoundException;
import com.nttdata.order.model.Item;
import com.nttdata.order.model.Order;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
	private final List<Order> orders = new ArrayList<>();

	@Inject
	@RestClient
	private RestClientService restClientService;

	public void createOrder(Order order){
		isQuantitySufficient(order);
	}

	public void isQuantitySufficient(Order order) {
		Item item = restClientService.getItemById(order.getItemId());

		if(item == null){
			throw new ResourceNotFoundException("Item not found", order.getItemId());
		}

		if(item.getQuantity() < order.getQuantity()){
			throw new InventoryInsufficientException("Item inventory insufficient", order.getItemId());
		}

	}

	public List<Order> findAll() {
		return orders;
	}

}
