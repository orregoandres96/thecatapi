package com.techtest.thecatapi.infrastructure.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techtest.thecatapi.application.services.BreedService;
import com.techtest.thecatapi.domain.models.Breed;

@RestController
@RequestMapping("/api/v1/breeds")
public class BreedsController {

  private final BreedService breedService;

  public BreedsController(BreedService breedService) {
    this.breedService = breedService;
  }

  @GetMapping
  public ResponseEntity<List<Breed>> getAllBreeds() {
    List<Breed> breeds = breedService.getAllBreeds();
    return new ResponseEntity<>(breeds, HttpStatus.OK);
  }

  @GetMapping("/{breedId}")
  public ResponseEntity<Breed> getBreedById(@PathVariable String breedId) {
    return breedService.getBreedById(breedId)
        .map(breed -> new ResponseEntity<>(breed, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/search")
  public ResponseEntity<List<Breed>> getBreedBySearch(@RequestParam(required = false) String q,
      @RequestParam(required = false) Long attach_image) {
    List<Breed> breeds = breedService.getBreedBySearch(q, attach_image);
    return new ResponseEntity<>(breeds, HttpStatus.OK);
  }

}
