package com.frightanic.smn.api.geojson;

import lombok.Getter;

/**
 * Each feature has a 'Point' geometry with coordinates based on the selected CRS.
 */
@Getter
public final class Geometry {
  private final String type = "Point";
  private final Number[] coordinates;

  public Geometry(Number[] coordinates) {
    this.coordinates = coordinates;
  }
}
