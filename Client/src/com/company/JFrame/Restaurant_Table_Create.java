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

public class Restaurant_Table_Create extends JFrame {
//    private DataBaseInterface dataBase = new DataBase();
    private methods_admin adMethods = new methods_admin();
    // For restaurant
    private JLabel labelTypeTitleCreate = new JLabel("Create a restaurant");
    private JLabel labelResName = new JLabel("Restaurant name:");
    private JLabel labelResRating = new JLabel("Rating:");
    private JLabel labelResMes = new JLabel("");
    private JButton buttonCreateRes = new JButton("Create");
    private JTextField textFieldNameRes = new JTextField();
    private JTextField textFieldRatingRes = new JTextField();
    private JTextArea textAreaTables = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textAreaTables);

    //For Tables
    private JLabel labelTypeTitleTable = new JLabel("Add a table");
    private JLabel labelTableName = new JLabel("Table name:");
    private JTextField textFieldNameTable = new JTextField();
    private JButton buttonAddTable = new JButton("Add");
    private JLabel labelMesAdd = new JLabel("");

    public void TableLabelVisible(boolean ok){
        if(ok){
            labelTypeTitleTable.setVisible(true);
            textFieldNameTable.setVisible(true);
            labelTableName.setVisible(true);
            buttonAddTable.setVisible(true);
            labelMesAdd.setVisible(true);
        }
        else {
            labelTypeTitleTable.setVisible(false);
            textFieldNameTable.setVisible(false);
            labelTableName.setVisible(false);
            buttonAddTable.setVisible(false);
            labelMesAdd.setVisible(false);
        }
    }

    public Restaurant_Table_Create(){
        setTitle("Restaurant");
        labelTypeTitleCreate.setFont(new Font("Serif", Font.BOLD, 20));
        labelTypeTitleTable.setFont(new Font("Serif", Font.BOLD, 20));
        textAreaTables.setBorder(new TitledBorder(new EtchedBorder(), "Table list"));
        textAreaTables.setEditable(false);
        setLayout(null);
        TableLabelVisible(false);
        setBounds(200, 50, 1100, 700);
        add(labelTypeTitleCreate);
        labelTypeTitleCreate.setBounds(30, 20, 200, 25);
        add(labelResName);
        labelResName.setBounds(30, 60, 120, 20);
        add(textFieldNameRes);
        textFieldNameRes.setBounds(150, 60, 200, 20);
        add(labelResRating);
        labelResRating.setBounds(30, 90, 120, 20);
        add(textFieldRatingRes);
        textFieldRatingRes.setBounds(150, 90, 200, 20);
        add(buttonCreateRes);
        buttonCreateRes.setBounds(250, 120, 100, 20);
        add(scrollPane);
        scrollPane.setBounds(450, 20, 600, 620);

        labelResMes.setVisible(false);
        add(labelResMes);
        labelResMes.setBounds(30, 155, 300, 20);
        buttonCreateRes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldNameRes.getText().length() == 0 || textFieldRatingRes.getText().length() == 0) return;
                if(Client.dataBase.getResCheck(textFieldNameRes.getText())){
                    labelResMes.setText("A restaurant with that name already exists.");
                    textFieldNameRes.setText("");
                    labelResMes.setVisible(true);
                    return;
                }

                Client.dataBase.addRestaurant(new Restaurants(textFieldNameRes.getText(), textFieldRatingRes.getText()));
                labelResMes.setText("A restaurant with that name already exists.");
                labelResMes.setText("Restaurant created");
                labelResMes.setVisible(true);
                String s = textFieldNameRes.getText();
                TableLabelVisible(true);
                add(labelTypeTitleTable);
                labelTypeTitleTable.setBounds(30, 195, 200, 25);
                add(labelTableName);
                labelTableName.setBounds(30, 225, 100, 20);
                add(textFieldNameTable);
                textFieldNameTable.setBounds(150, 225, 200, 20);
                add(buttonAddTable);
                buttonAddTable.setBounds(250, 255, 100, 20);
                add(labelMesAdd);
                labelMesAdd.setVisible(false);
                labelMesAdd.setBounds(30, 285, 400, 20);
                buttonAddTable.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        if(textFieldNameTable.getText().length() == 0) return;
                        if(Client.dataBase.getTableCheck(textFieldNameTable.getText(), s)){
                            labelMesAdd.setText("The restaurant already has " + s + " table with the same name.");
                            textFieldNameTable.setText("");
                            labelMesAdd.setVisible(true);
                            return;
                        }
                        else{
                            Client.dataBase.addTable(new Restaurant_table(s, "Is empty", textFieldNameTable.getText()));
                            textFieldNameTable.setText("");
                            labelMesAdd.setText("table has been added");
                            labelMesAdd.setVisible(true);
                            textAreaTables.setText("");
                            textAreaTables.setText(adMethods.TablesRestaurantList(s));
                        }
                    }
                });
            }
        });

    }
}
