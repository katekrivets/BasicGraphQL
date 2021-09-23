package com.katekrivets.bootstrap.web;

import com.katekrivets.bootstrap.entity.Dog;
import com.katekrivets.bootstrap.service.DogService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@ApiResponses(value = {
        @ApiResponse(code=400, message="This is the bad request"),
        @ApiResponse(code=500, message="Something went wrong")
})
public class DogController {
    private DogService dogService;

    @Autowired
    public void setLocationService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getDogs() {
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/{id}")
    public ResponseEntity<Dog> getDog(@PathVariable Long id) {
        Dog dog = dogService.retrieveDogById(id);
        return new ResponseEntity<Dog>(dog, HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getDogNames() {
        List<String> listName = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(listName, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getDogsBreed() {
        List<String> listBread = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(listBread, HttpStatus.OK);
    }

    @GetMapping("/dogs/{id}/breed")
    public ResponseEntity<String> getDogsBreedById(@PathVariable Long id) {
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }

}