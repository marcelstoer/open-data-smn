package com.frightanic.smn;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Tests StationMap.
 */
public class StationMapTest {

  /**
   * See method name.
   */
  @Test
  public void shouldReturnNullForUnknownCode() {
    // given
    // when
    // then
    assertThat(StationMap.get("fooBar4711"), is(nullValue()));
  }

  /**
   * See method name.
   */
  @Test
  public void shouldReturnNullForLowerCaseCodes() {
    // given
    // when
    // then
    assertThat(StationMap.get("hoe"), is(nullValue()));
  }

  /**
   * See method name.
   */
  @Test
  public void shouldReturnStationForValidUpperCaseCode() {
    // given
    // when
    // then
    assertThat(StationMap.get("HOE").getCode(), is("HOE"));
  }
}
