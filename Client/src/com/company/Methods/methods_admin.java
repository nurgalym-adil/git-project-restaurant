package com.company.Methods;

import com.company.Client;
import com.company.Entity.*;

import java.util.ArrayList;

public class methods_admin implements Standard_methods {
//    private DataBaseInterface dataBase = new DataBase();

    @Override
    public String UsersListTextArea() {
        String s = "";
        ArrayList<User>users = Client.dataBase.getAllUser();
        for(User i : users){
            s +=  ("Name: " + i.getName() + " " + i.getSurname() + ", handle: " + i.getHandle() +
                    ", phone number: " + i.getPhoneNumber() + "\n");
        }
        return s;
    }

    @Override
    public String RestaurantListTextArea() {
        ArrayList<Restaurants>restaurants = Client.dataBase.getAllRestaurants();
        String s = "";
        for(Restaurants i : restaurants){
            s += "Restaurant name: " + i.getName() + ", rating: " + i.getRating() + "\n";
        }
        return s;
    }

    @Override
    public ArrayList<String> GetRestaurantName() {
        ArrayList<Restaurants>restaurants = Client.dataBase.getAllRestaurants();
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
        ArrayList<BookingTables>bookingTables = Client.dataBase.GetAllBookingTables();
        ArrayList<FoodDelivery>foodDeliveries = Client.dataBase.GetAllFoodDelivery();
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
        String s = "";
        ArrayList<Food>foods = Client.dataBase.getAllFood();
        for(Food i : foods) s += "Restaurant name: " + i.getRestaurantName() + ", food: " + i.getFoodName() + "\n";
        return s;
    }

    @Override
    public String ResFoodList(String s) {
        String res = "";
        ArrayList<Food>foods = Client.dataBase.getAllFoodsInThisRes(s);
        for(Food i : foods) res += "Food name: " + i.getFoodName() + "\n";
        return res;
    }

    @Override
    public String TablesRestaurantList(String s) {
        ArrayList<Restaurant_table>tables = Client.dataBase.getAllTables(s);
        String res = "";
        for(Restaurant_table i : tables)
            res += "Restaurant" + i.getRestaurantName() + ", table name: "
                    + i.getTableNum() + "\n";
        return res;
    }

    @Override
    public ArrayList<String> getUserHandle() {
        ArrayList<String>userHandle = new ArrayList<>();
        ArrayList<User>users = Client.dataBase.getAllUser();
        for(User i : users){
            userHandle.add(i.getHandle());
        }
        return userHandle;
    }
}
