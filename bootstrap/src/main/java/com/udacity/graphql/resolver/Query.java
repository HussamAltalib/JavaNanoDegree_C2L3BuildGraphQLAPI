package com.udacity.graphql.resolver;

import com.udacity.graphql.entity.Dog;
import com.udacity.graphql.exception.DogNotFoundException;
import com.udacity.graphql.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class Query {
    private DogRepository dogRepository;

    @Autowired
    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @QueryMapping
    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }

    @QueryMapping
    public Dog findDogById(@Argument Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }

}
