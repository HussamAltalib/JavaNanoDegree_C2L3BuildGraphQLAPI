package com.udacity.graphql.web;

import com.udacity.graphql.entity.Dog;
import com.udacity.graphql.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.stereotype.Controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;


@Controller
public class DogController {

    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @QueryMapping
    public List<Dog> getAllDogs() {
        return dogService.retrieveDogs();
    }

     @MutationMapping
     public Dog createDog(@Argument Dog dog) {
         return dogService.saveDog(dog);
     }
}

