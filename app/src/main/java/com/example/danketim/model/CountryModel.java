package com.example.danketim.model;

import java.io.Serializable;

//implements Serializable  это означает что мы model ку переобразобываем ёе в bytecode
public class CountryModel implements Serializable {

    public CountryModel(String imageUrl, String name, int amount, String color) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.amount = amount;
        this.color = color;
    }
    private String imageUrl;
    private String name;
    private int amount;
    private String color;

    public String getImageUrl() {return imageUrl;}

    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getAmount() {return amount;}

    public void setAmount(int amount) {this.amount = amount;}

    public String getColor() {return color;}

    public void setColor(String color) {this.color = color;}
}
