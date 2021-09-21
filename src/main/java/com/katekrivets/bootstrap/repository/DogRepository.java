package com.katekrivets.bootstrap.repository;

import com.katekrivets.bootstrap.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {

//    @Query("select d.name from Dog d")
//    List<Dog> findAllName();
//
//    @Query("select d.breed from Dog d")
//    List<String> findAllBreed();
//
//    @Query("select d.breed from Dog d where d.id=:id")
//    String findDogBreedById(@Param("id") Long id);
//
//    @Query("select d.id from Dog d where d.breed=:breed")
//    Long findDogIdByBreed(@Param("breed") String breed);

}
