package ch.opendata.smn.resource;

import ch.opendata.smn.api.SmnRecord;
import ch.opendata.smn.core.GeoAdmin;
import com.codahale.metrics.annotation.Timed;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Collection;

@Path("/smn")
@Api(value = "smn", description = "Methods to retrieve SwissMetNet data.")
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class SmnResource {
  private final GeoAdmin geoAdmin;

  public SmnResource(GeoAdmin geoAdmin) {
    this.geoAdmin = geoAdmin;
  }

  @GET
  @Timed
  @ApiOperation(value = "Get all data from all SMN stations", notes = "Data is cache with a short TTL",
    response = SmnRecord.class, responseContainer = "List")
  public Collection<SmnRecord> list() throws IOException {
    return geoAdmin.getSmnData().getAllRecords();
  }

  @GET
  @Timed
  @Path("/{code}")
  @ApiOperation(value = "Get data for a single SMN station", notes = "The 'code' parameter is expected to be "
    + "upper-case. Data is cache with a short TTL", response = SmnRecord.class)
  public SmnRecord getSmnRecord(@PathParam("code") String code) throws IOException {
    return geoAdmin.getSmnData().getRecordFor(code);
  }
}
