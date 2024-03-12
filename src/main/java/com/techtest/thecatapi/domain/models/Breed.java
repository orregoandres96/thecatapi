package com.techtest.thecatapi.domain.models;

import java.util.Optional;

public class Breed {

  private final Weight weight;
  private final String id;
  private final String name;
  private final String cfa_url;
  private final String vetstreet_url;
  private final String vcahospitals_url;
  private final String temperament;
  private final String origin;
  private final String country_codes;
  private final String country_code;
  private final String description;
  private final String life_span;
  private final float indoor;
  private final float lap;
  private final String alt_names;
  private final float adaptability;
  private final float affection_level;
  private final float child_friendly;
  private final float dog_friendly;
  private final float energy_level;
  private final float grooming;
  private final float health_issues;
  private final float intelligence;
  private final float shedding_level;
  private final float social_needs;
  private final float stranger_friendly;
  private final float vocalisation;
  private final float experimental;
  private final float hairless;
  private final float natural;
  private final float rare;
  private final float rex;
  private final float suppressed_tail;
  private final float short_legs;
  private final String wikipedia_url;
  private final float hypoallergenic;
  private final String reference_image_id;
  private final Optional<Image> image;

  public Breed(Weight weight, String id, String name, String cfa_url, String vetstreet_url,
      String vcahospitals_url, String temperament, String origin, String country_codes, String country_code,
      String description, String life_span, float indoor, float lap, String alt_names, float adaptability,
      float affection_level, float child_friendly, float dog_friendly, float energy_level, float grooming,
      float health_issues, float intelligence, float shedding_level, float social_needs, float stranger_friendly,
      float vocalisation, float experimental, float hairless, float natural, float rare, float rex,
      float suppressed_tail, float short_legs, String wikipedia_url, float hypoallergenic, String reference_image_id,
      Image image) {
    this.weight = new Weight(weight.getImperial(), weight.getMetric());
    this.id = id;
    this.name = name;
    this.cfa_url = cfa_url;
    this.vetstreet_url = vetstreet_url;
    this.vcahospitals_url = vcahospitals_url;
    this.temperament = temperament;
    this.origin = origin;
    this.country_codes = country_codes;
    this.country_code = country_code;
    this.description = description;
    this.life_span = life_span;
    this.indoor = indoor;
    this.lap = lap;
    this.alt_names = alt_names;
    this.adaptability = adaptability;
    this.affection_level = affection_level;
    this.child_friendly = child_friendly;
    this.dog_friendly = dog_friendly;
    this.energy_level = energy_level;
    this.grooming = grooming;
    this.health_issues = health_issues;
    this.intelligence = intelligence;
    this.shedding_level = shedding_level;
    this.social_needs = social_needs;
    this.stranger_friendly = stranger_friendly;
    this.vocalisation = vocalisation;
    this.experimental = experimental;
    this.hairless = hairless;
    this.natural = natural;
    this.rare = rare;
    this.rex = rex;
    this.suppressed_tail = suppressed_tail;
    this.short_legs = short_legs;
    this.wikipedia_url = wikipedia_url;
    this.hypoallergenic = hypoallergenic;
    this.reference_image_id = reference_image_id;

    if (image != null) {
      Image ImageObject = new Image(image.getId(), image.getWidth(), image.getHeight(), image.getUrl());
      this.image = Optional.of(ImageObject);
    } else {
      this.image = Optional.empty();
    }
  }

  // Getter Methods

  public Weight getWeight() {
    return weight;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCfa_url() {
    return cfa_url;
  }

  public String getVetstreet_url() {
    return vetstreet_url;
  }

  public String getVcahospitals_url() {
    return vcahospitals_url;
  }

  public String getTemperament() {
    return temperament;
  }

  public String getOrigin() {
    return origin;
  }

  public String getCountry_codes() {
    return country_codes;
  }

  public String getCountry_code() {
    return country_code;
  }

  public String getDescription() {
    return description;
  }

  public String getLife_span() {
    return life_span;
  }

  public float getIndoor() {
    return indoor;
  }

  public float getLap() {
    return lap;
  }

  public String getAlt_names() {
    return alt_names;
  }

  public float getAdaptability() {
    return adaptability;
  }

  public float getAffection_level() {
    return affection_level;
  }

  public float getChild_friendly() {
    return child_friendly;
  }

  public float getDog_friendly() {
    return dog_friendly;
  }

  public float getEnergy_level() {
    return energy_level;
  }

  public float getGrooming() {
    return grooming;
  }

  public float getHealth_issues() {
    return health_issues;
  }

  public float getIntelligence() {
    return intelligence;
  }

  public float getShedding_level() {
    return shedding_level;
  }

  public float getSocial_needs() {
    return social_needs;
  }

  public float getStranger_friendly() {
    return stranger_friendly;
  }

  public float getVocalisation() {
    return vocalisation;
  }

  public float getExperimental() {
    return experimental;
  }

  public float getHairless() {
    return hairless;
  }

  public float getNatural() {
    return natural;
  }

  public float getRare() {
    return rare;
  }

  public float getRex() {
    return rex;
  }

  public float getSuppressed_tail() {
    return suppressed_tail;
  }

  public float getShort_legs() {
    return short_legs;
  }

  public String getWikipedia_url() {
    return wikipedia_url;
  }

  public float getHypoallergenic() {
    return hypoallergenic;
  }

  public String getReference_image_id() {
    return reference_image_id;
  }

  public Optional<Image> getImage() {
    return image;
  }

}
