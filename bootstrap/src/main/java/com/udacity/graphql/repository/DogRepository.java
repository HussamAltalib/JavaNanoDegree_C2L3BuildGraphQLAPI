package com.udacity.graphql.repository;

import com.udacity.graphql.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface DogRepository extends CrudRepository<Dog, Long> {

}
