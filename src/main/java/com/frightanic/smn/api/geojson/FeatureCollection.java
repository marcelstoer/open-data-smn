package com.frightanic.smn.api.geojson;

import com.frightanic.smn.api.SmnRecord;
import com.wordnik.swagger.annotations.ApiModel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Represents a the entire data set in GeoJSON format.
 */
@Getter
@ApiModel(value = "A GeoJSON feature collection")
public final class FeatureCollection {
  private final String type = "FeatureCollection";
  private final List<Feature> features;
  private final Crs crs;

  public FeatureCollection(CrsType crs, Collection<SmnRecord> smnRecords) {
    this.crs = new Crs(crs);
    features = new ArrayList<>(smnRecords.size());
    populateFeatures(crs, smnRecords);
  }

  private void populateFeatures(CrsType crs, Collection<SmnRecord> smnRecords) {
    for (SmnRecord smnRecord : smnRecords) {
      features.add(new Feature(crs, smnRecord));
    }
  }
}
