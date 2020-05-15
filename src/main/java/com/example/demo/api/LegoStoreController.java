package com.example.demo.api;

import com.example.demo.model.LegoSet;
import com.example.demo.persistence.LegoSetRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("legostore/api")
public class LegoStoreController {

    private final LegoSetRepository legoSetRepository;

    public LegoStoreController(LegoSetRepository legoSetRepository) {
        this.legoSetRepository = legoSetRepository;
    }

    @PostMapping
    private void insert(@RequestBody LegoSet legoSet) {
        this.legoSetRepository.insert(legoSet);
    }

    @PutMapping
    public void update(@RequestBody LegoSet legoSet) {
        this.legoSetRepository.save(legoSet);
    }

    @GetMapping("/all")
    public Collection<LegoSet> all(){
        List<LegoSet> legosets = this.legoSetRepository.findAll();

        return legosets;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        //        this.mongoTemplate.remove(new Query(Criteria.where("id").is(id)), LegoSet.class);
        this.legoSetRepository.deleteById(id);
    }

}
