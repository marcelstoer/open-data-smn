package com.frightanic.smn.core;

import com.frightanic.smn.api.SmnData;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DataLoader {
  private final URL smnDataUrl;

  @SneakyThrows(MalformedURLException.class)
  public DataLoader(String smnDataUrl) {
    this.smnDataUrl = new URL(smnDataUrl);
  }

  public SmnData loadSmnData() throws IOException {
    try (InputStream inputStream = new BufferedInputStream(smnDataUrl.openStream(), 1024)) {
      return new SmnData(IOUtils.toString(inputStream, "UTF-8"));
    }
  }
}
