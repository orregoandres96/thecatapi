package com.techtest.thecatapi.domain.models;

public class Weight {

  private final String imperial;
  private final String metric;

  public Weight(String imperial, String metric) {
    this.imperial = imperial;
    this.metric = metric;
  }

  // Getter Methods

  public String getImperial() {
    return imperial;
  }

  public String getMetric() {
    return metric;
  }

}
