package com.techtest.thecatapi.application.usecases;

import java.util.List;
import java.util.Optional;

import com.techtest.thecatapi.domain.models.Breed;
import com.techtest.thecatapi.domain.ports.in.IRetrieveBreedUseCase;
import com.techtest.thecatapi.domain.ports.out.ITheCatAPIServicePort;

public class RetrieveBreedUseCase implements IRetrieveBreedUseCase {

  private ITheCatAPIServicePort theCatAPIServicePort;

  public RetrieveBreedUseCase(ITheCatAPIServicePort theCatAPIServicePort) {
    this.theCatAPIServicePort = theCatAPIServicePort;
  }

  @Override
  public List<Breed> getAllBreeds(Long limit, Long page) {
    return theCatAPIServicePort.getAllBreeds(limit, page);
  }

  @Override
  public Optional<Breed> getBreedById(String id) {
    return theCatAPIServicePort.getBreedById(id);
  }

  @Override
  public List<Breed> getBreedBySearch(String query, Long attachImage) {
    return theCatAPIServicePort.getBreedBySearch(query, attachImage);
  }

}
