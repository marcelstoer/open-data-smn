package com.frightanic.smn.api.geojson;

import com.frightanic.smn.api.SmnRecord;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests Feature.
 */
public class FeatureTest {

  private SmnRecord smnRecord;

  /**
   * Setup.
   */
  @Before
  public void setup() {
    smnRecord = new SmnRecord("TAE;201901061500;1.9;0.0;0;53;90;0.4;228;5.4;10.4;967.7;1034.1;1031.8;-;-;-;-;-;-;-;-");
  }

  /**
   * See method name.
   */
  @Test
  public void shouldHaveTypeMemberWithValueFeature() {
    // given
    Feature feature = new Feature(CrsType.CH1903, smnRecord);
    // when
    // then
    assertThat(feature.getType(), is("Feature"));
  }

  /**
   * See method name.
   */
  @Test
  public void shouldUseSmnRecordForPropertiesMember() {
    // given
    Feature feature = new Feature(CrsType.CH1903, smnRecord);
    // when
    // then
    assertThat(feature.getProperties(), is(smnRecord));
  }

  /**
   * See method name.
   */
  @Test
  public void shouldUseCh1903CoordinatesIfCrsTypeIsCh1903() {
    // given
    Feature feature = new Feature(CrsType.CH1903, smnRecord);
    // when
    final Geometry geometry = feature.getGeometry();
    // then
    assertThat(geometry.getCoordinates()[0], Is.<Number>is(smnRecord.getStation().getCh1903X()));
    assertThat(geometry.getCoordinates()[1], Is.<Number>is(smnRecord.getStation().getCh1903Y()));
  }

  /**
   * See method name.
   */
  @Test
  public void shouldUseWgs84CoordinatesIfCrsTypeIsWgs84() {
    // given
    Feature feature = new Feature(CrsType.WGS84, smnRecord);
    // when
    final Geometry geometry = feature.getGeometry();
    // then
    assertThat(geometry.getCoordinates()[0], Is.<Number>is(smnRecord.getStation().getLng()));
    assertThat(geometry.getCoordinates()[1], Is.<Number>is(smnRecord.getStation().getLat()));
  }
}