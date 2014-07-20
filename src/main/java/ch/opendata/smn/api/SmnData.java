package ch.opendata.smn.api;

import com.google.common.base.Splitter;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the entire data set for a point in time.
 */
public class SmnData {
  private final Map<String, SmnRecord> smnRecords;

  public SmnData(String sourceData) {
    List<String> records = Splitter.on("\n").trimResults().omitEmptyStrings().splitToList(sourceData);
    smnRecords = new HashMap<>(records.size() - 2);
    // omit first three lines (the empty one was alreay removed be the Splitter, omitEmptyStrings)
    /*
     * MeteoSchweiz / MeteoSuisse / MeteoSvizzera / MeteoSwiss
     *
     * stn|time|tre200s0|sre000z0|rre150z0|dkl010z0|fu3010z0|pp0qnhs0|fu3010z1|ure200s0|prestas0|pp0qffs0
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
