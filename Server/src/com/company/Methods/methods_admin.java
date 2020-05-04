package com.company.Methods;

import com.company.DataBase;
import com.company.DataBaseInterface;
import com.company.Entity.*;

import java.util.ArrayList;

public class methods_admin implements Standard_methods {
    private DataBaseInterface dataBase = new DataBase();

    @Override
    public String UsersListTextArea() {
        dataBase.Connect();
        String s = "";
        ArrayList<User>users = dataBase.getAllUser();
        for(User i : users){
            s +=  ("Name: " + i.getName() + " " + i.getSurname() + ", handle: " + i.getHandle() +
                    ", phone number: " + i.getPhoneNumber() + "\n");
        }
        return s;
    }

    @Override
    public String RestaurantListTextArea() {
        dataBase.Connect();
        ArrayList<Restaurants>restaurants = dataBase.getAllRestaurants();
        String s = "";
        for(Restaurants i : restaurants){
            s += "Restaurant name: " + i.getName() + ", rating: " + i.getRating() + "\n";
        }
        return s;
    }

    @Override
    public ArrayList<String> GetRestaurantName() {
        dataBase.Connect();
        ArrayList<Restaurants>restaurants = dataBase.getAllRestaurants();
        ArrayList<String>names=  new ArrayList<>();
        for(Restaurants i : restaurants) names.add(i.getName());
        return names;
    }

    @Override
    public String getUserOrders(String handle) {
        return null;
    }

    @Override
    public String getListAllOrder() {
        dataBase.Connect();
        ArrayList<BookingTables>bookingTables = dataBase.GetAllBookingTables();
        ArrayList<FoodDelivery>foodDeliveries = dataBase.GetAllFoodDelivery();
        String s = "Booking tables:\n";
        int t = 1;
        for(BookingTables i : bookingTables) {
            s += t + ". Restaurant: " + i.getRestaurantName() + ", user: " + i.getUserName() + ", food: " + i.getFoodName()
                    + ", table: " + i.getTableName() + ", driver: " + i.getDriver()
                    + ", music: " + i.getMusic() + ", parking: " + i.getParking() + ".\n";
            t++;
        }
        t = 1;
        s += "\nFood delivery:\n";
        for(FoodDelivery i : foodDeliveries) {
            s += t + ". Food: " + i.getFoodName() + ", user: " + i.getUserName() + ", the address: " + i.getData() + ".\n";
            t++;
        }
        return s;
    }

    @Override
    public String AllFoods() {
        dataBase.Connect();
        String s = "";
        ArrayList<Food>foods = dataBase.getAllFood();
        for(Food i : foods) s += "Restaurant name: " + i.getRestaurantName() + ", food: " + i.getFoodName() + "\n";
        return s;
    }

    @Override
    public String ResFoodList(String s) {
        dataBase.Connect();
        String res = "";
        ArrayList<Food>foods = dataBase.getAllFoodsInThisRes(s);
        for(Food i : foods) res += "Food name: " + i.getFoodName() + "\n";
        return res;
    }

    @Override
    public String TablesRestaurantList(String s) {
        dataBase.Connect();
        ArrayList<Restaurant_table>tables = dataBase.getAllTables(s);
        String res = "";
        for(Restaurant_table i : tables)
            res += "Restaurant" + i.getRestaurantName() + ", table name: "
                    + i.getTableNum() + "\n";
        return res;
    }

    @Override
    public ArrayList<String> getUserHandle() {
        dataBase.Connect();
        ArrayList<String>userHandle = new ArrayList<>();
        ArrayList<User>users = dataBase.getAllUser();
        for(User i : users){
            userHandle.add(i.getHandle());
        }
        return userHandle;
    }
}
