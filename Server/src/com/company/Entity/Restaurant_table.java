package com.company.Entity;

import java.io.Serializable;

public class Restaurant_table implements Serializable {
    private String restaurantName, data, tableNum;

    public Restaurant_table(String restaurantName, String data, String tableNum) {
        this.restaurantName = restaurantName;
        this.data = data;
        this.tableNum = tableNum;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTableNum() {
        return tableNum;
    }

    public void setTableNum(String tableNum) {
        this.tableNum = tableNum;
    }
}
