package com.example.demo.api;

import com.example.demo.model.LegoSet;
import com.example.demo.model.LegoSetDifficulty;
import com.example.demo.persistence.LegoSetRepository;
import org.springframework.data.domain.Sort;
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
        Sort sortByThemAsc = Sort.by("theme").ascending();
        List<LegoSet> legosets = this.legoSetRepository.findAll(sortByThemAsc);
        return legosets;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        //        this.mongoTemplate.remove(new Query(Criteria.where("id").is(id)), LegoSet.class);
        this.legoSetRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public LegoSet byId(@PathVariable String id) {
        LegoSet legoSet = this.legoSetRepository.findById(id).orElse(null);
        return legoSet;
    }

    @GetMapping("/byTheme/{theme}")
    public Collection<LegoSet> byTheme(@PathVariable String theme) {
        Sort sortByThemAsc = Sort.by("theme").ascending();
//        return this.legoSetRepository.findAllByThemeContaining(theme);
        return this.legoSetRepository.findAllByThemeContaining(theme, sortByThemAsc);
    }

    @GetMapping("hardThatStartWithM")
    public Collection<LegoSet> hardThatStartWithM() {
        return this.legoSetRepository.findAllByDifficultyAndNameStartsWith(LegoSetDifficulty.HARD, "M");
    }

    @GetMapping("byDeliveryFeeLessThan/{price}")
    public Collection<LegoSet> byDeliveryFeeLessThan(@PathVariable int price) {
        return this.legoSetRepository.findAllByDeliveryPriceLessThan(price);
    }

    @GetMapping("greatReviews")
    public Collection<LegoSet> byGreaterReview() {
        return this.legoSetRepository.findAllByGreatReviews();
    }
}
