package com.company;

import com.company.Entity.*;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DataBase implements DataBaseInterface{

    private Connection connection;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    

    public DataBase(){}

    public void Connect(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/data/config.txt"));
            String driver = bufferedReader.readLine();
            String hostName = bufferedReader.readLine();
            String port = bufferedReader.readLine();
            String DBName = bufferedReader.readLine();
            String parameters = bufferedReader.readLine();
            String username = bufferedReader.readLine();
            String pass=bufferedReader.readLine();
            Class.forName(driver);

            connection = DriverManager.getConnection(hostName + port + "/" + DBName + "?" + parameters, username, pass);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean getUserHandle(String userHandle){
        String surname = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE handle = ?");
            preparedStatement.setString(1, userHandle);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                surname = resultSet.getString("surname");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return surname != null;
    }
    public boolean getUserPhone(String phone){
        String sname = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE phonenumber = ?");
            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                sname = resultSet.getString("surname");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return sname != null;
    }
    public User getOneUserWithThisHandle(String userHandle){
        User user = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE handle = ?");
            preparedStatement.setString(1, userHandle);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new User(resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("handle"),
                        resultSet.getString("password"), resultSet.getString("phonenumber"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
    public ArrayList<User> getAllUser(){
        ArrayList<User>users = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                users.add(new User(resultSet.getString("name"), resultSet.getString("surname"),
                        resultSet.getString("handle"), resultSet.getString("password"), resultSet.getString("phonenumber")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }
    public void upDateUser(User thisUser){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE users SET name=?, surname=?, password=?, phonenumber=? WHERE handle = ?");
            preparedStatement.setString(1, thisUser.getName());
            preparedStatement.setString(2, thisUser.getSurname());
            preparedStatement.setString(3, thisUser.getPassword());
            preparedStatement.setString(4, thisUser.getPhoneNumber());
            preparedStatement.setString(5, thisUser.getHandle());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void removeUser(String thisHandle){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE handle = ?");
            preparedStatement.setString(1, thisHandle);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        removeUserPart1(thisHandle);
        removeUserPart2(thisHandle);
    }
    public void removeUserPart1(String thisHandle){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM fooddelivery WHERE user = ?");
            preparedStatement.setString(1, thisHandle);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void removeUserPart2(String thisHandle){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM bookingtables WHERE user = ?");
            preparedStatement.setString(1, thisHandle);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addUser(User thisUser){
        System.out.println(thisUser.getName() + " " + thisUser.getSurname() + " " + thisUser.getHandle() + " " +
                thisUser.getPassword() + " " + thisUser.getPhoneNumber());
        try{
            PreparedStatement statement = null;
            statement = connection.prepareStatement("INSERT INTO users(name, surname, handle, password, phonenumber)"
                    + "VALUES(?, ?, ?, ?, ?)");
            statement.setString(1, thisUser.getName());
            statement.setString(2, thisUser.getSurname());
            statement.setString(3, thisUser.getHandle());
            statement.setString(4, thisUser.getPassword());
            statement.setString(5, thisUser.getPhoneNumber());

            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean getResCheck(String resName){
        String nameRes = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM therestaurant WHERE restaurantName = ?");
            preparedStatement.setString(1, resName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                nameRes = resultSet.getString("restaurantName");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return nameRes != null;
    }

    public void addRestaurant(Restaurants restaurants){
        System.out.println(restaurants.getName() + " " + restaurants.getRating());
        try{
            PreparedStatement statement = null;
            statement = connection.prepareStatement("INSERT INTO therestaurant(restaurantName, rating)"
                    + "VALUES(?, ?)");
            statement.setString(1, restaurants.getName());
            statement.setString(2, restaurants.getRating());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Restaurants> getAllRestaurants(){
        ArrayList<Restaurants>restaurants = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM therestaurant");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                restaurants.add(new Restaurants(resultSet.getString("restaurantName"), resultSet.getString("rating")));
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return restaurants;
    }
    public void addTable(Restaurant_table table){
        System.out.println(table.getRestaurantName() + " " + table.getData() + " " + table.getTableNum());
        try{
            PreparedStatement statement = null;
            statement = connection.prepareStatement("INSERT INTO restauranttable(restaurantName, data, tablenum)"
                    + "VALUES(?, ?, ?)");
            statement.setString(1, table.getRestaurantName());
            statement.setString(2, table.getData());
            statement.setString(3, table.getTableNum());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean getTableCheck(String tabName, String resName){
        String nameRes = null;
        boolean ok = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM restauranttable WHERE restaurantName = ?");
            preparedStatement.setString(1, resName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                nameRes = resultSet.getString("tablenum");
                if(nameRes.equals(tabName)) ok = true;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }
    public ArrayList<Restaurant_table> getAllTables(String resName){
        ArrayList<Restaurant_table>tables = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM restauranttable WHERE restaurantName = ?");
            preparedStatement.setString(1, resName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                tables.add(new Restaurant_table(resultSet.getString("restaurantName"), resultSet.getString("data"),
                        resultSet.getString("tablenum")));
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return tables;
    }
    public ArrayList<String> getAllTablesOnlyName(String resName){
        ArrayList<String>tables = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM restauranttable WHERE restaurantName = ?");
            preparedStatement.setString(1, resName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                tables.add(resultSet.getString("tablenum"));
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return tables;
    }
    public void removeTable(Restaurant_table table){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM restauranttable WHERE" +
                    " restaurantName = ? and tablenum=?");
            preparedStatement.setString(1, table.getRestaurantName());
            preparedStatement.setString(2, table.getTableNum());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void removeRestaurant(String ResName){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM therestaurant WHERE " +
                    "restaurantName = ?");
            preparedStatement.setString(1, ResName);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        deleteResPart1(ResName);
        deleteResPart2(ResName);
        deleteResPart3(ResName);
    }
    public void deleteResPart1(String ResName){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM food WHERE " +
                    "restaurantName = ?");
            preparedStatement.setString(1, ResName);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteResPart2(String ResName){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM restauranttable WHERE " +
                    "restaurantName = ?");
            preparedStatement.setString(1, ResName);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteResPart3(String ResName){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM bookingtables WHERE " +
                    "restaurantname = ?");
            preparedStatement.setString(1, ResName);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Food> getAllFoodsInThisRes(String resName){
        ArrayList<Food>foods = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM food WHERE restaurantName = ?");
            preparedStatement.setString(1, resName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                foods.add(new Food(resultSet.getString("restaurantName"), resultSet.getString("foodName")));
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return foods;
    }
    public ArrayList<String> getAllFoodsInThisResOnlyName(String resName){
        ArrayList<String>foods = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM food WHERE restaurantName = ?");
            preparedStatement.setString(1, resName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                foods.add(resultSet.getString("foodName"));
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return foods;
    }
    public boolean FoodResCheck(String resName, String FoodName){
        boolean ok = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM food WHERE restaurantName = ?");
            preparedStatement.setString(1, resName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if(resultSet.getString("foodName").equals(FoodName)) ok = true;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }
    public void addFood(Food food){
        System.out.println(food.getRestaurantName() + " " + food.getFoodName());
        try{
            PreparedStatement statement = null;
            statement = connection.prepareStatement("INSERT INTO food(restaurantName, foodName)"
                    + "VALUES(?, ?)");
            statement.setString(1, food.getRestaurantName());
            statement.setString(2, food.getFoodName());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Food> getAllFood(){
        ArrayList<Food>foods = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  food");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                foods.add(new Food(resultSet.getString("restaurantName"), resultSet.getString("foodName")));
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return foods;
    }
    public boolean FoodAllCheck(String FoodName){
        boolean ok = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM food WHERE foodName = ?");
            preparedStatement.setString(1, FoodName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                if(resultSet.getString("foodName").equals(FoodName)) ok = true;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }
    public void removeFoods(String FoodName){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM food WHERE foodName = ?");
            preparedStatement.setString(1, FoodName);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void removeFoodsFromRes(String FoodName, String ResName){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM food WHERE foodName = ? and restaurantName = ?");
            preparedStatement.setString(1, FoodName);
            preparedStatement.setString(2, ResName);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<BookingTables> GetAllBookingTables(){
        ArrayList<BookingTables>order = new ArrayList<>();
        try{
            //restaurantname	user	foodname  restauranttable	driver	music	parking
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bookingtables");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                order.add(new BookingTables(resultSet.getString("restaurantname"), resultSet.getString("user"),
                        resultSet.getString("foodname"),
                        resultSet.getString("restauranttable"), resultSet.getString("driver"),
                        resultSet.getString("music"), resultSet.getString("parking")));
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }
    public ArrayList<FoodDelivery> GetAllFoodDelivery(){
        ArrayList<FoodDelivery>order = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM fooddelivery");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                order.add(new FoodDelivery(resultSet.getString("foodname"), resultSet.getString("user"),
                        resultSet.getString("data")));
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }

    public void addBookingTable(BookingTables order){
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement("INSERT INTO bookingtables(restaurantname, user, foodname, " +
                    "restauranttable, driver, music, parking)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, order.getRestaurantName());
            statement.setString(2, order.getUserName());
            statement.setString(3, order.getFoodName());
            statement.setString(4, order.getRestaurantName());
            statement.setString(5, order.getDriver());
            statement.setString(6, order.getMusic());
            statement.setString(7, order.getParking());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addFoodDelivery(FoodDelivery order){
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement("INSERT INTO fooddelivery(foodname, user, data)"
                    + "VALUES(?, ?, ?)");
            statement.setString(1, order.getFoodName());
            statement.setString(2, order.getUserName());
            statement.setString(3, order.getData());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeBookingTable(BookingTables order){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM bookingtables WHERE " +
                    "restaurantName = ? and user = ? and foodname = ? and restauranttable = ? and " +
                    "driver = ? and music = ? and parking = ?");
            preparedStatement.setString(1, order.getRestaurantName());
            preparedStatement.setString(2, order.getUserName());
            preparedStatement.setString(3, order.getFoodName());
            preparedStatement.setString(4, order.getTableName());
            preparedStatement.setString(5, order.getDriver());
            preparedStatement.setString(6, order.getMusic());
            preparedStatement.setString(7, order.getParking());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void removeFoodDelivery(FoodDelivery order){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM fooddelivery WHERE " +
                    "foodname = ? and user = ? and data = ?");
            preparedStatement.setString(1, order.getFoodName());
            preparedStatement.setString(2, order.getUserName());
            preparedStatement.setString(3, order.getData());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean CheckTheLogIn(String UserHandle, String pss){
        boolean ok = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE handle = ?");
            preparedStatement.setString(1, UserHandle);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                if(resultSet.getString("password").equals(pss)) ok = true;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }
    public String[] GetAllFoodName(){
        Set<String>foods = new HashSet<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM food");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                foods.add(resultSet.getString("foodName"));
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        int t = 0;
        String[] names = new String[foods.size()];
        for(String i : foods){
            names[t] = i;
            t++;
        }
        return names;
    }
    public ArrayList<FoodDelivery> GetAllFoodDeliveryThisUser(String userHandle){
        ArrayList<FoodDelivery>order = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM fooddelivery WHERE user = ?");
            preparedStatement.setString(1, userHandle);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                order.add(new FoodDelivery(resultSet.getString("foodname"), resultSet.getString("user"),
                        resultSet.getString("data")));
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }
    public ArrayList<BookingTables> GetAllBookingTablesThisUser(String userHandle){
        ArrayList<BookingTables>order = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bookingtables WHERE user = ?");
            preparedStatement.setString(1, userHandle);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                order.add(new BookingTables(resultSet.getString("restaurantname"), resultSet.getString("user"),
                        resultSet.getString("foodname"),
                        resultSet.getString("restauranttable"), resultSet.getString("driver"),
                        resultSet.getString("music"), resultSet.getString("parking")));
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }
}
