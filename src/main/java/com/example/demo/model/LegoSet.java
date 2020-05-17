package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Collection;

@Document(collection = "legosets")
public class LegoSet {

    @Id
    private String id;

    @TextIndexed
    private String name;

    private LegoSetDifficulty difficulty;

    @TextIndexed
    private String theme;

    @Indexed(direction = IndexDirection.ASCENDING)
    private Collection<ProductReview> reviews = new ArrayList<>();

    // this annotation change name
    @Field("delivery")
    private DeliveryInfo deliveryInfo;

    // this annotation is required if you have multiple constructors to chose one of them
    // @PersistenceConstructor
    public LegoSet(String name,
                   String theme,
                   LegoSetDifficulty difficulty,
                   DeliveryInfo deliveryInfo,
                   Collection<ProductReview> reviews) {
        this.name = name;
        this.difficulty = difficulty;
        this.theme = theme;
        this.deliveryInfo = deliveryInfo;
        if (reviews != null) {
            this.reviews = reviews;
        }
    }

    @Transient
    private int nbParts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LegoSetDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(LegoSetDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Collection<ProductReview> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<ProductReview> reviews) {
        this.reviews = reviews;
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }
}
