package com.company;

import com.company.Entity.*;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DataBase implements DataBaseInterface{

    private Connection connection;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public DataBase() {
        try {
            this.outputStream = new ObjectOutputStream(Client.socket.getOutputStream());
            this.inputStream = new ObjectInputStream(Client.socket.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    public void Connect(){
//        try {
//            outputStream = new ObjectOutputStream(Client.socket.getOutputStream());
//            inputStream = new ObjectInputStream(Client.socket.getInputStream());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
    public boolean getUserHandle(String userHandle){
        try{
            Request request = new Request("getUserHandle", userHandle, null, null, null);
            outputStream.writeObject(request);
            return (boolean) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean getUserPhone(String phone){
        try{
            Request request = new Request("getUserPhone", phone, null, null, null);
            outputStream.writeObject(request);
            return (boolean) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public User getOneUserWithThisHandle(String userHandle){
        try{
            Request request = new Request("getOneUserWithThisHandle", userHandle, null, null, null);
            outputStream.writeObject(request);
            return (User) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<User> getAllUser(){
        try{
            Request request = new Request("getAllUser", null, null, null, null);
            outputStream.writeObject(request);
            return (ArrayList<User>) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void upDateUser(User thisUser){
        try{
            Request request = new Request("upDateUser", null, null, thisUser, null);
            outputStream.writeObject(request);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void removeUser(String thisHandle){
        try{
            Request request = new Request("removeUser", thisHandle, null, null, null);
            outputStream.writeObject(request);
        } catch (Exception e){
            e.printStackTrace();
        }
        removeUserPart1(thisHandle);
        removeUserPart2(thisHandle);
    }
    public void removeUserPart1(String thisHandle){
        try{
            Request request = new Request("removeUserPart1", thisHandle, null, null, null);
            outputStream.writeObject(request);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void removeUserPart2(String thisHandle){
        try{
            Request request = new Request("removeUserPart2", thisHandle, null, null, null);
            outputStream.writeObject(request);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addUser(User thisUser){
        try{
            Request request = new Request("addUser", null, null, thisUser, null);
            outputStream.writeObject(request);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean getResCheck(String resName){
        try{
            Request request = new Request("getResCheck", resName, null, null, null);
            outputStream.writeObject(request);
            return (boolean) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public void addRestaurant(Restaurants restaurants){
        try{
            Request request = new Request("addRestaurant", null, null, restaurants, null);
            outputStream.writeObject(request);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Restaurants> getAllRestaurants(){
        try{
            Request request = new Request("getAllRestaurants", null, null, null, null);
            outputStream.writeObject(request);
            return (ArrayList<Restaurants>) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void addTable(Restaurant_table table){
        try{
            Request request = new Request("addTable", null, null, table, null);
            outputStream.writeObject(request);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean getTableCheck(String tabName, String resName){
        try{
            Request request = new Request("getTableCheck", tabName, resName, null, null);
            outputStream.writeObject(request);
            return (boolean) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<Restaurant_table> getAllTables(String resName){
        try{
            Request request = new Request("getAllTables", resName, null, null, null);
            outputStream.writeObject(request);
            return (ArrayList<Restaurant_table>) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<String> getAllTablesOnlyName(String resName){
        try{
            Request request = new Request("getAllTablesOnlyName", resName, null, null, null);
            outputStream.writeObject(request);
            return (ArrayList<String>) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void removeTable(Restaurant_table table){
        try{
            Request request = new Request("removeTable", null, null, table, null);
            outputStream.writeObject(request);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void removeRestaurant(String ResName){
        try{
            Request request = new Request("removeRestaurant", ResName, null, null, null);
            outputStream.writeObject(request);
        } catch (Exception e){
            e.printStackTrace();
        }
        deleteResPart1(ResName);
        deleteResPart2(ResName);
        deleteResPart3(ResName);
    }
    public void deleteResPart1(String ResName){
        try{
            Request request = new Request("deleteResPart1", ResName, null, null, null);
            outputStream.writeObject(request);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteResPart2(String ResName){
        try{
            Request request = new Request("deleteResPart2", ResName, null, null, null);
            outputStream.writeObject(request);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteResPart3(String ResName){
        try{
            Request request = new Request("deleteResPart3", ResName, null, null, null);
            outputStream.writeObject(request);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Food> getAllFoodsInThisRes(String resName){
        try{
            Request request = new Request("getAllFoodsInThisRes", resName, null, null, null);
            outputStream.writeObject(request);
            return (ArrayList<Food>) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<String> getAllFoodsInThisResOnlyName(String resName){
        try{
            Request request = new Request("getAllFoodsInThisResOnlyName", resName, null, null, null);
            outputStream.writeObject(request);
            return (ArrayList<String>) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean FoodResCheck(String resName, String FoodName){
        try{
            Request request = new Request("FoodResCheck", resName, FoodName, null, null);
            outputStream.writeObject(request);
            return (boolean) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public void addFood(Food food){
        try{
            Request request = new Request("addFood", null, null, food, null);
            outputStream.writeObject(request);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Food> getAllFood(){
        try{
            Request request = new Request("getAllFood", null, null, null, null);
            outputStream.writeObject(request);
            return (ArrayList<Food>) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean FoodAllCheck(String FoodName){
        try{
            Request request = new Request("FoodAllCheck", FoodName, null, null, null);
            outputStream.writeObject(request);
            return (boolean) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public void removeFoods(String FoodName){
        try{
            Request request = new Request("removeFoods", FoodName, null, null, null);
            outputStream.writeObject(request);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void removeFoodsFromRes(String FoodName, String ResName){
        try{
            Request request = new Request("removeFoodsFromRes", FoodName, ResName, null, null);
            outputStream.writeObject(request);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<BookingTables> GetAllBookingTables(){
        try{
            Request request = new Request("GetAllBookingTables", null, null, null, null);
            outputStream.writeObject(request);
            return (ArrayList<BookingTables>) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<FoodDelivery> GetAllFoodDelivery(){
        try{
            Request request = new Request("GetAllFoodDelivery", null, null, null, null);
            outputStream.writeObject(request);
            return (ArrayList<FoodDelivery>) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void addBookingTable(BookingTables order){
        try {
            Request request = new Request("addBookingTable", null, null, order, null);
            outputStream.writeObject(request);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addFoodDelivery(FoodDelivery order){
        try {
            Request request = new Request("addFoodDelivery", null, null, order, null);
            outputStream.writeObject(request);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeBookingTable(BookingTables order){
        try{
            Request request = new Request("removeBookingTable", null, null, order, null);
            outputStream.writeObject(request);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void removeFoodDelivery(FoodDelivery order){
        try{
            Request request = new Request("removeFoodDelivery", null, null, order, null);
            outputStream.writeObject(request);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean CheckTheLogIn(String UserHandle, String pss){
        try{
            Request request = new Request("CheckTheLogIn", UserHandle, pss, null, null);
            outputStream.writeObject(request);
            return (boolean) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public String[] GetAllFoodName(){
        try{
            Request request = new Request("GetAllFoodName", null, null, null, null);
            outputStream.writeObject(request);
            return (String[]) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<FoodDelivery> GetAllFoodDeliveryThisUser(String userHandle){
        try{
            Request request = new Request("GetAllFoodDeliveryThisUser", userHandle, null, null, null);
            outputStream.writeObject(request);
            return (ArrayList<FoodDelivery>) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<BookingTables> GetAllBookingTablesThisUser(String userHandle){
        try{
            Request request = new Request("GetAllBookingTablesThisUser", userHandle, null, null, null);
            outputStream.writeObject(request);
            return (ArrayList<BookingTables>) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
