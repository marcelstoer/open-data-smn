package com.frightanic.smn.resource;

import com.frightanic.smn.api.SmnRecord;
import com.frightanic.smn.core.GeoAdmin;
import com.codahale.metrics.annotation.Timed;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Collection;

@Path("/smn")
@Api(value = "smn", description = "Methods to retrieve SwissMetNet data. The actual data is provided by frightanic"
  + ".admin.ch. A new set of data is released every 10min.")
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class SmnResource {
  private final GeoAdmin geoAdmin;

  public SmnResource(GeoAdmin geoAdmin) {
    this.geoAdmin = geoAdmin;
  }

  @GET
  @Timed
  @ApiOperation(value = "Get all data from all SMN stations", notes = "Data is cache with a short TTL.  ",
    response = SmnRecord.class, responseContainer = "List")
  public Collection<SmnRecord> list() throws IOException {
    return geoAdmin.getSmnData().getAllRecords();
  }

  @GET
  @Timed
  @Path("/{code}")
  @ApiOperation(value = "Get data for a single SMN station", notes = "The 'code' parameter is expected to be all "
    + "upper-case. Data is cached with a short TTL.", response = SmnRecord.class)
  public SmnRecord getSmnRecord(@ApiParam(value = "all upper-case code of an SMN station",
    required = true) @PathParam("code") String code) throws IOException {
    return geoAdmin.getSmnData().getRecordFor(code);
  }
}
