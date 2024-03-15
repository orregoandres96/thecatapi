package com.techtest.thecatapi.application.usescases;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.techtest.thecatapi.infrastructure.adapters.TheCatAPIServiceAdapter;

@SpringBootTest
@AutoConfigureMockMvc
public class RetrieveBreedUseCaseTest {

  @Mock
  private RestTemplate restTemplate;

  @InjectMocks
  private TheCatAPIServiceAdapter theCatAPIServiceAdapter = new TheCatAPIServiceAdapter();

  @Test
  public void usecases_getAllBreedsOk() {
  }
}
