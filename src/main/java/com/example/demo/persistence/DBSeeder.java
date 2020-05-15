package com.example.demo.persistence;

import com.example.demo.model.DeliveryInfo;
import com.example.demo.model.LegoSet;
import com.example.demo.model.LegoSetDifficulty;
import com.example.demo.model.ProductReview;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

@Service
public class DBSeeder implements CommandLineRunner {

    private MongoTemplate mongoTemplate;

    public DBSeeder(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

        // clean de db
        this.mongoTemplate.dropCollection(LegoSet.class);


        LegoSet milleniumFalcom = new LegoSet(
                "Millenium Falcon",
                "Star Wars",
                LegoSetDifficulty.HARD,
                new DeliveryInfo(LocalDate.now().plusDays(1), 30, true),
                Arrays.asList(
                        new ProductReview("Dan", 7),
                        new ProductReview("Anna", 10),
                        new ProductReview("John", 8)
                )
        );

        LegoSet skyPolice = new LegoSet(
                "Sky Police Air Base",
                "City",
                LegoSetDifficulty.MEDIUM,
                new DeliveryInfo(LocalDate.now().plusDays(3), 50, true),
                Arrays.asList(
                        new ProductReview("Dan", 5),
                        new ProductReview("Andrew", 8)
                )
        );

        LegoSet mcLarenSenna = new LegoSet(
                "McLaren Senna",
                "Speed Champions",
                LegoSetDifficulty.EASY,
                new DeliveryInfo(LocalDate.now().plusDays(7), 70, true),
                Arrays.asList(
                        new ProductReview("Dan", 9),
                        new ProductReview("Andrew", 9)
                )
        );

        Collection<LegoSet> initialProducts = Arrays.asList(milleniumFalcom, skyPolice, mcLarenSenna);
        this.mongoTemplate.insertAll(initialProducts);
    }
}
