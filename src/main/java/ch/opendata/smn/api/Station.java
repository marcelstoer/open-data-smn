package ch.opendata.smn.api;

import lombok.Getter;

/**
 * Representation of an SMN observation station.
 */
@Getter
public class Station {
  private final String code;
  private final String name;
  private final int lv93Y;
  private final int lv93X;
  private final double lat;
  private final double lng;

  public Station(String code, String name, int lv93Y, int lv93X, double lat, double lng) {
    this.code = code;
    this.name = name;
    this.lv93Y = lv93Y;
    this.lv93X = lv93X;
    this.lat = lat;
    this.lng = lng;
  }
}
