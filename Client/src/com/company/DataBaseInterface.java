package com.company;

import com.company.Entity.*;

import java.util.ArrayList;

public interface DataBaseInterface {
    boolean getUserHandle(String userHandle);
    boolean getUserPhone(String phone);
    User getOneUserWithThisHandle(String userHandle);
    ArrayList<User> getAllUser();
    void upDateUser(User thisUser);
    void removeUser(String thisHandle);
    void removeUserPart1(String thisHandle);
    void removeUserPart2(String thisHandle);
    void addUser(User thisUser);
    boolean getResCheck(String resName);
    void addRestaurant(Restaurants restaurants);
    ArrayList<Restaurants> getAllRestaurants();
    void addTable(Restaurant_table table);
    boolean getTableCheck(String tabName, String resName);
    ArrayList<Restaurant_table> getAllTables(String resName);
    ArrayList<String> getAllTablesOnlyName(String resName);
    void removeTable(Restaurant_table table);
    void removeRestaurant(String ResName);
    void deleteResPart1(String ResName);
    void deleteResPart2(String ResName);
    void deleteResPart3(String ResName);
    ArrayList<Food> getAllFoodsInThisRes(String resName);
    ArrayList<String> getAllFoodsInThisResOnlyName(String resName);
    boolean FoodResCheck(String resName, String FoodName);
    void addFood(Food food);
    ArrayList<Food> getAllFood();
    boolean FoodAllCheck(String FoodName);
    void removeFoods(String FoodName);
    void removeFoodsFromRes(String FoodName, String ResName);
    ArrayList<BookingTables> GetAllBookingTables();
    ArrayList<FoodDelivery> GetAllFoodDelivery();
    void addBookingTable(BookingTables order);
    void addFoodDelivery(FoodDelivery order);
    void removeBookingTable(BookingTables order);
    void removeFoodDelivery(FoodDelivery order);
    boolean CheckTheLogIn(String UserHandle, String pss);
    String[] GetAllFoodName();
    ArrayList<FoodDelivery> GetAllFoodDeliveryThisUser(String userHandle);
    ArrayList<BookingTables> GetAllBookingTablesThisUser(String userHandle);

}
