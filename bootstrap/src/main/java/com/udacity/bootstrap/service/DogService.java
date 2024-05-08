package com.udacity.bootstrap.service;

import com.udacity.bootstrap.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> retrieveDogs();

    List<String> retrieveDogsBreed();

    String getDogBreedByDogId(long id);

    List<String> retrieveDogsName();
}
