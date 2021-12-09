package com.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Crop;
@Repository
public interface CropRepository extends MongoRepository <Crop,Integer>{

	Optional<Crop> findByCropName(String cropName);

	Optional<Crop> findByCropType(String cropType);

}
