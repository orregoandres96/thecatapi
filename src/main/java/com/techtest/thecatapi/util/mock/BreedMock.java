package com.techtest.thecatapi.util.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techtest.thecatapi.domain.models.Breed;
import com.techtest.thecatapi.util.File;
import com.techtest.thecatapi.util.JSON;

public class BreedMock {

  public static List<Breed> getAllBreeds() {
    return loadBreeds();
  }

  public static Optional<Breed> getBreedById(String breedId) {
    List<Breed> breeds = getAllBreeds();
    Breed breed = breeds.stream().filter(v -> breedId.equals(v.getId())).findAny().orElse(null);

    if (breed != null) {
      return Optional.of(breed);
    }

    return Optional.empty();
  }

  public static List<Breed> getBreedBySearch(String query, Long attachImage) {
    List<Breed> breeds = getAllBreeds();
    List<Breed> matchs = breeds.stream().filter(v -> v.getName().contains(query)).toList();

    if (matchs != null) {
      return matchs;
    }

    return null;
  }

  private static List<Breed> loadBreeds() {
    String pathBreeds = "src/main/java/com/techtest/thecatapi/util/mock/data/breeds.json";
    String content = File.readAsString(pathBreeds);

    @SuppressWarnings("unchecked")
    List<Breed> breeds = JSON.parseJSONStringToT(content, new ArrayList<Breed>().getClass());

    ObjectMapper mapper = new ObjectMapper();
    return mapper.convertValue(breeds, new TypeReference<List<Breed>>() {
    });
  }

}