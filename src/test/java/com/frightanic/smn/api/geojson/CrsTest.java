package com.frightanic.smn.api.geojson;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests Crs.
 */
public class CrsTest {

  /**
   * See method name.
   */
  @Test
  public void shouldHaveTypeMemberWithValueName() {
    // given
    Crs crs = new Crs(CrsType.CH1903);
    // when
    // then
    assertThat(crs.getType(), is("name"));
  }

  /**
   * See method name.
   */
  @Test
  public void shouldPlaceCrsTypeUrnInPropertyWithKeyName() {
    // given
    Crs crs = new Crs(CrsType.CH1903);
    // when
    // then
    assertThat(crs.getProperties().get("name"), is(CrsType.CH1903.getUrn()));
  }
}