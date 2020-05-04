package com.company.JFrame;

import com.company.Client;
import com.company.Entity.Food;
import com.company.Entity.Restaurants;
import com.company.Methods.methods_admin;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Create_Update_Foods extends JFrame {
    private methods_admin adMethods = new methods_admin();
//    private DataBaseInterface dataBase = new DataBase();
    private JLabel labelTypeTitle = new JLabel("Food");
    private JTextArea textAreaForInfo = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textAreaForInfo);
    private JComboBox comboBoxResNames = new JComboBox();
    private JLabel labelForCombo = new JLabel("Choose a restaurant:");
    private JButton buttonGo = new JButton("Go");

    //Create the food
    private JLabel labelFoodName = new JLabel("Food name:");
    private JTextField textFieldFoodName = new JTextField();
    private JButton buttonSub = new JButton("Add");
    private JLabel labelMesFoodAdd = new JLabel("");

    public void Food_Labels_Vis(boolean ok){
        if(ok){
            labelFoodName.setVisible(true);
            textFieldFoodName.setVisible(true);
            buttonSub.setVisible(true);
            labelMesFoodAdd.setVisible(true);
        }
        else{
            labelFoodName.setVisible(false);
            textFieldFoodName.setVisible(false);
            buttonSub.setVisible(false);
            labelMesFoodAdd.setVisible(false);
        }
    }

    public Create_Update_Foods(){
        setTitle("Foods");
        setLayout(null);
        setBounds(200, 50, 1100, 700);
        add(scrollPane);
        Food_Labels_Vis(false);
        labelTypeTitle.setFont(new Font("Serif", Font.BOLD, 17));
        textAreaForInfo.setBorder(new TitledBorder(new EtchedBorder(), "Food list"));
        textAreaForInfo.setEditable(false);
        ArrayList<Restaurants>restaurants = Client.dataBase.getAllRestaurants();
        comboBoxResNames.setModel(new DefaultComboBoxModel(adMethods.GetRestaurantName().toArray()));
        add(scrollPane);
        scrollPane.setBounds(450, 20, 600, 620);
        add(labelTypeTitle);
        labelTypeTitle.setBounds(30, 20, 200, 25);
        add(labelForCombo);
        labelForCombo.setBounds(30, 60, 130, 20);
        add(comboBoxResNames);
        comboBoxResNames.setBounds(160, 60, 200, 20);
        add(buttonGo);
        buttonGo.setBounds(370, 60, 70, 20);
        buttonGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Restaurants restaurant = restaurants.get(comboBoxResNames.getSelectedIndex());
                textAreaForInfo.setText("");
                textAreaForInfo.setText(adMethods.ResFoodList(restaurant.getName()));
                Food_Labels_Vis(true);
                add(labelFoodName);
                labelFoodName.setBounds(30, 100, 70, 20);
                add(textFieldFoodName);
                textFieldFoodName.setBounds(110, 100, 200, 20);
                add(buttonSub);
                buttonSub.setBounds(320, 100, 100, 20);
                add(labelMesFoodAdd);
                labelMesFoodAdd.setVisible(false);
                labelMesFoodAdd.setBounds(30, 130, 500, 20);
                buttonSub.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        if(textFieldFoodName.getText().length() == 0) return;
                        if(Client.dataBase.FoodResCheck(restaurant.getName(), textFieldFoodName.getText())){
                            labelMesFoodAdd.setText("Food with the same name already exists in this restaurant.");
                            textFieldFoodName.setText("");
                        }
                        else{
                            Client.dataBase.addFood(new Food(restaurant.getName(), textFieldFoodName.getText()));
                            textFieldFoodName.setText("");
                            labelMesFoodAdd.setText("Food was an addition to this restaurant.");
                            textAreaForInfo.setText("");
                            textAreaForInfo.setText(adMethods.ResFoodList(restaurant.getName()));
                        }
                        labelMesFoodAdd.setVisible(true);
                    }
                });
            }
        });
    }
}
