package com.katekrivets.bootstrap.mutator;

import com.katekrivets.bootstrap.entity.Dog;
import com.katekrivets.bootstrap.repository.DogRepository;
import com.katekrivets.bootstrap.service.BreedNotFoundException;
import com.katekrivets.bootstrap.service.DogNotFoundException;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private final DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    //    newDog(name: String!, breed: String!, origin: String) : Dog!
//    deleteDogBreed(breed:String!) : Boolean
//    updateDogName(newName: String!, id:ID!) : Dog!
    public Dog newDog(String name, String breed, String origin) {
        Dog newDog = new Dog(name, breed, origin);
        dogRepository.save(newDog);
        return newDog;
    }

    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        // Loop through all dogs to check their breed
        for (Dog d : allDogs) {
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

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            // Set the new name and save the updated dog
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
