package com.nttdata.order.controller;

import com.nttdata.order.client.RestClientService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/order")
@ApplicationScoped
public class OrderController {
	@Inject
	@RestClient
	private RestClientService restClientService;


	@GET
	public Response fetchAllItem() {
		return restClientService.getAllItem();
	}

	@GET
	@Path("/ids")
	public Response fetchAllItemIds() {
		return restClientService.getAllItemIds();
	}
}

