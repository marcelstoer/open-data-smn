package com.frightanic.smn.api;

import com.frightanic.smn.StationMap;
import com.google.common.base.Splitter;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

/**
 * Represents a data set from an SMN observation station.
 */
@Getter
@ApiModel(value = "A single SMN data record")
public class SmnRecord {
  @Getter(AccessLevel.NONE)
  private final Splitter splitter = Splitter.on("|");
  @Getter(AccessLevel.NONE)
  private final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMddHHmm").withZoneUTC();

  private final Station station;
  @ApiModelProperty(value = "3-char all upper-case station code")
  private final String code;
  @ApiModelProperty(value = "Time in UTC")
  private final String dateTime;
  @ApiModelProperty(value = "Air temperature 2 m above ground; current value")
  private final String temperature;
  @ApiModelProperty(value = "Sunshine duration; ten minutes total")
  private final String sunshine;
  @ApiModelProperty(value = "Precipitation; ten minutes total")
  private final String precipitation;
  @ApiModelProperty(value = "Wind direction; ten minutes mean")
  private final String windDirection;
  @ApiModelProperty(value = "Wind speed; ten minutes mean")
  private final String windSpeed;
  @ApiModelProperty(value = "Pressure reduced to sea level according to standard atmosphere (QNH); current value")
  private final String qnhPressure;
  @ApiModelProperty(value = "Gust peak (one second); maximum")
  private final String gustPeak;
  @ApiModelProperty(value = "Relative air humidity 2 m above ground; current value")
  private final String humidity;
  @ApiModelProperty(value = "Pressure at station level (QFE); current value")
  private final String qfePressure;
  @ApiModelProperty(value = "Pressure reduced to sea level (QFF); current value")
  private final String qffPressure;

  public SmnRecord(String sourceDataRecord) {
    List<String> values = splitter.splitToList(sourceDataRecord);
    station = StationMap.get(values.get(0));
    code = values.get(0);
    dateTime = dateTimeFormatter.parseDateTime(values.get(1)).toString();
    temperature = replaceDashWithNull(values.get(2));
    sunshine = replaceDashWithNull(values.get(3));
    precipitation = replaceDashWithNull(values.get(4));
    windDirection = replaceDashWithNull(values.get(5));
    windSpeed = replaceDashWithNull(values.get(6));
    qnhPressure = replaceDashWithNull(values.get(7));
    gustPeak = replaceDashWithNull(values.get(8));
    humidity = replaceDashWithNull(values.get(9));
    qfePressure = replaceDashWithNull(values.get(10));
    qffPressure = replaceDashWithNull(values.get(11));
  }

  private String replaceDashWithNull(String s) {
    if ("-".equals(s)) {
      return null;
    } else {
      return s;
    }
  }
}
