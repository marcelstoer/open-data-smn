package com.frightanic.smn.api.geojson;

import com.frightanic.smn.api.SmnRecord;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests FeatureCollection.
 */
public class FeatureCollectionTest {
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
  public void shouldHaveTypeMemberWithValueFeatureCollection() {
    // given
    FeatureCollection featureCollection = new FeatureCollection(CrsType.CH1903, Lists.newArrayList(smnRecord));
    // when
    // then
    assertThat(featureCollection.getType(), is("FeatureCollection"));
  }

  /**
   * See method name.
   */
  @Test
  public void shouldAddSmnRecordsAsFeatures() {
    // given
    FeatureCollection featureCollection = new FeatureCollection(CrsType.CH1903, Lists.newArrayList(smnRecord,
      smnRecord));
    // when
    // then
    assertThat(featureCollection.getFeatures().size(), is(2));
  }
}