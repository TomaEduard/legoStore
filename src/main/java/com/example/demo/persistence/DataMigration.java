package com.example.demo.persistence;

import com.example.demo.model.LegoSet;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@ChangeLog(order = "001")
public class DataMigration {

    @ChangeSet(order = "001", author = "dna", id = "update nb parts")
    public void updateNbParts(MongoTemplate mongoTemplate) {

        // create a script that selects all objects that have value of nbParts = 0 or null
        Criteria priceZeroCriteria = new Criteria().orOperator(
                Criteria.where("nbParts").is(0),
                Criteria.where("nbParts").is(null)
        );

//         if conditions of priceZeroCriteria is satisfied will set value of nbParts = 122
        mongoTemplate.updateMulti(
                new Query(priceZeroCriteria),
                Update.update("nbParts", 122), LegoSet.class
        );

        System.out.println("Applied changeset 001");
    }

}
