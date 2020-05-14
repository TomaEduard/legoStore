package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collection;

public class LegoSet {

    private String id;
    private String name;
    private LegoSetDifficulty difficulty;
    private String theme;
    private Collection<ProductReview> reviews = new ArrayList<>();
    private DeliveryInfo deliveryInfo;

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
