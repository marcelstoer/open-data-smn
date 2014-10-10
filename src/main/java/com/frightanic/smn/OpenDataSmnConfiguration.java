package com.frightanic.smn;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
public class OpenDataSmnConfiguration extends Configuration {
  @NotEmpty
  @JsonProperty("data.url")
  private String dataUrl;

  @NotEmpty
  @JsonProperty("data.fileName")
  private String dataFileName;

  @NotEmpty
  @JsonProperty("data.cacheTimeToLiveMinutes")
  private String dataCacheTimeToLiveMinutes;

  @NotEmpty
  @JsonProperty("responseCacheTimeToLiveMinutes")
  private String responseCacheTimeToLiveMinutes;

  @JsonProperty("swaggerPort")
  private String swaggerPort;

  public Short getDataCacheTimeToLiveMinutes() {
    return Short.valueOf(dataCacheTimeToLiveMinutes);
  }

  public Short getResponseCacheTimeToLiveMinutes() {
    return Short.valueOf(responseCacheTimeToLiveMinutes);
  }
}