package com.frightanic.smn.api.geojson;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Coordinate reference system (CRS) of a GeoJSON object
 */
@Getter
public final class Crs {
  private final String type = "name";
  private final Map<String, String> properties = new HashMap<>(1);

  public Crs(CrsType crs) {
    properties.put("name", crs.getUrn());
  }
}
