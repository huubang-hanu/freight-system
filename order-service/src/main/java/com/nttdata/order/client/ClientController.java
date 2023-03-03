package com.nttdata.order.client;

import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;



@Path("/client")
@ApplicationScoped
public class ClientController {

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
