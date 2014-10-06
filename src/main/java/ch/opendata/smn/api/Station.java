package ch.opendata.smn.api;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * Representation of an SMN observation station.
 */
@Getter
@ApiModel(value = "SMN station meta data")
public class Station {
  @ApiModelProperty(value = "3-char all upper-case station code")
  private final String code;
  @ApiModelProperty(value = "Original name in local language")
  private final String name;
  @ApiModelProperty(value = "CH1903 (Swiss grid) y-axis value")
  private final int ch1903Y;
  @ApiModelProperty(value = "CH1903 (Swiss grid) x-axis value")
  private final int ch1903X;
  @ApiModelProperty(value = "WGS84 latitude")
  private final double lat;
  @ApiModelProperty(value = "WGS84 longitude")
  private final double lng;

  public Station(String code, String name, int ch1903Y, int ch1903X, double lat, double lng) {
    this.code = code;
    this.name = name;
    this.ch1903Y = ch1903Y;
    this.ch1903X = ch1903X;
    this.lat = lat;
    this.lng = lng;
  }
}
