package com.example.demo;

import com.github.mongobee.Mongobee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class LegostoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(LegostoreApplication.class, args);
    }

    @Autowired
    MongoTemplate mongoTemplate;

    // configure mongobee runner
    @Bean
    public Mongobee mongobee() {

        // connection utl to the database
        Mongobee runner = new Mongobee("mongodb://localhost:27017/legostore");

        runner.setMongoTemplate(mongoTemplate);

        // set scan package of data migration(Repository) when java model in our db are out of sync
        runner.setChangeLogsScanPackage("com.example.demo.persistence");

        return runner;
    }

}
