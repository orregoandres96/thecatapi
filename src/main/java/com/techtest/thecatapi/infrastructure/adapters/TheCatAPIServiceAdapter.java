package com.techtest.thecatapi.infrastructure.adapters;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.techtest.thecatapi.domain.models.Breed;
import com.techtest.thecatapi.domain.ports.out.ITheCatAPIServicePort;
import com.techtest.thecatapi.util.QueryString;

public class TheCatAPIServiceAdapter implements ITheCatAPIServicePort {

  private final RestTemplate restTemplate;

  public TheCatAPIServiceAdapter() {
    this.restTemplate = new RestTemplate();
  }

  @Override
  public List<Breed> getAllBreeds(Long limit, Long page) {
    QueryString qs = new QueryString();

    if (limit != null) {
      qs.add("limit", Long.toString(limit));
    }

    if (page != null) {
      qs.add("page", Long.toString(page));
    }

    return getTheCatAPI(null, qs.toString());
  }

  @Override
  public Optional<Breed> getBreedById(String id) {
    return getTheCatAPI(id);
  }

  @Override
  public List<Breed> getBreedBySearch(String query, Long attachImage) {
    QueryString qs = new QueryString();

    if (query != null) {
      qs.add("q", query);
    }

    if (attachImage != null) {
      qs.add("attach_image", Long.toString(attachImage));
    }

    return getTheCatAPI("search", qs.toString());
  }

  private List<Breed> getTheCatAPI(String path, String queryString) {
    ResponseEntity<Breed[]> breedsResponse = restTemplate.exchange(getApiUrl(path, queryString), HttpMethod.GET,
        getHttpEntity(),
        Breed[].class);
    Breed[] breedsObject = breedsResponse.getBody();

    return Arrays.asList(breedsObject);
  }

  private Optional<Breed> getTheCatAPI(String id) {
    ResponseEntity<Breed> breedResponse = restTemplate.exchange(getApiUrl(id), HttpMethod.GET, getHttpEntity(),
        Breed.class);
    Optional<Breed> breed = Optional.of(breedResponse.getBody());

    return breed;
  }

  private HttpEntity<String> getHttpEntity() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("x-api-key", "live_JBT0Ah0Nt12iyl2IpjQVLDWjcLk0GQwf4zI9wBMfmfejKmcC31mOJp4yJz5TsOUP");

    HttpEntity<String> entity = new HttpEntity<String>(headers);

    return entity;
  }

  private String getApiUrl(String path, String... queryString) {
    String apiUrl = "https://api.thecatapi.com/v1/breeds";
    if (path != null) {
      apiUrl += "/" + path;
    }
    if (queryString != null) {
      apiUrl += "?" + queryString[0];
    }

    System.out.println(apiUrl);
    System.out.println(queryString);

    return apiUrl;
  }

}
