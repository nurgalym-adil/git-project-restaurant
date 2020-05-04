package com.company;

import com.company.JFrame.LogInPage;

import java.net.Socket;

public class Client {
    public static Socket socket;
    public static DataBaseInterface dataBase;

    public static void main(String[] args) {
        try{
            socket = new Socket("127.0.0.1", 2000);
            dataBase = new DataBase();

            LogInPage login = new LogInPage();
            login.setVisible(true);

        }catch (Exception e){
            System.out.println("Client disconnected");
        }
    }
}
