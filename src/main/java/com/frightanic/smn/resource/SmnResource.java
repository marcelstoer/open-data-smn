package com.frightanic.smn.resource;

import com.codahale.metrics.annotation.Timed;
import com.frightanic.smn.api.SmnRecord;
import com.frightanic.smn.api.geojson.CrsType;
import com.frightanic.smn.api.geojson.FeatureCollection;
import com.frightanic.smn.core.GeoAdmin;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Collection;

@Path("/smn")
@Api(value = "smn", description = "Methods to retrieve SwissMetNet data. The actual data is provided by "
  + "https://opendata.swiss/de/dataset/messdaten-smn-swissmetnet.  A new set of data is released every 10min.")
public class SmnResource {
  private static final String GEO_JSON_MIME_TYPE = "application/vnd.geo+json";
  private static final String GEO_JSON_MIME_TYPE_UTF8 = GEO_JSON_MIME_TYPE + "; charset=UTF-8";
  private final GeoAdmin geoAdmin;

  public SmnResource(GeoAdmin geoAdmin) {
    this.geoAdmin = geoAdmin;
  }

  @GET
  @Timed
  @ApiOperation(value = "Get all data from all SMN stations", notes = "Data is cached with a short TTL.",
    response = SmnRecord.class, responseContainer = "List")
  @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
  public Collection<SmnRecord> list() throws IOException {
    return geoAdmin.getSmnData().getAllRecords();
  }

  @GET
  @Timed
  @ApiOperation(value = "Get all data from all SMN stations represented as GeoJSON (requires GeoJSON accept header)",
    notes = "Data is cached with a short TTL.",
    response = FeatureCollection.class)
  @Consumes(GEO_JSON_MIME_TYPE)
  @Produces(GEO_JSON_MIME_TYPE_UTF8)
  public FeatureCollection listGeoJson(@ApiParam(value = "geo projection i.e. CRS, either CH1903 or WGS84 (default)",
    required = false) @QueryParam("projection") String projection) throws IOException {
    CrsType crsType = StringUtils.isEmpty(projection) ? CrsType.WGS84 : CrsType.valueOf(projection);
    return new FeatureCollection(crsType, geoAdmin.getSmnData().getAllRecords());
  }

  @GET
  @Timed
  @Path("/{code}")
  @ApiOperation(value = "Get data for a single SMN station", notes = "The 'code' parameter is expected to be all "
    + "upper-case. Data is cached with a short TTL.", response = SmnRecord.class)
  @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
  public SmnRecord getSmnRecord(@ApiParam(value = "all upper-case code of an SMN station",
    required = true) @PathParam("code") String code) throws IOException {
    return geoAdmin.getSmnData().getRecordFor(code);
  }
}
