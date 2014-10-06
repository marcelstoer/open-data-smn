package com.frightanic.smn.api;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Tests SmnRecord.
 */
public class SmnRecordTest {
  /**
   * See method name.
   */
  @Test
  public void shouldDetectStation() {
    // given
    String rawData = "HOE|201407192150|23.8|0|0.0|138|16.2|1016.3|24.5|36|887.0|-";
    // when
    SmnRecord record = new SmnRecord(rawData);
    // then
    assertThat(record.getStation().getCode(), is(record.getCode()));
    assertThat(record.getStation().getCode(), is("HOE"));
  }

  /**
   * See method name.
   */
  @Test
  public void shouldReplaceDashWithNull() {
    // given
    String rawData = "HOE|201407192150|23.8|0|0.0|138|16.2|1016.3|24.5|36|887.0|-";
    // when
    SmnRecord record = new SmnRecord(rawData);
    // then
    assertThat(record.getQffPressure(), is(nullValue()));
  }
  /**
   * See method name.
   */
  @Test
  public void shouldMapStationToNullIfUnknown() {
    // given
    String rawData = "FOO|201407192150|23.8|0|0.0|138|16.2|1016.3|24.5|36|887.0|-";
    // when
    SmnRecord record = new SmnRecord(rawData);
    // then
    assertThat(record.getStation(), is(nullValue()));
  }
}
