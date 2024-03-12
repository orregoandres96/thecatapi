package com.techtest.thecatapi.application.services;

import java.util.List;
import java.util.Optional;

import com.techtest.thecatapi.domain.models.Breed;
import com.techtest.thecatapi.domain.ports.in.IRetrieveBreedUseCase;

public class BreedService implements IRetrieveBreedUseCase {

  private final IRetrieveBreedUseCase retrieveBreedUseCase;

  public BreedService(IRetrieveBreedUseCase retrieveBreedUseCase) {
    this.retrieveBreedUseCase = retrieveBreedUseCase;
  }

  @Override
  public List<Breed> getAllBreeds() {
    return retrieveBreedUseCase.getAllBreeds();
  }

  @Override
  public Optional<Breed> getBreedById(String id) {
    return retrieveBreedUseCase.getBreedById(id);
  }

  @Override
  public List<Breed> getBreedBySearch(String query, Long attachImage) {
    return retrieveBreedUseCase.getBreedBySearch(query, attachImage);
  }

}
