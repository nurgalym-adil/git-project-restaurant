package com.company;

import com.company.Entity.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataBaseInterface dataBase = new DataBase();
        dataBase.Connect();
        try(ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())){
            Request request;
            while ((request = (Request) inputStream.readObject()) != null){
                System.out.println("CLIENT REQUESTS: " + request.getStr1());
                if(request.getStr1().equals("getUserHandle")){
                    boolean ok = dataBase.getUserHandle(request.getStr2());
                    outputStream.writeObject(ok);
                }
                else if(request.getStr1().equals("CheckTheLogIn")){
                    boolean ok = dataBase.CheckTheLogIn(request.getStr2(), request.getStr3());
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("getUserPhone")){
                    boolean ok = dataBase.getUserPhone(request.getStr2());
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("getOneUserWithThisHandle")){
                    User ok = dataBase.getOneUserWithThisHandle(request.getStr2());
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("getAllUser")){
                    ArrayList<User> ok = dataBase.getAllUser();
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("upDateUser")){
                    dataBase.upDateUser((User) request.getObject1());
                }
                else if (request.getStr1().equals("removeUser")){
                    dataBase.removeUser(request.getStr2());
                }
                else if (request.getStr1().equals("removeUserPart1")){
                    dataBase.removeUserPart1(request.getStr2());
                }
                else if (request.getStr1().equals("removeUserPart2")){
                    dataBase.removeUserPart2(request.getStr2());
                }
                else if (request.getStr1().equals("addUser")){
                    dataBase.addUser((User) request.getObject1());
                }
                else if (request.getStr1().equals("getResCheck")){
                    boolean ok = dataBase.getResCheck(request.getStr2());
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("addRestaurant")){
                    dataBase.addRestaurant((Restaurants) request.getObject1());
                }
                else if (request.getStr1().equals("getAllRestaurants")){
                    ArrayList<Restaurants> ok = dataBase.getAllRestaurants();
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("addTable")){
                    dataBase.addTable((Restaurant_table) request.getObject1());
                }
                else if (request.getStr1().equals("getTableCheck")){
                    boolean ok = dataBase.getTableCheck(request.getStr2(), request.getStr3());
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("getAllTables")){
                    ArrayList<Restaurant_table> ok = dataBase.getAllTables(request.getStr2());
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("getAllTablesOnlyName")){
                    ArrayList<String> ok = dataBase.getAllTablesOnlyName(request.getStr2());
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("removeTable")){
                    dataBase.removeTable((Restaurant_table) request.getObject1());
                }
                else if (request.getStr1().equals("removeRestaurant")){
                    dataBase.removeRestaurant(request.getStr2());
                }
                else if (request.getStr1().equals("deleteResPart1")){
                    dataBase.deleteResPart1(request.getStr2());
                }
                else if (request.getStr1().equals("deleteResPart2")){
                    dataBase.deleteResPart2(request.getStr2());
                }
                else if (request.getStr1().equals("deleteResPart3")){
                    dataBase.deleteResPart3(request.getStr2());
                }
                else if (request.getStr1().equals("getAllFoodsInThisRes")){
                    ArrayList<Food> ok = dataBase.getAllFoodsInThisRes(request.getStr2());
                    outputStream.writeObject(ok);
                }else if (request.getStr1().equals("getAllFoodsInThisResOnlyName")){
                    ArrayList<String> ok = dataBase.getAllFoodsInThisResOnlyName(request.getStr2());
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("FoodResCheck")){
                    boolean ok = dataBase.FoodResCheck(request.getStr2(), request.getStr3());
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("addFood")){
                    dataBase.addFood((Food) request.getObject1());
                }
                else if (request.getStr1().equals("FoodAllCheck")){
                    boolean ok = dataBase.FoodAllCheck(request.getStr2());
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("removeFoods")){
                    dataBase.removeFoods(request.getStr2());
                }
                else if (request.getStr1().equals("removeFoodsFromRes")){
                    dataBase.removeFoodsFromRes(request.getStr2(), request.getStr3());
                }
                else if (request.getStr1().equals("GetAllBookingTables")){
                    ArrayList<BookingTables> ok = dataBase.GetAllBookingTables();
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("GetAllFoodDelivery")){
                    ArrayList<FoodDelivery> ok = dataBase.GetAllFoodDelivery();
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("addBookingTable")){
                    dataBase.addBookingTable((BookingTables) request.getObject1());
                }
                else if (request.getStr1().equals("addFoodDelivery")){
                    dataBase.addFoodDelivery((FoodDelivery) request.getObject1());
                }
                else if (request.getStr1().equals("removeBookingTable")){
                    dataBase.removeBookingTable((BookingTables) request.getObject1());
                }
                else if (request.getStr1().equals("removeFoodDelivery")){
                    dataBase.removeFoodDelivery((FoodDelivery) request.getObject1());
                }
                else if (request.getStr1().equals("GetAllFoodName")){
                    String[] ok = dataBase.GetAllFoodName();
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("GetAllFoodDeliveryThisUser")){
                    ArrayList<FoodDelivery> ok = dataBase.GetAllFoodDeliveryThisUser(request.getStr2());
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("GetAllBookingTablesThisUser")){
                    ArrayList<BookingTables> ok = dataBase.GetAllBookingTablesThisUser(request.getStr2());
                    outputStream.writeObject(ok);
                }
                else if (request.getStr1().equals("getAllFood")){
                    ArrayList<Food> ok = dataBase.getAllFood();
                    outputStream.writeObject(ok);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
