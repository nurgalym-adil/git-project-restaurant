package com.company.JFrame;

import com.company.Client;
import com.company.Entity.Restaurant_table;
import com.company.Entity.Restaurants;
import com.company.Methods.methods_admin;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Update_Res_Tables extends JFrame {
//    private DataBaseInterface dataBase = new DataBase();
    private methods_admin adMethod = new methods_admin();
    private JLabel labelTypeTitle = new JLabel("Update");
    private JLabel labelResName = new JLabel("Restaurant name:");
    private JComboBox comboBoxResNames = new JComboBox();
    private JButton buttonGo = new JButton("Go");
    private JLabel labelResNameUpdate = new JLabel("Name:");
    private JLabel labelResRating = new JLabel("Rating");
    private JTextField textFieldUpdateNameRes = new JTextField();
    private JTextField textFieldUpdateRatingRes = new JTextField();
    private JButton buttonUpdate = new JButton("Update");

    private JLabel labelTypeTextForTable = new JLabel("Table");
    private JLabel labelDeleteTableName = new JLabel("Delete table:");
    private JButton buttonDeleteTable = new JButton("Delete");
    private JTextField textFieldTableName = new JTextField();
    private JLabel labelMesTable = new JLabel("");


    private JTextArea textAreaForInfo = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textAreaForInfo);


    public Update_Res_Tables(){
        setTitle("Restaurant");
        labelTypeTextForTable.setFont(new Font("Serif", Font.BOLD, 17));
        labelTypeTitle.setFont(new Font("Serif", Font.BOLD, 20));
        textAreaForInfo.setBorder(new TitledBorder(new EtchedBorder(), "Table list"));
        textAreaForInfo.setEditable(false);
        setLayout(null);
        setBounds(200, 50, 1100, 700);

        add(scrollPane);
        scrollPane.setBounds(450, 20, 600, 620);
        ArrayList<Restaurants>restaurants = Client.dataBase.getAllRestaurants();
        comboBoxResNames.setModel(new DefaultComboBoxModel(adMethod.GetRestaurantName().toArray()));
        add(labelTypeTitle);
        labelTypeTitle.setBounds(30, 20, 200, 25);
        add(labelResName);
        labelResName.setBounds(30, 60, 120, 20);
        add(comboBoxResNames);
        comboBoxResNames.setBounds(150, 60, 200, 20);
        add(buttonGo);
        buttonGo.setBounds(360, 60, 80, 20);
        buttonGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Restaurants restaurant = restaurants.get(comboBoxResNames.getSelectedIndex());
                textAreaForInfo.setText(adMethod.TablesRestaurantList(restaurant.getName()));
                add(labelResNameUpdate);
                labelResNameUpdate.setBounds(30, 100, 60, 20);
                add(textFieldUpdateNameRes);
                textFieldUpdateNameRes.setEditable(false);
                textFieldUpdateNameRes.setBounds(110, 100, 200, 20);
                textFieldUpdateNameRes.setText(restaurant.getName());
                add(labelResRating);
                labelResRating.setBounds(30, 130, 60, 20);
                add(textFieldUpdateRatingRes);
                textFieldUpdateRatingRes.setBounds(110, 130, 200, 20);
                textFieldUpdateRatingRes.setText(restaurant.getRating());
                add(buttonUpdate);
                buttonUpdate.setBounds(320, 130, 100, 20);
                add(labelTypeTextForTable);
                labelTypeTextForTable.setBounds(30, 165, 100, 20);
                add(labelDeleteTableName);
                labelDeleteTableName.setBounds(30, 195, 80, 20);
                add(textFieldTableName);
                textFieldTableName.setBounds(110, 195, 200, 20);
                add(buttonDeleteTable);
                buttonDeleteTable.setBounds(320, 195, 100, 20);
                add(labelMesTable);
                labelMesTable.setBounds(30, 225, 400, 20);
                labelMesTable.setVisible(false);
                buttonDeleteTable.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        if(textFieldTableName.getText().length() == 0) return;
                        if(!Client.dataBase.getTableCheck(textFieldTableName.getText(), restaurant.getName())){
                            labelMesTable.setText("There is no such table in this restaurant.");
                        }
                        else{
                            Client.dataBase.removeTable(new Restaurant_table(restaurant.getName(), "null",
                                    textFieldTableName.getText()));
                            labelMesTable.setText("Table removed from this restaurant.");
                            textAreaForInfo.setText(adMethod.TablesRestaurantList(restaurant.getName()));
                        }
                        labelMesTable.setVisible(true);
                        textFieldTableName.setText("");
                    }
                });
            }
        });

    }
}
