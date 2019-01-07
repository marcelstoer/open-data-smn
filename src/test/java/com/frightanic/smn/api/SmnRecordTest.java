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
    String rawData = "HOE;201901061500;-1.9;0.0;0;31;96;-2.4;271;15.1;24.1;898.5;-;1029.2;1573.2;-;-;-;-;-;-;-";
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
    String rawData = "HOE;201901061500;-1.9;0.0;0;31;96;-2.4;271;15.1;24.1;898.5;-;1029.2;1573.2;-;-;-;-;-;-;-";
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
    String rawData = "FOO;201901061500;-1.9;0.0;0;31;96;-2.4;271;15.1;24.1;898.5;-;1029.2;1573.2;-;-;-;-;-;-;-";
    // when
    SmnRecord record = new SmnRecord(rawData);
    // then
    assertThat(record.getStation(), is(nullValue()));
  }
}
