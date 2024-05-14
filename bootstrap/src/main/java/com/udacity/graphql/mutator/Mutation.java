package com.udacity.graphql.mutator;

import com.udacity.graphql.entity.Dog;
import com.udacity.graphql.exception.BreedNotFoundException;
import com.udacity.graphql.exception.DogNotFoundException;
import com.udacity.graphql.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class Mutation {


    private DogRepository dogRepository;

    @Autowired
    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }


    @MutationMapping
    public boolean deleteDogBreed(@Argument String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        // Loop through all dogs to check their breed
        for (Dog d:allDogs) {
            if (d.getBreed().equals(breed)) {
                // Delete if the breed is found
                dogRepository.delete(d);
                deleted = true;
            }
        }
        // Throw an exception if the breed doesn't exist
        if (!deleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
        return deleted;
    }
    @MutationMapping
    public Dog updateDogName(@Argument String name, @Argument Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if( optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            dog.setName(name);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog not found", id);
        }
    }
}
