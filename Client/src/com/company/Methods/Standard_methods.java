package com.company.Methods;

import java.util.ArrayList;

public interface Standard_methods {
    abstract public ArrayList<String> getUserHandle();
    abstract public String UsersListTextArea();
    abstract public String RestaurantListTextArea();
    abstract public String TablesRestaurantList(String s);
    abstract public ArrayList<String> GetRestaurantName();
    abstract public String ResFoodList(String s);
    abstract public String AllFoods();
    abstract public String getListAllOrder();
    abstract public String getUserOrders(String handle);
}
