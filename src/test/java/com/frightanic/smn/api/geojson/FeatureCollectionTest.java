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
    smnRecord = new SmnRecord("TAE|201411112240|6.1|0|0.0|231|3.2|1003.5|7.6|96|940.9|1004.4");
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