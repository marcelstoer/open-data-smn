package com.frightanic.smn.api.geojson;

import com.frightanic.smn.api.SmnRecord;
import com.frightanic.smn.api.Station;
import lombok.Getter;

/**
 * Representation of a single feature within a feature collection.
 */
@Getter
public final class Feature {
  private final String type = "Feature";
  private final SmnRecord properties;
  private final Geometry geometry;

  public Feature(CrsType crs, SmnRecord smnRecord) {
    this.properties = smnRecord;
    geometry = createGeometry(crs, smnRecord.getStation());
  }

  private Geometry createGeometry(CrsType crs, Station station) {
    Number[] coordinates;
    if (crs == CrsType.WGS84) {
      // lat/lng are inverted according to GeoJSON spec: http://geojson.org/geojson-spec.html#id2
      coordinates = new Number[]{station.getLng(), station.getLat()};
    } else {
      coordinates = new Number[]{station.getCh1903X(), station.getCh1903Y()};
    }
    return new Geometry(coordinates);
  }
}
