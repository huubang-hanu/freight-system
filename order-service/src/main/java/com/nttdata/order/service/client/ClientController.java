package com.nttdata.order.service.client;

import io.opentracing.Tracer;
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
    private Service service;

    @Inject
    Tracer tracer;


    @GET
    public Response onClientSide() {
        return service.doSomething();
    }
}
