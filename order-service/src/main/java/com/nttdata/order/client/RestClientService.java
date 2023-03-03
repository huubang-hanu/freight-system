package com.nttdata.order.client;

import com.nttdata.order.model.Item;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;

@RegisterRestClient
@ApplicationScoped
public interface RestClientService {

    @GET
    Response getAllItem();


    @GET
    @Path("/ids")
    Response getAllItemIds();

    @POST
    Response updateItems();

    @GET
    @Path("{id}")
    Item getItemById(@PathParam("id") String id);


}
