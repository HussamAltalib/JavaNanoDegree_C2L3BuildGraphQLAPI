package com.udacity.bootstrap.repository;

import com.udacity.bootstrap.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query("select breed from Dog")
    List<String> getDogsBreed();

    @Query("Select breed FROM Dog where id=?1")
    String getDogBreedById(long id);
    @Query("select name from Dog")
    List<String> retrieveDogNames();

}
