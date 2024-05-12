package com.udacity.graphql.mutator;

import com.udacity.graphql.entity.Dog;
import com.udacity.graphql.exception.BreedNotFoundException;
import com.udacity.graphql.repository.DogRepository;
import com.udacity.graphql.service.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }


    public boolean deleteDogBreed(String breed) {
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

//    public Dog deleteDogBreed(Long id){
//        Optional<Dog> optionalDog = dogRepository.findById(id);
//
//        if( optionalDog.isPresent()){
//            Dog dog = optionalDog.get();
//            dog.setBreed(null);
//            dogRepository.save(dog);
//            return dog;
//        } else {
//            throw new DogNotFoundException("Dog not found");
//        }
//    }

    public Dog updateDogName(String newName, Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if( optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog not found");
        }
    }
}
