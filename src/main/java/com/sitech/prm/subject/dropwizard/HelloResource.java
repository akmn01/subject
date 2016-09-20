package com.sitech.prm.subject.dropwizard;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;

@Path("/consent")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
  @GET
  public HelloResult sayHello(@QueryParam("name") Optional<Object> name) {
      return new HelloResult(String.format("Hello, %s", name.or("Stranger")));
  }
}