package com.udacity.graphql.service;

import com.udacity.graphql.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> retrieveDogs();

    List<String> retrieveDogsBreed();

    String getDogBreedByDogId(long id);

    List<String> retrieveDogsName();
}
