package com.frightanic.smn.api.geojson;

import lombok.Getter;

/**
 * Supported CRS types.
 */
@Getter
public enum CrsType {

  CH1903("urn:ogc:def:crs:EPSG::21781"), WGS84("urn:ogc:def:crs:EPSG::4326");

  // OGC CRS URN
  private String urn;

  private CrsType(String urn) {
    this.urn = urn;
  }
}
