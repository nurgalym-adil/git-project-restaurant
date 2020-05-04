package com.company.Methods;

import com.company.Client;
import com.company.Entity.BookingTables;
import com.company.Entity.FoodDelivery;

import java.util.ArrayList;

public class methods_user implements Standard_methods {
//    private DataBaseInterface dataBase = new DataBase();
    @Override
    public String UsersListTextArea() {
        return null;
    }

    @Override
    public String RestaurantListTextArea() {
        return null;
    }

    @Override
    public String getListAllOrder() {
        return null;
    }

    @Override
    public String getUserOrders(String handle) {
        String s = "Booked tables:\n";
        int t = 1;
        ArrayList<BookingTables>bookingTables = Client.dataBase.GetAllBookingTablesThisUser(handle);
        ArrayList<FoodDelivery>foodDeliveries = Client.dataBase.GetAllFoodDeliveryThisUser(handle);
        for(BookingTables i : bookingTables) {
            s += t +  ". Restaurant: " + i.getRestaurantName() + ", food: " +
                    i.getFoodName() + ", table: " + i.getTableName() + ", music: " + i.getMusic() + ", driver: " +
                    i.getDriver() + ", parking: " + i.getParking() + ".\n";
            t++;
        }
        s += "\nFood delivery:\n";
        t = 1;
        for(FoodDelivery i : foodDeliveries) {
            s += t + ". Food: " + i.getFoodName() + ", address: " + i.getData() + ".\n";
            t++;
        }

        return s;
    }

    @Override
    public String AllFoods() {
        return null;
    }

    @Override
    public String ResFoodList(String s) {
        return null;
    }

    @Override
    public ArrayList<String> GetRestaurantName() {
        return null;
    }

    @Override
    public String TablesRestaurantList(String s) {
        return null;
    }

    @Override
    public ArrayList<String> getUserHandle() {
        return null;
    }
}
