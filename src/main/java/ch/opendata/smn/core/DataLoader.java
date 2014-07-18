package ch.opendata.smn.core;

import ch.opendata.smn.api.SmnData;
import lombok.SneakyThrows;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DataLoader {
  private final URL smnDataUrl;
  private final String smnDataFileName;

  @SneakyThrows(MalformedURLException.class)
  public DataLoader(String smnDataUrl, String smnDataFileName) {
    this.smnDataUrl = new URL(smnDataUrl);
    this.smnDataFileName = smnDataFileName;
  }

  public SmnData loadSmnData() throws IOException {
    SmnData smnData = null;
    try (InputStream inputStream = new BufferedInputStream(smnDataUrl.openStream(), 1024);
         ZipArchiveInputStream zip = new ZipArchiveInputStream(inputStream)) {
      ZipArchiveEntry entry = zip.getNextZipEntry();
      while (smnData == null && entry != null) {
        if (smnDataFileName.equals(entry.getName())) {
          smnData = new SmnData(extractSmnTextFrom(zip));
        }
        entry = zip.getNextZipEntry();
      }
      if (smnData == null){
        throw new FileNotFoundException("The expected file '" + smnDataFileName + "' not present in the downloaded " +
          "ZIP file.");
      }
    }
    return smnData;
  }

  private String extractSmnTextFrom(ZipArchiveInputStream zip) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    IOUtils.copy(zip, baos);
    baos.close();
    return baos.toString("UTF-8");
  }
}
