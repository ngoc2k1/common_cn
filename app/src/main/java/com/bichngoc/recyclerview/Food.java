package com.bichngoc.recyclerview;

import java.io.Serializable;

public class Food implements Serializable {
    private String name, price, star;

    public Food() {
    }

    public Food(String name, String price, String star) {
        this.name = name;
        this.price = price;
        this.star = star;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", star='" + star + '\'' +

                '}';
    }
}
