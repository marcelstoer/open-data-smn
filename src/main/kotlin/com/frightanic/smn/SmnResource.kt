package com.frightanic.smn

import com.frightanic.smn.api.SmnRecord
import com.frightanic.smn.api.geojson.CrsType
import com.frightanic.smn.api.geojson.FeatureCollection
import com.frightanic.smn.core.GeoAdmin
import io.quarkus.cache.CacheResult
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType.STRING
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam

private const val cacheName = "http"

@Path("/smn")
@Tag(
    name = "smn",
    description = "Methods to retrieve SwissMetNet data. " +
            "The actual data is provided by https://opendata.swiss/de/dataset/messdaten-smn-swissmetnet. " +
            "A new set of data is released every 10min."
)
@ApplicationScoped
class SmnResource(val geoAdmin: GeoAdmin) {

    @GET
    @Operation(
        summary = "Get all data from all SMN stations",
        description = "Data is cached with a short TTL."
    )
    @CacheResult(cacheName = cacheName)
    fun list(): Collection<SmnRecord> {
        return geoAdmin.getSmnData().getAllRecords()
    }

    @GET
    @Path("{code : [A-Z]{3}}")
    @Operation(
        summary = "Get data for a single SMN station",
        description = "Data is cached with a short TTL."
    )
    @CacheResult(cacheName = cacheName)
    fun getSmnRecord(
        @Parameter(description = "3-char upper-case code of an SMN station", required = true)
        @PathParam("code") code: String
    ): SmnRecord? {
        return geoAdmin.getSmnData().getRecordFor(code)
    }

    @GET
    /*
     * OpenAPI defines a unique operation as a combination of a path and an HTTP method.
     * This means that two GET or two POST methods for the same path are not allowed –
     * even if they have different 'Accept' headers.
     * Hence, content-negotiation as supported by JAX-RS is not fully supported in OpenAPI.
     *
     * -> define an artificial path 'geojson'
     */
    @Path("geojson")
    @Operation(
        summary = "Get all data from all SMN stations represented as GeoJSON",
        description = "Data is cached with a short TTL.",
    )
    @Produces("application/vnd.geo+json")
    fun listGeoJson(
        @Parameter(
            description = "geo projection i.e. CRS, either CH1903 or WGS84 (default)",
            schema = Schema (type = STRING, enumeration = ["CH1903", "WGS84"], defaultValue = "WGS84")
        )
        @QueryParam("projection") projection: String?
    ): FeatureCollection? {
        val crsType: CrsType = if (projection.isNullOrEmpty()) CrsType.WGS84 else CrsType.valueOf(projection)
        return FeatureCollection(crsType, geoAdmin.getSmnData().getAllRecords())
    }
}
