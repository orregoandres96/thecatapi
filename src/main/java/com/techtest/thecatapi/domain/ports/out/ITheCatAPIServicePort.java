package com.techtest.thecatapi.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.techtest.thecatapi.domain.models.Breed;

public interface ITheCatAPIServicePort {

  List<Breed> getAllBreeds(Long limit, Long page);

  Optional<Breed> getBreedById(String id);

  List<Breed> getBreedBySearch(String query, Long attachImage);

}
