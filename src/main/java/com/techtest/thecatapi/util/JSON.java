package com.techtest.thecatapi.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON {

  public static <T> T parseJSONStringToT(String JSONString, Class<? extends T> cls) {
    ObjectMapper mapper = new ObjectMapper();

    try {
      return mapper.convertValue(mapper.readValue(JSONString, cls), cls);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

}
