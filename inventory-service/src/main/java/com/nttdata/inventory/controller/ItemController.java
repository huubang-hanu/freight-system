package com.nttdata.inventory.controller;

import com.nttdata.inventory.repository.entity.Item;
import com.nttdata.inventory.service.ItemService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;


@Path("item")
@OpenAPIDefinition(info = @Info(title = "Item Management endpoint", version = "1.0"))
public class ItemController {
	private final  ItemService itemService;

	@Inject
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@APIResponses(value = {
		@APIResponse(
			responseCode = "200",
			description = "List all items",
			content = @Content(
				mediaType = MediaType.APPLICATION_JSON,
				schema = @Schema(
					ref = "Item"))
		)
	})
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllItem() {
		return Response.status(Response.Status.OK)
			.entity(itemService.getAllItem())
			.build();
	}

	@APIResponses(value = {
		@APIResponse(
			responseCode = "200",
			description = "List all items id",
			content = @Content(
				mediaType = MediaType.APPLICATION_JSON,
				schema = @Schema(
					ref = "Item"))
		)
	})
	@GET
	@Path("/ids")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllItemIds() {
		return Response.status(Response.Status.OK)
			.entity(itemService.getAllItemIds())
			.build();
	}


	@APIResponses(value = {
		@APIResponse(
			responseCode = "200",
			description = "Validate item and add item to inventory",
			content = @Content(
				mediaType = MediaType.APPLICATION_JSON,
				schema = @Schema(
					ref = "Item"))
		)
	})


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createItem(@RequestBody Item item) {

		itemService.createItem(item);

		return Response.status(Response.Status.CREATED).entity(item.getId()).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update/{id}")
	public Response updateItem(@PathParam("id") String id, @RequestBody Item item) {

		itemService.updateItem(id, item);

		return Response.status(Response.Status.CREATED).entity(item.getId()).build();
	}
}
