package com.techtest.thecatapi.domain.models;

public class Image {

  private final String id;
  private final float width;
  private final float height;
  private final String url;

  public Image(String id, float width, float height, String url) {
    this.id = id;
    this.width = width;
    this.height = height;
    this.url = url;
  }

  // Getter Methods

  public String getId() {
    return id;
  }

  public float getWidth() {
    return width;
  }

  public float getHeight() {
    return height;
  }

  public String getUrl() {
    return url;
  }

}
