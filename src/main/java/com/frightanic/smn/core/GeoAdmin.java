package com.frightanic.smn.core;

import com.frightanic.smn.OpenDataSmnConfiguration;
import com.frightanic.smn.api.SmnData;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GeoAdmin {
  private static final String SMN_DATA_CACHE_KEY = "smn";

  private final Logger logger = LoggerFactory.getLogger(GeoAdmin.class);

  private final DataLoader dataLoader;
  private final LoadingCache<String, SmnData> cache;

  private SmnData lastLoadedSmnData;

  public GeoAdmin(OpenDataSmnConfiguration configuration) {
    dataLoader = new DataLoader(configuration.getDataUrl(), configuration.getDataFileName());
    cache = CacheBuilder.newBuilder().
      expireAfterWrite(configuration.getDataCacheTimeToLiveMinutes(), TimeUnit.MINUTES).
      build(new SmnDataCacheLoader());
  }

  public SmnData getSmnData() throws IOException {
    try {
      return cache.get(SMN_DATA_CACHE_KEY);
    } catch (ExecutionException e) {
      if (lastLoadedSmnData == null) {
        throw new IOException(e.getCause());
      } else {
        logger.warn(
          "Loading data via the cache's data loader failed (cache was empty). Returning last available data" + " set.");
        return lastLoadedSmnData;
      }
    }
  }

  private class SmnDataCacheLoader extends CacheLoader<String, SmnData> {
    public SmnData load(String key) throws IOException {
      SmnData smnData = dataLoader.loadSmnData();
      if (smnData != null) {
        logger.info("Loaded SMN data from geo.admin portal. Keeping an internal copy");
        lastLoadedSmnData = smnData;
      }
      return smnData;
    }
  }
}