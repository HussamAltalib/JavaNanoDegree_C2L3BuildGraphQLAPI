package com.udacity.bootstrap.service;

import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    DogRepository dogRepository;

    public List<Dog> retrieveDogs(){
        return (List<Dog>) dogRepository.findAll();
    }

    public List<String> retrieveDogsBreed(){
        return dogRepository.getDogsBreed();
    }

    public String getDogBreedByDogId(long id){

        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.getDogBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;


//                if(dogRepository.getDogBreedById(id) == null){
//            throw new DogNotFoundException("the id is not correct");
//        } else {
//            return dogRepository.getDogBreedById(id);
//        }
    }

    public List<String> retrieveDogsName(){
        return dogRepository.retrieveDogNames();
    }
}
