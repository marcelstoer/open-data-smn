package com.frightanic.smn.view;

import io.dropwizard.views.View;

public class IndexView extends View {
  public IndexView() {
    super("index.ftl");
  }

  public String getTitle() {
    return "OpenData SMN - SwissMetNet SMN for OpenData.ch";
  }
}
