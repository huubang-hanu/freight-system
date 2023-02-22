package com.nttdata.order.service.client;

import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;

@RegisterRestClient
@ApplicationScoped
public interface Service {

    @GET
    Response doSomething();

}
