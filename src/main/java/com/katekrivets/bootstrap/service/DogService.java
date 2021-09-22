package com.katekrivets.bootstrap.service;

import com.katekrivets.bootstrap.entity.Dog;
import com.katekrivets.bootstrap.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService implements IDogService {
    @Autowired
    DogRepository dogRepository;

    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    public List<String> retrieveDogBreed() {
        return (List<String>) dogRepository.findAllBreed();
    }

    @Override
    public List<String> retrieveDogNames() {
        return dogRepository.findAllName();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findDogBreedById(id));
        return optionalBreed.orElseThrow(DogNotFoundException::new);
    }

}
