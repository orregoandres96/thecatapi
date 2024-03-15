package com.techtest.thecatapi.domain.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Weight {

  private final String imperial;
  private final String metric;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public Weight(@JsonProperty("imperial") String imperial,
      @JsonProperty("metric") String metric) {
    this.imperial = imperial;
    this.metric = metric;
  }

  // Getter Methods
  @JsonProperty("imperial")
  public String getImperial() {
    return imperial;
  }

  @JsonProperty("metric")
  public String getMetric() {
    return metric;
  }

}
