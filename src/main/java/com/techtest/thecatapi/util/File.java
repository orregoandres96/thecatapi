package com.techtest.thecatapi.util;

import java.nio.file.Files;
import java.nio.file.Paths;

public class File {

  public static String readAsString(String pathName) {
    try {
      return new String(Files.readAllBytes(Paths.get(pathName)));
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

}
