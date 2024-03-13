package com.techtest.thecatapi.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.techtest.thecatapi.domain.models.Breed;

public interface IRetrieveBreedUseCase {

  List<Breed> getAllBreeds(Long limit, Long page);

  Optional<Breed> getBreedById(String id);

  List<Breed> getBreedBySearch(String query, Long attachImage);

}
