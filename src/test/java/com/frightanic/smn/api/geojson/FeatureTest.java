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
    smnRecord = new SmnRecord("TAE|201411112240|6.1|0|0.0|231|3.2|1003.5|7.6|96|940.9|1004.4");
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