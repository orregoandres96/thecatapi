package com.techtest.thecatapi.infrastructure.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BreedsControllerTest {

  private final static String BASE_URL = "/api/v1/breeds";

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void controllers_getAllBreeds200() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }

  @Test
  public void controllers_getBreedById200() throws Exception {
    String apiUrl = BASE_URL;
    mockMvc.perform(
        MockMvcRequestBuilders.get(apiUrl).param(apiUrl, "abys").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }

  @Test
  public void controllers_getBreedBySearch200() throws Exception {
    String apiUrl = BASE_URL + "/search";
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("q", "air");
    params.add("attach_image", "1");

    mockMvc.perform(MockMvcRequestBuilders.get(apiUrl).contentType(MediaType.APPLICATION_JSON).queryParams(params))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }

}
