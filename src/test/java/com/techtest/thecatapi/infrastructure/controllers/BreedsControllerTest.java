package com.techtest.thecatapi.infrastructure.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hamcrest.Matchers;

import com.techtest.thecatapi.application.services.BreedService;
import com.techtest.thecatapi.domain.models.Breed;
import com.techtest.thecatapi.util.mock.BreedMock;

@WebMvcTest(BreedsController.class)
public class BreedsControllerTest {

  private final static String BASE_URL = "/api/v1/breeds";

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private BreedService breedService;

  @Test
  public void test_controller_breeds_ok() throws Exception {
    List<Breed> breedMock = BreedMock.getAllBreeds();

    when(breedService.getAllBreeds(any(), any()))
        .thenReturn(breedMock);

    mockMvc.perform(get(BASE_URL).contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value("abys"))
        .andExpect(jsonPath("$[0].name").value("Abyssinian"))
        .andExpect(jsonPath("$[0].reference_image_id").value("0XYvRd7oD"));

    verify(breedService).getAllBreeds(null, null);
  }

  @Test
  public void test_controller_breeds_not_found() throws Exception {
    String apiUrl = BASE_URL + "x";
    String messageExceptionExpected = "No static resource " + apiUrl.substring(1) + ".";

    mockMvc.perform(get(apiUrl).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound())
        .andExpect(result -> assertTrue(result.getResolvedException() instanceof NoResourceFoundException))
        .andExpect(result -> assertEquals(messageExceptionExpected, result.getResolvedException().getMessage()));
  }

  @Test
  public void test_controller_breed_by_id_ok() throws Exception {
    String breedId = "abys";
    String apiUrl = BASE_URL + "/" + breedId;
    Optional<Breed> breedMock = BreedMock.getBreedById(breedId);

    when(breedService.getBreedById(any()))
        .thenReturn(breedMock);

    mockMvc.perform(get(apiUrl).contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value("abys"))
        .andExpect(jsonPath("$.name").value("Abyssinian"))
        .andExpect(jsonPath("$.reference_image_id").value("0XYvRd7oD"));

    verify(breedService).getBreedById(breedId);
  }

  @Test
  public void test_controller_breed_by_id_not_found() throws Exception {
    String breedId = "notfound";
    String apiUrl = BASE_URL + "/" + breedId;
    Optional<Breed> breedMock = BreedMock.getBreedById(breedId);

    when(breedService.getBreedById(any()))
        .thenReturn(breedMock);

    mockMvc.perform(get(apiUrl).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$").doesNotExist());
  }

  @Test
  public void test_controller_breed_by_search_ok() throws Exception {
    String apiUrl = BASE_URL + "/search";
    Map<String, String> params = new HashMap<String, String>();
    params.put("q", "air");
    params.put("attach_image", "1");
    List<Breed> breedMock = BreedMock.getBreedBySearch(params.get("q"), Long.parseLong(params.get("attach_image")));

    when(breedService.getBreedBySearch(anyString(), anyLong()))
        .thenReturn(breedMock);

    mockMvc.perform(get(apiUrl).contentType(MediaType.APPLICATION_JSON)
        .param("q", params.get("q"))
        .param("attach_image", params.get("attach_image")))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name").value(Matchers.containsString(params.get("q"))));

    verify(breedService).getBreedBySearch(params.get("q"), Long.parseLong(params.get("attach_image")));
  }

  @Test
  public void test_controller_breed_by_search_bad_request() throws Exception {
    String apiUrl = BASE_URL + "/search";
    String messageExceptionExpected = "Required request parameter 'q' for method parameter type String is not present";
    Map<String, String> params = new HashMap<String, String>();
    params.put("attach_image", "1");

    mockMvc.perform(get(apiUrl).contentType(MediaType.APPLICATION_JSON)
        .param("attach_image", params.get("attach_image")))
        .andExpect(status().isBadRequest())
        .andExpect(
            result -> assertTrue(result.getResolvedException() instanceof MissingServletRequestParameterException))
        .andExpect(result -> assertEquals(messageExceptionExpected, result.getResolvedException().getMessage()));
  }

  @Test
  public void test_controller_breed_by_search_empty() throws Exception {
    String apiUrl = BASE_URL + "/search";
    Map<String, String> params = new HashMap<String, String>();
    params.put("q", "xairx");
    params.put("attach_image", "1");
    List<Breed> breedMock = BreedMock.getBreedBySearch(params.get("q"), Long.parseLong(params.get("attach_image")));

    when(breedService.getBreedBySearch(anyString(), anyLong()))
        .thenReturn(breedMock);

    mockMvc.perform(get(apiUrl).contentType(MediaType.APPLICATION_JSON)
        .param("q", params.get("q"))
        .param("attach_image", params.get("attach_image")))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0]").doesNotExist());

    verify(breedService).getBreedBySearch(params.get("q"), Long.parseLong(params.get("attach_image")));
  }

}
