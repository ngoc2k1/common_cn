package com.bichngoc.android_day5_food;

import java.io.Serializable;

public class Food implements Serializable {
    private String foodName, imgFood, time, distance, ratingStar, category, status;
    private int id;

    public Food(String name, int img_error, String time, String distance, String rating, String category, String status, int id) {
    }

    public Food(String foodName, String imgFood, String time, String distance, String ratingStar, String category, String status, int id) {
        this.foodName = foodName;
        this.imgFood = imgFood;
        this.time = time;
        this.distance = distance;
        this.ratingStar = ratingStar;
        this.category = category;
        this.status = status;
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getImgFood() {
        return imgFood;
    }

    public void setImgFood(String imgFood) {
        this.imgFood = imgFood;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getRatingStar() {
        return ratingStar;
    }

    public void setRatingStar(String ratingStar) {
        this.ratingStar = ratingStar;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", imgFood='" + imgFood + '\'' +
                ", time='" + time + '\'' +
                ", distance='" + distance + '\'' +
                ", ratingStar='" + ratingStar + '\'' +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                ", id=" + id +
                '}';
    }
}