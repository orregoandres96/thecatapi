package com.techtest.thecatapi.domain.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {

  private final String id;
  private final float width;
  private final float height;
  private final String url;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public Image(@JsonProperty("id") String id,
      @JsonProperty("width") float width,
      @JsonProperty("height") float height,
      @JsonProperty("url") String url) {
    this.id = id;
    this.width = width;
    this.height = height;
    this.url = url;
  }

  // Getter Methods
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("width")
  public float getWidth() {
    return width;
  }

  @JsonProperty("height")
  public float getHeight() {
    return height;
  }

  @JsonProperty("url")
  public String getUrl() {
    return url;
  }

}
