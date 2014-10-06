package com.frightanic.smn.resource;

import com.frightanic.smn.view.IndexView;
import com.codahale.metrics.annotation.Timed;
import com.wordnik.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Api(value = "/", description = "root resource which uses DropWizard Views.")
@Produces(MediaType.TEXT_HTML)
public class RootResource {

  @GET
  @Timed
  public IndexView index() {
    return new IndexView();
  }
}
