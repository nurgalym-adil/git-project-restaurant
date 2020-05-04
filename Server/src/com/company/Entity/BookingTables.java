package com.company.Entity;

import java.io.Serializable;

public class BookingTables implements Serializable {
    private String restaurantName, userName, foodName, tableName, driver, music, parking;

    public BookingTables(String restaurantName, String userName, String foodName, String tableName, String driver, String music, String parking) {
        this.restaurantName = restaurantName;
        this.userName = userName;
        this.foodName = foodName;
        this.tableName = tableName;
        this.driver = driver;
        this.music = music;
        this.parking = parking;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }
}
