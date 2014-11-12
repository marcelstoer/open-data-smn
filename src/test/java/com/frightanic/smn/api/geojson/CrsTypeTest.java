package com.frightanic.smn.api.geojson;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests CrsType.
 */
public class CrsTypeTest {

  /**
   * See method name.
   */
  @Test
  public void shouldHaveOgnUrn4326ForWsg84() {
    // given
    // when
    // then
    assertThat(CrsType.WGS84.getUrn(), is("urn:ogc:def:crs:EPSG::4326"));
  }

  /**
   * See method name.
   */
  @Test
  public void shouldHaveOgnUrn21781ForCH1903() {
    // given
    // when
    // then
    assertThat(CrsType.CH1903.getUrn(), is("urn:ogc:def:crs:EPSG::21781"));
  }
}