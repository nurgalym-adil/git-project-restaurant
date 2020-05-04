package com.company.JFrame;

import com.company.Client;
import com.company.Entity.BookingTables;
import com.company.Entity.FoodDelivery;
import com.company.Entity.User;
import com.company.Methods.methods_admin;
import com.company.Methods.methods_user;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class MainPage extends JFrame {
//    private DataBaseInterface dataBase = new DataBase();
    private methods_admin adMethod = new methods_admin();
    private methods_user userMethods = new methods_user();
    private JButton buttonLogOut = new JButton("Log Out");
    private JLabel labelUserName = new JLabel();

    private JLabel labelTypeTitle = new JLabel("Welcome to my Restaurant ProjectANK!");
    private JTextArea textAreaMainRec = new JTextArea();
    private  String Wel = "We have created a program in which everyone can choose a restaurant and\n " +
            "reserve a table or order food at home. You can also select the food, that you prefer,\n " +
            "online. Yummy, hot and fresh food will wait you on your table. If you want totally\n " +
            "have fun, we can suggest you the parking place and sober driver function. It will\n " +
            "help you to relax in restaurant and dont worry about pedestrians and yourself. In\n " +
            "delivery you can also leave a comment about your preferences.";
    private JLabel labelOrders = new JLabel("My orders");
    private JTextArea textAreaOrders = new JTextArea();
    private JScrollPane scrollPaneOrders = new JScrollPane(textAreaOrders);

    private JLabel labelTypeTableB = new JLabel("Reserve a table in the restaurant");
    private JLabel labelResName = new JLabel("Restaurant:");
    private JComboBox comboBoxResName = new JComboBox();
    private JLabel labelFoodName = new JLabel("Food:");
    private JComboBox comboBoxFoodName = new JComboBox();
    private JLabel labelTableName = new JLabel("Table:");
    private JComboBox comboBoxTableName = new JComboBox();
    private String hitrost = "                   ";
    private JLabel labelDop = new JLabel("Music:" + hitrost + "Driver:" + hitrost + "Parking:");
    private JCheckBox checkBoxMusic = new JCheckBox();
    private JCheckBox checkBoxDriver = new JCheckBox();
    private JCheckBox checkBoxParking = new JCheckBox();
    private JButton buttonAddBooingTable = new JButton("Book now");

    private JLabel labelTypeTitleD = new JLabel("Order food");
    private JLabel labelFoodDeliveryName = new JLabel("Food:");
    private JComboBox jComboBoxAllFoods = new JComboBox();
    private JLabel labelAddress = new JLabel("Address");
    private JTextField textFieldAddress = new JTextField();
    private JButton buttonAddFoodDelivery = new JButton("To order");

    private JLabel labelTypeTitleCancel = new JLabel("Cancel the order");
    private JLabel labelOrderType = new JLabel("Type of order:");
    private JComboBox comboBoxOrderType = new JComboBox();
    private JLabel labelOderNum = new JLabel("Write the order number:");
    private JTextField textFieldNum = new JTextField();
    private JButton buttonDelete = new JButton("Cancel");

    private JButton buttonAdmin = new JButton("Admin menu");

    private JTextArea line1 = new JTextArea();
    private JTextArea line2 = new JTextArea();
    private User user = new User();

    public void forInformationUser(){
        String userNameByteCode = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("transferData.type"));
            userNameByteCode = (String) objectInputStream.readObject();
            objectInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        boolean ButSet = false;
        user = Client.dataBase.getOneUserWithThisHandle(userNameByteCode);
        String userNameForLabel = user.getName() + " " + user.getSurname();
        labelUserName.setText("");
        labelUserName.setText(userNameForLabel);
        labelUserName.setBounds((1300 - userNameForLabel.length() * 9), 10, (userNameForLabel.length() * 9), 20);
        BufferedReader bufferedReader = null;
        String s = "";
        try {
            bufferedReader = new BufferedReader(new FileReader("Admins.txt"));
            while ((s = bufferedReader.readLine()) != null){
                if(s.equals(user.getHandle())){
                    ButSet = true;
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        buttonAdmin.setVisible(ButSet);
    }
    public MainPage(){
        forInformationUser();
        setTitle("My application");
        setLayout(null);
        setBounds(50, 50, 1420, 800);
        textAreaOrders.setText("");
        textAreaOrders.setText(userMethods.getUserOrders(user.getHandle()));
        labelTypeTitle.setFont(new Font("Serif", Font.BOLD, 23));
        textAreaMainRec.setBorder(new TitledBorder(new EtchedBorder()));
        textAreaMainRec.setFont(new Font("Serif", Font.BOLD, 17));
        labelOrders.setFont(new Font("Serif", Font.BOLD, 17));
        labelTypeTableB.setFont(new Font("Serif", Font.BOLD, 16));
        labelTypeTitleD.setFont(new Font("Serif", Font.BOLD, 16));
        labelTypeTitleCancel.setFont(new Font("Serif", Font.BOLD, 16));
        textAreaOrders.setBorder(new TitledBorder(new EtchedBorder()));
        line1.setBorder(new TitledBorder(new EtchedBorder()));
        line2.setBorder(new TitledBorder(new EtchedBorder()));
        line1.setEditable(false);
        line2.setEditable(false);
        textAreaOrders.setEditable(false);
        textAreaMainRec.setText(Wel);
        textAreaMainRec.setEditable(false);
        add(buttonAdmin);
        buttonAdmin.setBounds(10, 10, 150, 20);
        buttonAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainAdmin mainAdmins = new mainAdmin();
                mainAdmins.setVisible(true);
            }
        });
        add(buttonLogOut);
        add(labelUserName);
        buttonLogOut.setBounds(1310, 10, 80, 20);
        buttonLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LogInPage logInPage = new LogInPage();
                logInPage.setVisible(true);
                setVisible(false);
            }
        });
        add(labelTypeTitle);
        labelTypeTitle.setBounds(40, 40, 500, 30);
        add(textAreaMainRec);
        textAreaMainRec.setBounds(20, 90, 600, 650);
        add(labelOrders);
        labelOrders.setBounds(680, 370, 150, 20);
        add(scrollPaneOrders);
        scrollPaneOrders.setBounds(650, 400, 720, 340);
        add(line1);
        line1.setBounds(650, 350, 720, 2);
        add(line2);
        line2.setBounds(650, 240, 720, 2);
        comboBoxResName.setModel(new DefaultComboBoxModel(adMethod.GetRestaurantName().toArray()));
        comboBoxResName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboBoxFoodName.setModel(new DefaultComboBoxModel(Client.dataBase.getAllFoodsInThisResOnlyName(
                        comboBoxResName.getSelectedItem().toString()).toArray()));
                comboBoxTableName.setModel(new DefaultComboBoxModel(Client.dataBase.getAllTablesOnlyName(
                        comboBoxResName.getSelectedItem().toString()).toArray()));
            }
        });
        add(labelTypeTableB);
        labelTypeTableB.setBounds(680, 60, 230, 20);
        add(labelResName);
        labelResName.setBounds(650, 90, 80, 20);
        add(comboBoxResName);
        comboBoxResName.setBounds(740, 90, 200, 20);
        add(labelFoodName);
        labelFoodName.setBounds(650, 120, 80, 20);
        add(comboBoxFoodName);
        comboBoxFoodName.setBounds(740, 120, 200, 20);
        add(labelTableName);
        labelTableName.setBounds(650, 150, 80, 20);
        add(comboBoxTableName);
        comboBoxTableName.setBounds(740, 150, 200, 20);
        add(labelDop);
        labelDop.setBounds(650, 180, 300, 20);
        add(checkBoxMusic);
        checkBoxMusic.setBounds(690, 180, 20, 20);
        add(checkBoxDriver);
        checkBoxDriver.setBounds(790, 180, 20, 20);
        add(checkBoxParking);
        checkBoxParking.setBounds(900, 180, 20, 20);
        add(buttonAddBooingTable);
        buttonAddBooingTable.setBounds(840, 210, 100, 20);
        buttonAddBooingTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String ms = (checkBoxMusic.isSelected() ? "Yes" : "No"), dr = (checkBoxDriver.isSelected() ? "Yes" : "No"),
                        pr = (checkBoxParking.isSelected() ? "Yes" : "No");
                Client.dataBase.addBookingTable(new BookingTables(
                        comboBoxResName.getSelectedItem().toString(), user.getHandle(),
                        comboBoxFoodName.getSelectedItem().toString(), comboBoxTableName.getSelectedItem().toString(),
                        dr, ms, pr));
                checkBoxMusic.setSelected(false);
                checkBoxDriver.setSelected(false);
                checkBoxParking.setSelected(false);
                textAreaOrders.setText("");
                textAreaOrders.setText(userMethods.getUserOrders(user.getHandle()));
            }
        });

        jComboBoxAllFoods.setModel(new DefaultComboBoxModel(Client.dataBase.GetAllFoodName()));
        add(labelTypeTitleD);
        labelTypeTitleD.setBounds(1125, 60, 100, 20);
        add(labelFoodDeliveryName);
        labelFoodDeliveryName.setBounds(1040, 90, 70, 20);
        add(jComboBoxAllFoods);
        jComboBoxAllFoods.setBounds(1110, 90, 200, 20);
        add(labelAddress);
        labelAddress.setBounds(1040, 120, 70, 20);
        add(textFieldAddress);
        textFieldAddress.setBounds(1110, 120, 200, 20);
        add(buttonAddFoodDelivery);
        buttonAddFoodDelivery.setBounds(1210, 150, 100, 20);
        buttonAddFoodDelivery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldAddress.getText().length() == 0) return;
                Client.dataBase.addFoodDelivery(new FoodDelivery(jComboBoxAllFoods.getSelectedItem().toString(),
                        user.getHandle(), textFieldAddress.getText()));
                textAreaOrders.setText("");
                textAreaOrders.setText(userMethods.getUserOrders(user.getHandle()));
                textFieldAddress.setText("");
            }
        });


        String[] TypesForCombo = {"Booking tables", "Food delivery"};
        comboBoxOrderType.setModel(new DefaultComboBoxModel(TypesForCombo));
        add(labelTypeTitleCancel);
        labelTypeTitleCancel.setBounds(680, 250, 150, 20);
        add(labelOrderType);
        labelOrderType.setBounds(650, 280, 100, 20);
        add(comboBoxOrderType);
        comboBoxOrderType.setBounds(740, 280, 200, 20);
        add(labelOderNum);
        labelOderNum.setBounds(960, 280, 150, 20);
        add(textFieldNum);
        textFieldNum.setBounds(1110, 280, 200, 20);
        add(buttonDelete);
        buttonDelete.setBounds(1210, 310, 100, 20);
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<BookingTables>bookingTables = Client.dataBase.GetAllBookingTablesThisUser(user.getHandle());
                ArrayList<FoodDelivery>foodDeliveries = Client.dataBase.GetAllFoodDeliveryThisUser(user.getHandle());
                if(textFieldNum.getText().length() == 0) return;
                String pro = textFieldNum.getText();
                for(int i = 0; i < pro.length(); i++) if(pro.charAt(i) < '0' || pro.charAt(i) > '9') return;
                int ind = 0;
                ind = parseInt(textFieldNum.getText()) - 1;
                if(ind < 0) return;
                if(comboBoxOrderType.getSelectedIndex() == 0) {
                    if (bookingTables.size() >= ind + 1) {
                        Client.dataBase.removeBookingTable(bookingTables.get(ind));
                        textAreaOrders.setText("");
                        textAreaOrders.setText(userMethods.getUserOrders(user.getHandle()));
                    }
                }
                else {
                    if(foodDeliveries.size() >= ind + 1) {
                        Client.dataBase.removeFoodDelivery(foodDeliveries.get(ind));
                        textAreaOrders.setText("");
                        textAreaOrders.setText(userMethods.getUserOrders(user.getHandle()));
                    }
                }
                textFieldNum.setText("");
             }
        });
    }
}
