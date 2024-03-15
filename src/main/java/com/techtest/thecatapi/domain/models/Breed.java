package com.techtest.thecatapi.domain.models;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Breed {

  private final Weight weight;
  private final String id;
  private final String name;
  private final String cfaUrl;
  private final String vetstreetUrl;
  private final String vcahospitalsUrl;
  private final String temperament;
  private final String origin;
  private final String countryCodes;
  private final String countryCode;
  private final String description;
  private final String lifeSpan;
  private final float indoor;
  private final float lap;
  private final String altNames;
  private final float adaptability;
  private final float affectionLevel;
  private final float childFriendly;
  private final float catFriendly;
  private final float dogFriendly;
  private final float energyLevel;
  private final float grooming;
  private final float healthIssues;
  private final float intelligence;
  private final float sheddingLevel;
  private final float socialNeeds;
  private final float strangerFriendly;
  private final float vocalisation;
  private final float bidability;
  private final float experimental;
  private final float hairless;
  private final float natural;
  private final float rare;
  private final float rex;
  private final float suppressedTail;
  private final float shortLegs;
  private final String wikipediaUrl;
  private final float hypoallergenic;
  private final String referenceImageId;
  private final Optional<Image> image;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public Breed(@JsonProperty("weight") Weight weight,
      @JsonProperty("id") String id,
      @JsonProperty("name") String name,
      @JsonProperty("cfa_url") String cfaUrl,
      @JsonProperty("vetstreet_url") String vetstreetUrl,
      @JsonProperty("vcahospitals_url") String vcahospitalsUrl,
      @JsonProperty("temperament") String temperament,
      @JsonProperty("origin") String origin,
      @JsonProperty("country_codes") String countryCodes,
      @JsonProperty("country_code") String countryCode,
      @JsonProperty("description") String description,
      @JsonProperty("life_span") String lifeSpan,
      @JsonProperty("indoor") float indoor,
      @JsonProperty("lap") float lap,
      @JsonProperty("alt_names") String altNames,
      @JsonProperty("adaptability") float adaptability,
      @JsonProperty("affection_level") float affectionLevel,
      @JsonProperty("child_friendly") float childFriendly,
      @JsonProperty("cat_friendly") float catFriendly,
      @JsonProperty("dog_friendly") float dogFriendly,
      @JsonProperty("energy_level") float energyLevel,
      @JsonProperty("grooming") float grooming,
      @JsonProperty("health_issues") float healthIssues,
      @JsonProperty("intelligence") float intelligence,
      @JsonProperty("shedding_level") float sheddingLevel,
      @JsonProperty("social_needs") float socialNeeds,
      @JsonProperty("stranger_friendly") float strangerFriendly,
      @JsonProperty("vocalisation") float vocalisation,
      @JsonProperty("bidability") float bidability,
      @JsonProperty("experimental") float experimental,
      @JsonProperty("hairless") float hairless,
      @JsonProperty("natural") float natural,
      @JsonProperty("rare") float rare,
      @JsonProperty("rex") float rex,
      @JsonProperty("suppressed_tail") float suppressedTail,
      @JsonProperty("short_legs") float shortLegs,
      @JsonProperty("wikipedia_url") String wikipediaUrl,
      @JsonProperty("hypoallergenic") float hypoallergenic,
      @JsonProperty("reference_image_id") String referenceImageId,
      @JsonProperty("image") Image image) {
    this.weight = new Weight(weight.getImperial(), weight.getMetric());
    this.id = id;
    this.name = name;
    this.cfaUrl = cfaUrl;
    this.vetstreetUrl = vetstreetUrl;
    this.vcahospitalsUrl = vcahospitalsUrl;
    this.temperament = temperament;
    this.origin = origin;
    this.countryCodes = countryCodes;
    this.countryCode = countryCode;
    this.description = description;
    this.lifeSpan = lifeSpan;
    this.indoor = indoor;
    this.lap = lap;
    this.altNames = altNames;
    this.adaptability = adaptability;
    this.affectionLevel = affectionLevel;
    this.childFriendly = childFriendly;
    this.catFriendly = catFriendly;
    this.dogFriendly = dogFriendly;
    this.energyLevel = energyLevel;
    this.grooming = grooming;
    this.healthIssues = healthIssues;
    this.intelligence = intelligence;
    this.sheddingLevel = sheddingLevel;
    this.socialNeeds = socialNeeds;
    this.strangerFriendly = strangerFriendly;
    this.vocalisation = vocalisation;
    this.bidability = bidability;
    this.experimental = experimental;
    this.hairless = hairless;
    this.natural = natural;
    this.rare = rare;
    this.rex = rex;
    this.suppressedTail = suppressedTail;
    this.shortLegs = shortLegs;
    this.wikipediaUrl = wikipediaUrl;
    this.hypoallergenic = hypoallergenic;
    this.referenceImageId = referenceImageId;

    if (image != null) {
      Image ImageObject = new Image(image.getId(), image.getWidth(), image.getHeight(), image.getUrl());
      this.image = Optional.of(ImageObject);
    } else {
      this.image = Optional.empty();
    }
  }

  // Getter Methods

  @JsonProperty("weight")
  public Weight getWeight() {
    return weight;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("cfa_url")
  public String getCfaUrl() {
    return cfaUrl;
  }

  @JsonProperty("vetstreet_url")
  public String getVetstreetUrl() {
    return vetstreetUrl;
  }

  @JsonProperty("vcahospitals_url")
  public String getVcahospitalsUrl() {
    return vcahospitalsUrl;
  }

  @JsonProperty("temperament")
  public String getTemperament() {
    return temperament;
  }

  @JsonProperty("origin")
  public String getOrigin() {
    return origin;
  }

  @JsonProperty("country_codes")
  public String getCountryCodes() {
    return countryCodes;
  }

  @JsonProperty("country_code")
  public String getCountryCode() {
    return countryCode;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  @JsonProperty("life_span")
  public String getLifeSpan() {
    return lifeSpan;
  }

  @JsonProperty("indoor")
  public float getIndoor() {
    return indoor;
  }

  @JsonProperty("lap")
  public float getLap() {
    return lap;
  }

  @JsonProperty("alt_names")
  public String getAltNames() {
    return altNames;
  }

  @JsonProperty("adaptability")
  public float getAdaptability() {
    return adaptability;
  }

  @JsonProperty("affection_level")
  public float getAffectionLevel() {
    return affectionLevel;
  }

  @JsonProperty("child_friendly")
  public float getChildFriendly() {
    return childFriendly;
  }

  @JsonProperty("cat_friendly")
  public float getCatFriendly() {
    return catFriendly;
  }

  @JsonProperty("dog_friendly")
  public float getDogFriendly() {
    return dogFriendly;
  }

  @JsonProperty("energy_level")
  public float getEnergyLevel() {
    return energyLevel;
  }

  @JsonProperty("grooming")
  public float getGrooming() {
    return grooming;
  }

  @JsonProperty("health_issues")
  public float getHealthIssues() {
    return healthIssues;
  }

  @JsonProperty("intelligence")
  public float getIntelligence() {
    return intelligence;
  }

  @JsonProperty("shedding_level")
  public float getSheddingLevel() {
    return sheddingLevel;
  }

  @JsonProperty("social_needs")
  public float getSocialNeeds() {
    return socialNeeds;
  }

  @JsonProperty("stranger_friendly")
  public float getStrangerFriendly() {
    return strangerFriendly;
  }

  @JsonProperty("vocalisation")
  public float getVocalisation() {
    return vocalisation;
  }

  @JsonProperty("bidability")
  public float getBidability() {
    return bidability;
  }

  @JsonProperty("experimental")
  public float getExperimental() {
    return experimental;
  }

  @JsonProperty("hairless")
  public float getHairless() {
    return hairless;
  }

  @JsonProperty("natural")
  public float getNatural() {
    return natural;
  }

  @JsonProperty("rare")
  public float getRare() {
    return rare;
  }

  @JsonProperty("rex")
  public float getRex() {
    return rex;
  }

  @JsonProperty("suppressed_tail")
  public float getSuppressedTail() {
    return suppressedTail;
  }

  @JsonProperty("short_legs")
  public float getShortLegs() {
    return shortLegs;
  }

  @JsonProperty("wikipedia_url")
  public String getWikipediaUrl() {
    return wikipediaUrl;
  }

  @JsonProperty("hypoallergenic")
  public float getHypoallergenic() {
    return hypoallergenic;
  }

  @JsonProperty("reference_image_id")
  public String getReferenceImageId() {
    return referenceImageId;
  }

  @JsonProperty("image")
  public Optional<Image> getImage() {
    return image;
  }

}
