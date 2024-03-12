package com.techtest.thecatapi.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.techtest.thecatapi.application.services.BreedService;
import com.techtest.thecatapi.application.usecases.RetrieveBreedUseCase;
import com.techtest.thecatapi.domain.ports.in.IRetrieveBreedUseCase;
import com.techtest.thecatapi.domain.ports.out.ITheCatAPIServicePort;
import com.techtest.thecatapi.infrastructure.adapters.TheCatAPIServiceAdapter;

@Configuration
public class ApplicationConfig {

  @Bean
  public BreedService breedService(IRetrieveBreedUseCase retrieveBreedUseCase) {
    return new BreedService(retrieveBreedUseCase);
  }

  @Bean
  public IRetrieveBreedUseCase retrieveBreedUseCase(ITheCatAPIServicePort theCatAPIServicePort) {
    return new RetrieveBreedUseCase(theCatAPIServicePort);
  }

  @Bean
  public ITheCatAPIServicePort theCatAPIServicePort() {
    return new TheCatAPIServiceAdapter();
  }

}
