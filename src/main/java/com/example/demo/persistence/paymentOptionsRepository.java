package com.example.demo.persistence;

import com.example.demo.model.PaymentOptions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface paymentOptionsRepository extends MongoRepository<PaymentOptions, String> {

}
