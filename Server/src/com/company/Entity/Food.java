package com.company.Entity;

import java.io.Serializable;

public class Food implements Serializable {
    private String restaurantName, foodName;

    public Food() {
    }

    public Food(String restaurantName, String foodName) {
        this.restaurantName = restaurantName;
        this.foodName = foodName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
