package ch.opendata.smn.api;

import com.google.common.base.Splitter;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmnData {
  private final Map<String, SmnRecord> smnRecords;

  public SmnData(String sourceData) {
    List<String> records = Splitter.on("\n").trimResults().omitEmptyStrings().splitToList(sourceData);
    smnRecords = new HashMap<>(records.size() - 2);
    // omit first two lines
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
