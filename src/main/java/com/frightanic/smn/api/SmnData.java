package com.frightanic.smn.api;

import com.google.common.base.Splitter;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the entire data set for a point in time.
 */
@ApiModel(value = "A container for SMN data records")
public class SmnData {
  private final Map<String, SmnRecord> smnRecords;

  public SmnData(String sourceData) {
    List<String> records = Splitter.on("\n").trimResults().omitEmptyStrings().splitToList(sourceData);
    smnRecords = new HashMap<>(records.size() - 2);
    // omit first three lines (the empty one was already removed be the Splitter, omitEmptyStrings)
    /*
     * MeteoSchweiz / MeteoSuisse / MeteoSvizzera / MeteoSwiss
     *
     * stn;time;tre200s0;rre150z0;sre000z0;gre000z0;ure200s0;tde200s0;dkl010z0;fu3010z0;fu3010z1;prestas0;pp0qffs0;pp0qnhs0;ppz850s0;ppz700s0;dv1towz0;fu3towz0;fu3towz1;ta1tows0;uretows0;tdetows0
     */
    for (int i = 2; i < records.size(); i++) {
      SmnRecord smnRecord = new SmnRecord(records.get(i));
      smnRecords.put(smnRecord.getCode(), smnRecord);
    }
  }

  public Collection<SmnRecord> getAllRecords() {
    return smnRecords.values();
  }

  public SmnRecord getRecordFor(String code) {
    return smnRecords.get(code);
  }
}
