package com.nttdata.order.service.client;

import io.opentracing.Tracer;
import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;



@Path("/client")
@ApplicationScoped
@Traced
public class ClientController {

    @Inject
    @RestClient
    private Service service;


    @GET
    public Response fetchAllItem() {
        return service.getAllItem();
    }

    @GET
    @Path("/ids")
    public Response fetchAllItemIds() {
        return service.getAllItemIds();
    }


}