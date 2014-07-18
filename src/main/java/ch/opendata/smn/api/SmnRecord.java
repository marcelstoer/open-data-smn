package ch.opendata.smn.api;

import com.google.common.base.Splitter;
import lombok.AccessLevel;
import lombok.Getter;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

@Getter
public class SmnRecord {
  @Getter(AccessLevel.NONE)
  private final Splitter splitter = Splitter.on("|");
  @Getter(AccessLevel.NONE)
  private final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMddkkmm").withZoneUTC();

  private final String code;
  private final String dateTime;
  private final String temperature;
  private final String sunshine;
  private final String precipitation;
  private final String windDirection;
  private final String windSpeed;
  private final String qnhPressure;
  private final String gustPeak;
  private final String humidity;
  private final String qfePressure;
  private final String qffPressure;

  public SmnRecord(String sourceDataRecord) {
    List<String> values = splitter.splitToList(sourceDataRecord);
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
