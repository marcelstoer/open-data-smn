package com.frightanic.smn.health;

import com.frightanic.smn.core.GeoAdmin;
import com.codahale.metrics.health.HealthCheck;

import java.io.IOException;

public class SmnHealthCheck extends HealthCheck {
  private final GeoAdmin geoAdmin;

  public SmnHealthCheck(GeoAdmin geoAdmin) {
    this.geoAdmin = geoAdmin;
  }

  @Override
  protected Result check() throws IOException {
    if (geoAdmin.getSmnData().getAllRecords().size() > 0) {
      return Result.healthy();
    } else {
      return Result.unhealthy("No SMN data available.");
    }
  }
}
