package com.example.demo.persistence;

import com.example.demo.model.DeliveryInfo;
import com.example.demo.model.LegoSet;
import com.example.demo.model.LegoSetDifficulty;
import com.example.demo.model.ProductReview;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

@Service
public class DBSeeder implements CommandLineRunner {

    private LegoSetRepository legoSetRepository;

    public DBSeeder(LegoSetRepository legoSetRepository) {
        this.legoSetRepository = legoSetRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.legoSetRepository.deleteAll();


        /*
        Lego Sets
         */

        LegoSet milleniumFalcon = new LegoSet(
                "Millennium Falcon",
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
                new DeliveryInfo(LocalDate.now().plusDays(7), 70, false),
                Arrays.asList(
                        new ProductReview("Bogdan", 9),
                        new ProductReview("Christa", 9)
                )
        );

        LegoSet mindstormsEve = new LegoSet(
                "MINDSTORMS EV3",
                "Mindstorms",
                LegoSetDifficulty.HARD,
                new DeliveryInfo(LocalDate.now().plusDays(10), 100, false),
                Arrays.asList(
                        new ProductReview("Cosmin", 10),
                        new ProductReview("Jane", 9),
                        new ProductReview("James", 10)
                )
        );

        Collection<LegoSet> initialProducts = Arrays.asList(milleniumFalcon, mindstormsEve,mcLarenSenna,skyPolice);

        this.legoSetRepository.insert(initialProducts);
    }
}
