package com.katekrivets.bootstrap.resolver;

import com.katekrivets.bootstrap.entity.Dog;
import com.katekrivets.bootstrap.repository.DogRepository;
import com.katekrivets.bootstrap.service.BreedNotFoundException;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

//    public Iterable<String> findDogBreeds() {
//        return dogRepository.findAllBreed();
//    }
//
//    public String findDogBreedById(Long id) {
//        Optional<Dog> dog = dogRepository.findById(id);
//        if (dog.isPresent()) {
//            return dog.get().getBreed();
//        } else {
//            throw new BreedNotFoundException("Dog not found", dog.get().getBreed());
//        }
//    }
}
