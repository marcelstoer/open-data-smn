package com.frightanic.smn.api;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Representation of an SMN observation station.
 */
@Getter
@AllArgsConstructor
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
  @ApiModelProperty(value = "meters above sea level")
  private final int elevation;
}
