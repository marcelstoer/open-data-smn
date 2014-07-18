package ch.opendata.smn.view;

import io.dropwizard.views.View;

public class IndexView extends View {
  public IndexView() {
    super("index.mustache");
//    super("index.ftl");
  }

  public String getTitle() {
    return "OpenData.ch | SwissMetNet SMN";
  }
}
