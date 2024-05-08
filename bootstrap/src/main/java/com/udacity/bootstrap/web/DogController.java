package com.udacity.bootstrap.web;

import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    private DogService dogService;
    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(){
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogBreed")
    public ResponseEntity<List<String>> getAllDogBreed(){
        List<String> list = dogService.retrieveDogsBreed();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogBreedById/{id}")
    public ResponseEntity<String> getDogBreedById(@PathVariable long id){
        System.out.println(dogService.getDogBreedByDogId(id));
        String str = dogService.getDogBreedByDogId(id);
        return new ResponseEntity<String>(str, HttpStatus.OK);
    }

    @GetMapping("/dogNames")
    public ResponseEntity<List<String>> getAllDogNames(){
        List<String> list = dogService.retrieveDogsName();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
}
