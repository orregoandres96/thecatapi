package com.techtest.thecatapi.application.usescases;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.techtest.thecatapi.application.usecases.RetrieveBreedUseCase;
import com.techtest.thecatapi.domain.models.Breed;
import com.techtest.thecatapi.infrastructure.adapters.TheCatAPIServiceAdapter;

@SpringBootTest
@AutoConfigureMockMvc
public class RetrieveBreedUseCaseTest {

  @Autowired
  private RetrieveBreedUseCase retrieveBreedUseCase;

  @Mock
  private RestTemplate restTemplate;

  @InjectMocks
  private TheCatAPIServiceAdapter theCatAPIServiceAdapter = new TheCatAPIServiceAdapter();

  @Test
  public void usecases_getAllBreedsOk() {
    ResponseEntity<Breed[]> breedsEntity = new ResponseEntity<Breed[]>(HttpStatus.ACCEPTED);
    Mockito.when(restTemplate.exchange(
        ArgumentMatchers.anyString(),
        ArgumentMatchers.any(HttpMethod.class),
        ArgumentMatchers.<HttpEntity<String>>any(),
        ArgumentMatchers.<Class<Breed[]>>any())).thenReturn(breedsEntity);

    List<Breed> breeds = retrieveBreedUseCase.getAllBreeds(null, null);
    System.out.println(breeds);

    assertNotNull(breeds);
  }
}
