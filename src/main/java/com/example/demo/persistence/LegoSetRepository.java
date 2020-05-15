package com.example.demo.persistence;

import com.example.demo.model.LegoSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegoSetRepository extends MongoRepository<LegoSet, String> {



}
