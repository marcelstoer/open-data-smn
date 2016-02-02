package com.frightanic.smn.api;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests SmnData.
 */
public class SmnDataTest {
  /**
   * See method name.
   */
  @Test
  public void shouldSkipTheFirstThreeRows() {
    // given
    String rawData = "MeteoSchweiz / MeteoSuisse / MeteoSvizzera / MeteoSwiss\n" +
      " \n" +
      "stn|time|tre200s0|sre000z0|rre150z0|dkl010z0|fu3010z0|pp0qnhs0|fu3010z1|ure200s0|prestas0|pp0qffs0\n" +
      "TAE|201407192150|18.3|0|0.0|143|2.2|1012.3|3.6|88|949.2|1010.4";
    // when
    SmnData data = new SmnData(rawData);
    // then
    assertThat(data.getAllRecords().size(), is(1));
    assertThat(data.getRecordFor("TAE").getCode(), is("TAE"));
  }

  /**
   * See method name.
   */
  @Test
  @SneakyThrows(IOException.class)
  public void shouldParseSampleInput() {
    // given
    try (InputStream inputStream = getClass().getResourceAsStream("/VQHA69.csv")) {
      // when
      SmnData data = new SmnData(IOUtils.toString(inputStream, "UTF-8"));
      // then
      assertThat(data.getAllRecords().size(), is(113));
      assertThat(data.getRecordFor("TAE").getCode(), is("TAE")); // first
      assertThat(data.getRecordFor("THU").getCode(), is("THU")); // last
    }
  }
}
