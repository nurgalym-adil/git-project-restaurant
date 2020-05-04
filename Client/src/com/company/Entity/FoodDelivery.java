package com.company.Entity;

import java.io.Serializable;

public class FoodDelivery implements Serializable {
    private String foodName, userName, data;

    public FoodDelivery(String foodName, String userName, String data) {
        this.foodName = foodName;
        this.userName = userName;
        this.data = data;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
