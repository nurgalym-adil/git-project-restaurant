package com.company.JFrame;

import com.company.Client;
import com.company.Entity.BookingTables;
import com.company.Entity.FoodDelivery;
import com.company.Methods.methods_admin;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Create_Order extends JFrame {
//    private DataBaseInterface dataBase = new DataBase();
    private methods_admin adMethod = new methods_admin();
    private JLabel labelTypeTitle = new JLabel("Order");
    private JLabel labelTypeTitle1 = new JLabel("Booking tables");
    private JLabel labelTypeTitle2 = new JLabel("Food delivery");

    private JLabel labelResName = new JLabel("Restaurant:");
    private JLabel labelUserName = new JLabel("User handle:");
    private JLabel labelFoodName = new JLabel("Food:");
    private JLabel labelTableName = new JLabel("Table:");
    private JLabel labelMusic = new JLabel("Music");
    private JLabel labelDriver = new JLabel("Driver");
    private JLabel labelParking = new JLabel("Parking");
    private JComboBox comboBoxResName = new JComboBox();
    private JComboBox comboBoxFoodName = new JComboBox();
    private JComboBox comboBoxTableName = new JComboBox();
    private JTextField textFieldUser = new JTextField();
    private JCheckBox checkBoxMusic = new JCheckBox();
    private JCheckBox checkBoxDriver = new JCheckBox();
    private JCheckBox checkBoxParking = new JCheckBox();
    private JButton buttonSubmit = new JButton("Add");
    private JLabel labelMes = new JLabel("");

    private JLabel labelFoodNameSecond = new JLabel("Food:");
    private JLabel labelUserNameSecond = new JLabel("User handle:");
    private JLabel labelAddress = new JLabel("Address:");
    private JTextField textFieldFoodName = new JTextField();
    private JTextField textFieldUserNameSecond = new JTextField();
    private JTextField textFieldAddress = new JTextField();
    private JButton buttonSubmitSecond = new JButton("Add");
    private JLabel labelMesSecond = new JLabel("");

    private JTextArea textAreaInfo = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textAreaInfo);

    public Create_Order(){
        setTitle("Order");
        setLayout(null);
        setBounds(200, 50, 1100, 700);
        textAreaInfo.setText(adMethod.getListAllOrder());
        textAreaInfo.setEditable(false);
        textAreaInfo.setBorder(new TitledBorder(new EtchedBorder(), "Order list"));
        labelTypeTitle.setFont(new Font("Serif", Font.BOLD, 20));
        labelTypeTitle1.setFont(new Font("Serif", Font.BOLD, 17));
        labelTypeTitle2.setFont(new Font("Serif", Font.BOLD, 17));
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
        add(scrollPane);
        scrollPane.setBounds(450, 20, 600, 620);
        add(labelTypeTitle);
        labelTypeTitle.setBounds(30, 10, 200, 25);
        add(labelTypeTitle1);
        labelTypeTitle1.setBounds(30, 40, 200, 20);
        add(labelResName);
        labelResName.setBounds(30, 70, 100, 20);
        add(comboBoxResName);
        comboBoxResName.setBounds(140, 70, 200, 20);
        add(labelTableName);
        labelTableName.setBounds(30, 100, 100, 20);
        add(comboBoxTableName);
        comboBoxTableName.setBounds(140, 100, 200, 20);
        add(labelFoodName);
        labelFoodName.setBounds(30, 130, 100, 20);
        add(comboBoxFoodName);
        comboBoxFoodName.setBounds(140, 130, 200, 20);
        add(labelUserName);
        labelUserName.setBounds(30, 160, 100, 20);
        add(textFieldUser);
        textFieldUser.setBounds(140, 160, 200, 20);
        add(labelMusic);
        labelMusic.setBounds(30, 190, 50, 20);
        add(checkBoxMusic);
        checkBoxMusic.setBounds(80, 190, 20, 20);
        add(labelDriver);
        labelDriver.setBounds(110, 190, 50, 20);
        add(checkBoxDriver);
        checkBoxDriver.setBounds(160, 190, 20, 20);
        add(labelParking);
        labelParking.setBounds(190, 190, 50, 20);
        add(checkBoxParking);
        checkBoxParking.setBounds(250, 190, 20, 20);
        add(buttonSubmit);
        buttonSubmit.setBounds(280, 190, 100, 20);
        add(labelMes);
        labelMes.setVisible(false);
        labelMes.setBounds(30, 220, 400, 20);
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldUser.getText().length() == 0) return;
                if(!Client.dataBase.getUserHandle(textFieldUser.getText())){
                    labelMes.setText("This user does not exist.");
                }
                else {
                    String ms = (checkBoxMusic.isSelected() ? "Yes" : "No"), dr = (checkBoxDriver.isSelected() ? "Yes" : "No"),
                            pr = (checkBoxParking.isSelected() ? "Yes" : "No");
                    Client.dataBase.addBookingTable(new BookingTables(
                            comboBoxResName.getSelectedItem().toString(), textFieldUser.getText(),
                            comboBoxFoodName.getSelectedItem().toString(), comboBoxTableName.getSelectedItem().toString(),
                            dr, ms, pr));
                    labelMes.setText("An order has been added.");
                    textFieldUser.setText("");
                    textAreaInfo.setText("");
                    textAreaInfo.setText(adMethod.getListAllOrder());
                }
                labelMes.setVisible(true);
            }
        });

        add(labelTypeTitle2);
        labelTypeTitle2.setBounds(30, 260, 200, 20);
        add(labelFoodNameSecond);
        labelFoodNameSecond.setBounds(30, 290, 100, 20);
        add(textFieldFoodName);
        textFieldFoodName.setBounds(140, 290, 200, 20);
        add(labelUserNameSecond);
        labelUserNameSecond.setBounds(30, 320, 100, 20);
        add(textFieldUserNameSecond);
        textFieldUserNameSecond.setBounds(140, 320, 200, 20);
        add(labelAddress);
        labelAddress.setBounds(30, 350, 100, 20);
        add(textFieldAddress);
        textFieldAddress.setBounds(140, 350, 200, 20);
        add(buttonSubmitSecond);
        buttonSubmitSecond.setBounds(280, 380, 100, 20);
        add(labelMesSecond);
        labelMesSecond.setBounds(30, 410, 400, 20);
        buttonSubmitSecond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldUserNameSecond.getText().length() == 0 ||
                        textFieldAddress.getText().length() == 0 ||
                        textFieldFoodName.getText().length() == 0
                ) return;
                if(!Client.dataBase.getUserHandle(textFieldUserNameSecond.getText())) {
                    labelMesSecond.setText("This user does not exist.");
                    textFieldUserNameSecond.setText("");
                }
                else if(!Client.dataBase.FoodAllCheck(textFieldFoodName.getText())){
                    labelMesSecond.setText("No such food.");
                    textFieldFoodName.setText("");
                }
                else{
                    Client.dataBase.addFoodDelivery(new FoodDelivery(textFieldFoodName.getText(),
                            textFieldUserNameSecond.getText(), textFieldAddress.getText()));
                    textFieldFoodName.setText("");
                    textFieldAddress.setText("");
                    textFieldUserNameSecond.setText("");
                    textAreaInfo.setText("");
                    textAreaInfo.setText(adMethod.getListAllOrder());
                    labelMesSecond.setText("Order added.");
                }
                labelMesSecond.setVisible(true);
            }
        });
    }
}
