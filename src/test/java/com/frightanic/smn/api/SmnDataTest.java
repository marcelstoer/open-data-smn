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
      "stn;time;tre200s0;rre150z0;sre000z0;gre000z0;ure200s0;tde200s0;dkl010z0;fu3010z0;fu3010z1;prestas0;pp0qffs0;pp0qnhs0;ppz850s0;ppz700s0;dv1towz0;fu3towz0;fu3towz1;ta1tows0;uretows0;tdetows0\n" +
      "TAE;201901061500;1.9;0.0;0;53;90;0.4;228;5.4;10.4;967.7;1034.1;1031.8;-;-;-;-;-;-;-;-";
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
    try (InputStream inputStream = getClass().getResourceAsStream("/VQHA80.csv")) {
      // when
      SmnData data = new SmnData(IOUtils.toString(inputStream, "UTF-8"));
      // then
      assertThat(data.getAllRecords().size(), is(159));
      assertThat(data.getRecordFor("TAE").getCode(), is("TAE")); // first
      assertThat(data.getRecordFor("KLO").getCode(), is("KLO")); // last
    }
  }
}
