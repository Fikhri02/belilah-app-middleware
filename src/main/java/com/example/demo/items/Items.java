package com.example.demo.items;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table
public class Items {

    @Id
    @SequenceGenerator(
            name="items_id_sequence",
            sequenceName = "items_id_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "items_id_sequence"
    )

    private Long id;
    private String  code;
    private String description;
    private String imageUrl;
    private double unitPrice;
    private double reviewCount;
    private double averageReview;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice(){
        return unitPrice;
    }

    public void setReviewCount(double reviewCount){
        this.reviewCount = reviewCount;
    }

    public double getReviewCount(){
        return reviewCount;
    }

    public void setAverageReview(double averageReview){
        this.averageReview = averageReview;
    }

    public double getAverageReview(){
        return averageReview;
    }

    public long getId(){
        return id;
    }
}
