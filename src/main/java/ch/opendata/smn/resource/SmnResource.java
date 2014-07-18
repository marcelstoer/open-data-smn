package ch.opendata.smn.resource;

import ch.opendata.smn.api.SmnRecord;
import ch.opendata.smn.core.GeoAdmin;
import com.codahale.metrics.annotation.Timed;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Collection;

@Path("/smn")
@Api(value = "/smn", description = "Operations about SwissMetNet SMN")
@Produces(MediaType.APPLICATION_JSON)
public class SmnResource {
  private final GeoAdmin geoAdmin;

  public SmnResource(GeoAdmin geoAdmin) {
    this.geoAdmin = geoAdmin;
  }

  @GET
  @Timed
  @ApiOperation(value = "Find pet by ID", notes = "More notes about this method", response = Collection.class)
  @ApiResponses(value = {
    @ApiResponse(code = 400, message = "Invalid ID supplied"),
    @ApiResponse(code = 404, message = "Pet not found")
  })
  public Collection<SmnRecord> list() throws IOException {
    return geoAdmin.getSmnData().getAllRecords();
  }

  @GET
  @Timed
  @Path("/{code}")
  public SmnRecord getSmnRecord(@PathParam("code") String code) throws IOException {
    return geoAdmin.getSmnData().getRecordFor(code);
  }
}
