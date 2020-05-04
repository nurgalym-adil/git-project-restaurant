package com.company.JFrame;

import com.company.*;
import com.company.Entity.BookingTables;
import com.company.Entity.FoodDelivery;
import com.company.Entity.User;
import com.company.Methods.methods_admin;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class mainAdmin extends JFrame{
//    private DataBaseInterface dataBase = new DataBase();
    private methods_admin methods_admins = new methods_admin();
    private JButton buttonLogOut = new JButton("Log out");

    private JLabel labelTypeTitle = new JLabel("Admin menu");
    private JLabel labelFood = new JLabel("Foods:");
    private JLabel labelRestaurant = new JLabel("Restaurants:");
    private JLabel labelUser = new JLabel("User:");
    private JLabel labelOrder = new JLabel("Order:");

    private JLabel labelMesF = new JLabel("Food management");
    private JButton buttonFoodC = new JButton("Add");
    private JButton buttonFoodD = new JButton("Delete");
    private JButton buttonFoodU = new JButton("Update");
    private JButton buttonFoodL = new JButton("List");

    private JLabel labelMesR = new JLabel("Restaurant management");
    private JButton buttonRestaurantC = new JButton("Add");
    private JButton buttonRestaurantD = new JButton("Delete");
    private JButton buttonRestaurantU = new JButton("Update");
    private JButton buttonRestaurantL = new JButton("List");

    private JLabel labelMesU = new JLabel("User management");
    private JButton buttonUserC = new JButton("Add");
    private JButton buttonUserD = new JButton("Delete");
    private JButton buttonUserU = new JButton("Update");
    private JButton buttonUserL = new JButton("List");

    private JLabel labelMesO = new JLabel("Order management");
    private JButton buttonOrderC = new JButton("Add");
    private JButton buttonOrderD = new JButton("Delete");
    private JButton buttonOrderU = new JButton("Update");
    private JButton buttonOrderL = new JButton("List");

    private JTextArea textAreaList = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textAreaList);
    //update user
    private JComboBox comboBoxUser = new JComboBox();
    private JLabel labelTypeTitleForNew = new JLabel("Update. User handle:");
    private JLabel labelUserName = new JLabel("Name:");
    private JLabel labelUserSurname = new JLabel("Surname:");
    private JLabel labelUserPass = new JLabel("Password");
    private JLabel labelUserPassRe = new JLabel("Confirm password:");
    private JLabel labelPhone = new JLabel("Phone number:");
    private JLabel labelMes = new JLabel("");

    private JButton buttonSub = new JButton("Update");
    private JTextField textFieldName = new JTextField();
    private JTextField textFieldSurname = new JTextField();
    private JTextField textFieldPhone = new JTextField();
    private JTextField textFieldPass = new JTextField();
    private JTextField textFieldPassRe = new JTextField();
    private JButton buttonUpdate = new JButton("go");

    //delete user
    private JLabel labelDeleteUser = new JLabel("Write user to delete:");
    private JTextField textFieldDeleteUser = new JTextField();
    private JButton buttonDelete = new JButton("Delete");
    private JLabel labelMesDelete = new JLabel("User deleted.");

    //delete restaurant
    private JLabel labelDeleteRes = new JLabel("Name restaurant to delete:");
    private JTextField textFieldResDelete = new JTextField();
    private JButton buttonDeleteRes = new JButton("Delete");
    private JLabel labelMesDeleteREs = new JLabel("Restaurant deleted");

    //delete food
    private JLabel labelDeleteFood = new JLabel("Name food to delete:");
    private JTextField textFieldFoodDelete = new JTextField();
    private JButton buttonDeleteFood = new JButton("Delete");
    private JLabel labelMesDeleteFood = new JLabel("Food deleted");

    //delete food from res (update)
    private JComboBox comboBoxResFoodDel = new JComboBox();
    private JButton buttonComboResFoodDel = new JButton("Select");
    private JLabel labelFoodComboDel = new JLabel("Select the restaurant:");
    private JLabel labelDeleteFood1 = new JLabel("Name food to delete:");
    private JTextField textFieldFoodDelete1 = new JTextField();
    private JButton buttonDeleteFood1 = new JButton("Delete");
    private JLabel labelMesDeleteFood1 = new JLabel("Food deleted");

    //delete order
    private JLabel labelOrderType = new JLabel("Choose order type:");
    private JComboBox comboBoxType = new JComboBox();
    private JLabel labelOrderNumber = new JLabel("Write the order number:");
    private JTextField textFieldOrderNum = new JTextField();
    private JButton buttonDeleteOrder = new JButton("Delete");
    private String[] orderTypesForCombo = {"Booking table", "Food delivery"};

    public void DeleteOrderVis(boolean ok){
        if(ok){
            labelOrderType.setVisible(true);
            labelOrderNumber.setVisible(true);
            comboBoxType.setVisible(true);
            textFieldOrderNum.setVisible(true);
            buttonDeleteOrder.setVisible(true);
        }
        else{
            labelOrderType.setVisible(false);
            labelOrderNumber.setVisible(false);
            comboBoxType.setVisible(false);
            textFieldOrderNum.setVisible(false);
            buttonDeleteOrder.setVisible(false);
        }
    }
    public void FoodUpdateLabelsVis(boolean ok){
        if(ok){
            comboBoxResFoodDel.setVisible(true);
            buttonComboResFoodDel.setVisible(true);
            labelFoodComboDel.setVisible(true);
            labelDeleteFood1.setVisible(true);
            textFieldFoodDelete1.setVisible(true);
            buttonDeleteFood1.setVisible(true);
            labelMesDeleteFood1.setVisible(true);
        }
        else{
            labelDeleteFood1.setVisible(false);
            textFieldFoodDelete1.setVisible(false);
            buttonDeleteFood1.setVisible(false);
            labelMesDeleteFood1.setVisible(false);
            comboBoxResFoodDel.setVisible(false);
            buttonComboResFoodDel.setVisible(false);
            labelFoodComboDel.setVisible(false);
        }
    }
    public void FoodDeleteLabelsVis(boolean ok){
        if(ok){
            labelDeleteFood.setVisible(true);
            textFieldFoodDelete.setVisible(true);
            buttonDeleteFood.setVisible(true);
            labelMesDeleteFood.setVisible(true);
        }
        else{
            labelDeleteFood.setVisible(false);
            textFieldFoodDelete.setVisible(false);
            buttonDeleteFood.setVisible(false);
            labelMesDeleteFood.setVisible(false);
        }
    }
    public void LabeslRestairantDelete(boolean ok){
        if(ok){
            labelDeleteRes.setVisible(true);
            textFieldResDelete.setVisible(true);
            buttonDeleteRes.setVisible(true);
            labelMesDeleteREs.setVisible(true);
        }
        else{
            labelDeleteRes.setVisible(false);
            textFieldResDelete.setVisible(false);
            buttonDeleteRes.setVisible(false);
            labelMesDeleteREs.setVisible(false);
        }
    }
    public void LabelsUserDelete(boolean ok){
        if(ok){
            labelDeleteUser.setVisible(true);
            textFieldDeleteUser.setVisible(true);
            buttonDelete.setVisible(true);
            labelMesDelete.setVisible(true);
        }
        else{
            labelDeleteUser.setVisible(false);
            textFieldDeleteUser.setVisible(false);
            buttonDelete.setVisible(false);
            labelMesDelete.setVisible(false);
        }
    }
    public void LabelsUser(boolean ok){
        if(ok){
            buttonUpdate.setVisible(true);
            comboBoxUser.setVisible(true);
            labelTypeTitleForNew.setVisible(true);
            labelUserName.setVisible(true);
            labelUserSurname.setVisible(true);
            labelUserPass.setVisible(true);
            labelUserPassRe.setVisible(true);
            labelPhone.setVisible(true);
            labelMes.setVisible(true);

            buttonSub.setVisible(true);
            textFieldName.setVisible(true);
            textFieldSurname.setVisible(true);
            textFieldPhone.setVisible(true);
            textFieldPass.setVisible(true);
            textFieldPassRe.setVisible(true);
        }
        else {
            buttonUpdate.setVisible(false);
            comboBoxUser.setVisible(false);
            labelTypeTitleForNew.setVisible(false);
            labelUserName.setVisible(false);
            labelUserSurname.setVisible(false);
            labelUserPass.setVisible(false);
            labelUserPassRe.setVisible(false);
            labelPhone.setVisible(false);
            labelMes.setVisible(false);

            buttonSub.setVisible(false);
            textFieldName.setVisible(false);
            textFieldSurname.setVisible(false);
            textFieldPhone.setVisible(false);
            textFieldPass.setVisible(false);
            textFieldPassRe.setVisible(false);
        }
    }

    public mainAdmin(){
        setTitle("Admin page");
        labelTypeTitle.setFont(new Font("Serif", Font.BOLD, 20));
        textAreaList.setEditable(false);
        setBounds(100, 50, 1300, 750);
        setLayout(null);
        add(labelTypeTitle);
        labelTypeTitle.setBounds(40, 10, 150, 30);
        textAreaList.setBorder(new TitledBorder(new EtchedBorder(), "Order list"));

        add(labelMesR);
        labelMesR.setBounds(30, 50, 150, 20);
        add(buttonLogOut);
        buttonLogOut.setBounds(1160, 690, 100, 20);
        add(labelRestaurant);
        labelRestaurant.setBounds(30, 80, 80, 20);
        add(buttonRestaurantC);
        buttonRestaurantC.setBounds(120, 80, 90, 20);
        add(buttonRestaurantU);
        buttonRestaurantU.setBounds(220, 80, 90, 20);
        add(buttonRestaurantD);
        buttonRestaurantD.setBounds(320, 80, 90, 20);
        add(buttonRestaurantL);
        buttonRestaurantL.setBounds(420, 80, 90, 20);

        add(labelMesF);
        labelMesF.setBounds(30, 120,150, 20);
        add(labelFood);
        labelFood.setBounds(30, 150, 80, 20);
        add(buttonFoodC);
        buttonFoodC.setBounds(120, 150, 90, 20);
        add(buttonFoodU);
        buttonFoodU.setBounds(220, 150, 90, 20);
        add(buttonFoodD);
        buttonFoodD.setBounds(320, 150, 90, 20);
        add(buttonFoodL);
        buttonFoodL.setBounds(420, 150, 90, 20);

        add(labelMesO);
        labelMesO.setBounds(30, 190, 150, 20);
        add(labelOrder);
        labelOrder.setBounds(30, 220, 80, 20);
        add(buttonOrderC);
        buttonOrderC.setBounds(120, 220, 90, 20);
        add(buttonOrderD);
        buttonOrderD.setBounds(220, 220, 90, 20);
        add(buttonOrderL);
        buttonOrderL.setBounds(320, 220, 90, 20);

        add(labelMesU);
        labelMesU.setBounds(30, 260, 150, 20);
        add(labelUser);
        labelUser.setBounds(30, 290, 80, 20);
        add(buttonUserC);
        buttonUserC.setBounds(120, 290, 90, 20);
        add(buttonUserU);
        buttonUserU.setBounds(220, 290, 90, 20);
        add(buttonUserD);
        buttonUserD.setBounds(320, 290, 90, 20);
        add(buttonUserL);
        buttonUserL.setBounds(420, 290, 90, 20);

        add(scrollPane);
        scrollPane.setBounds(620, 20, 640, 670);

        buttonUserC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Register_form register_form = new Register_form();
                register_form.setVisible(true);
            }
        });
        buttonUserU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LabelsUser(false);
                LabelsUserDelete(false);
                LabeslRestairantDelete(false);
                FoodDeleteLabelsVis(false);
                DeleteOrderVis(false);
                FoodUpdateLabelsVis(false);

                labelTypeTitleForNew.setVisible(true);
                comboBoxUser.setVisible(true);
                buttonUpdate.setVisible(true);
                add(labelTypeTitleForNew);
                labelTypeTitleForNew.setBounds(30, 330, 140, 20);
                comboBoxUser.setModel(new DefaultComboBoxModel(methods_admins.getUserHandle().toArray()));
                add(comboBoxUser);
                comboBoxUser.setBounds(170, 330, 200, 20);
                add(buttonUpdate);
                buttonUpdate.setBounds(390, 330, 100, 20);
                buttonUpdate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        ArrayList<String>usersHandle = methods_admins.getUserHandle();
                        User user = Client.dataBase.getOneUserWithThisHandle(usersHandle.get(comboBoxUser.getSelectedIndex()));
                        textFieldName.setText(user.getName());
                        textFieldSurname.setText(user.getSurname());
                        textFieldPass.setText(user.getPassword());
                        textFieldPassRe.setText(user.getPassword());
                        textFieldPhone.setText(user.getPhoneNumber());
                        LabelsUser(true);
                        add(labelUserName);
                        labelUserName.setBounds(30, 360, 100, 20);
                        add(textFieldName);
                        textFieldName.setBounds(150, 360, 200, 20);
                        add(labelUserSurname);
                        labelUserSurname.setBounds(30, 390, 100, 20);
                        add(textFieldSurname);
                        textFieldSurname.setBounds(150, 390, 200, 20);
                        add(labelPhone);
                        labelPhone.setBounds(30, 420, 100, 20);
                        add(textFieldPhone);
                        textFieldPhone.setBounds(150, 420, 200, 20);
                        add(labelUserPass);
                        labelUserPass.setBounds(30, 450, 100, 20);
                        add(textFieldPass);
                        textFieldPass.setBounds(150, 450, 200, 20);
                        add(labelUserPassRe);
                        labelUserPassRe.setBounds(30, 480, 110, 20);
                        add(textFieldPassRe);
                        textFieldPassRe.setBounds(150, 480, 200, 20);
                        add(buttonSub);
                        buttonSub.setBounds(200, 505, 150, 23);
                        add(labelMes);
                        labelMes.setBounds(30, 535, 500, 20);
                        buttonSub.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                if(textFieldName.getText().length() == 0 ||
                                        textFieldSurname.getText().length() == 0 ||
                                        textFieldPhone.getText().length() == 0 ||
                                        textFieldPassRe.getText().length() == 0 ||
                                        textFieldPass.getText().length() == 0) return;
                                if(textFieldPass.getText().length() < 8){
                                    labelMes.setText("Form mistakes... Password length should be >= 8.");
                                    textFieldPass.setText("");
                                    textFieldPassRe.setText("");
                                    return;
                                }
                                if(!textFieldPass.getText().equals(textFieldPassRe.getText())){
                                    labelMes.setText("Form mistakes... Password mismatch.");
                                    textFieldPass.setText("");
                                    textFieldPassRe.setText("");
                                    return;
                                }
                                if(Client.dataBase.getUserPhone(textFieldPhone.getText())){
                                    labelMes.setText("Form mistakes... User with this phone number already exists.");
                                    textFieldPass.setText("");
                                    textFieldPassRe.setText("");
                                    textFieldPhone.setText("");
                                    return;
                                }
                                Client.dataBase.upDateUser(new User(textFieldName.getText(), textFieldSurname.getText(),
                                        user.getHandle(), textFieldPass.getText(), textFieldPhone.getText()));
                                labelMes.setText("User data updated!");
                            }
                        });
                    }
                });
            }
        });
        buttonUserD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LabelsUser(false);
                LabelsUserDelete(true);
                LabeslRestairantDelete(false);
                FoodDeleteLabelsVis(false);
                DeleteOrderVis(false);
                FoodUpdateLabelsVis(false);
                add(labelDeleteUser);
                labelDeleteUser.setBounds(30, 330, 130, 20);
                add(textFieldDeleteUser);
                textFieldDeleteUser.setBounds(160, 330, 150, 20);
                add(buttonDelete);
                buttonDelete.setBounds(320, 330, 100, 20);
                labelMesDelete.setVisible(false);
                add(labelMesDelete);
                labelMesDelete.setBounds(30, 360, 300, 20);
                buttonDelete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        if(Client.dataBase.getUserHandle(textFieldDeleteUser.getText())) {
                            Client.dataBase.removeUser(textFieldDeleteUser.getText());
                            textFieldDeleteUser.setText("");
                            labelMesDelete.setText("User deleted");
                            labelMesDelete.setVisible(true);
                        }
                        else{
                            textFieldDeleteUser.setText("");
                            labelMesDelete.setText("Such user does not exist");
                            labelMesDelete.setVisible(true);
                        }
                    }
                });
            }
        });
        buttonUserL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textAreaList.setText("");
                textAreaList.setBorder(new TitledBorder(new EtchedBorder(), ""));
                textAreaList.setBorder(new TitledBorder(new EtchedBorder(), "User list"));
                textAreaList.setText(methods_admins.UsersListTextArea());
            }
        });

        buttonRestaurantL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textAreaList.setText("");
                textAreaList.setBorder(new TitledBorder(new EtchedBorder(), ""));
                textAreaList.setBorder(new TitledBorder(new EtchedBorder(), "Restaurant list"));
                textAreaList.setText(methods_admins.RestaurantListTextArea());
            }
        });
        buttonRestaurantC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Restaurant_Table_Create restaurant_table_create = new Restaurant_Table_Create();
                restaurant_table_create.setVisible(true);
            }
        });
        buttonRestaurantU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Update_Res_Tables update_res_tables = new Update_Res_Tables();
                update_res_tables.setVisible(true);
            }
        });
        buttonRestaurantD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LabelsUser(false);
                LabelsUserDelete(false);
                LabeslRestairantDelete(true);
                DeleteOrderVis(false);
                FoodDeleteLabelsVis(false);
                FoodUpdateLabelsVis(false);
                add(labelDeleteRes);
                labelDeleteRes.setBounds(30, 330, 150, 20);
                add(textFieldResDelete);
                textFieldResDelete.setBounds(190, 330, 200, 20);
                add(buttonDeleteRes);
                buttonDeleteRes.setBounds(400, 330, 100, 20);
                labelMesDeleteREs.setVisible(false);
                add(labelMesDeleteREs);
                labelMesDeleteREs.setBounds(30, 360, 300, 20);
                buttonDeleteRes.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        //getResCheck
                        if(textFieldResDelete.getText().length() == 0) return;
                        if(!Client.dataBase.getResCheck(textFieldResDelete.getText())){
                            labelMesDeleteREs.setText("A restaurant with that name does not exist.");
                        }
                        else{
                            Client.dataBase.removeRestaurant(textFieldResDelete.getText());
                            labelMesDeleteREs.setText("The restaurant has been removed.");
                        }
                        labelMesDeleteREs.setVisible(true);
                        textFieldResDelete.setText("");
                        textAreaList.setText("");
                        textAreaList.setText(methods_admins.RestaurantListTextArea());
                    }
                });
            }
        });

        buttonFoodC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Create_Update_Foods create_update_foods = new Create_Update_Foods();
                create_update_foods.setVisible(true);
            }
        });
        buttonFoodL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textAreaList.setText("");
                textAreaList.setText(methods_admins.AllFoods());
                textAreaList.setBorder(new TitledBorder(new EtchedBorder(), ""));
                textAreaList.setBorder(new TitledBorder(new EtchedBorder(), "Food list"));
            }
        });
        buttonFoodD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LabelsUser(false);
                LabelsUserDelete(false);
                DeleteOrderVis(false);
                LabeslRestairantDelete(false);
                FoodDeleteLabelsVis(true);
                FoodUpdateLabelsVis(false);
                add(labelDeleteFood);
                labelDeleteFood.setBounds(30, 330, 150, 20);
                add(textFieldFoodDelete);
                textFieldFoodDelete.setBounds(190, 330, 200, 20);
                add(buttonDeleteFood);
                buttonDeleteFood.setBounds(400, 330, 100, 20);
                labelMesDeleteFood.setVisible(false);
                add(labelMesDeleteFood);
                labelMesDeleteFood.setBounds(30, 360, 300, 20);
                buttonDeleteFood.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        if(textFieldFoodDelete.getText().length() == 0) return;
                        if(Client.dataBase.FoodAllCheck(textFieldFoodDelete.getText())){
                            Client.dataBase.removeFoods(textFieldFoodDelete.getText());
                            labelMesDeleteFood.setText("Food has been removed at all restaurants.");
                            textFieldFoodDelete.setText("");
                        }
                        else{
                            labelMesDeleteFood.setText("No such food.");
                            textFieldFoodDelete.setText("");
                        }
                        labelMesDeleteFood.setVisible(true);
                    }
                });
            }
        });
        buttonFoodU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LabelsUser(false);
                LabelsUserDelete(false);
                LabeslRestairantDelete(false);
                DeleteOrderVis(false);
                FoodDeleteLabelsVis(false);
                FoodUpdateLabelsVis(true);
                comboBoxResFoodDel.setModel(new DefaultComboBoxModel(methods_admins.GetRestaurantName().toArray()));
                add(labelFoodComboDel);
                labelFoodComboDel.setBounds(30, 330, 140, 20);
                add(comboBoxResFoodDel);
                comboBoxResFoodDel.setBounds(180, 330, 200, 20);
                add(buttonComboResFoodDel);
                buttonComboResFoodDel.setBounds(395, 330, 100, 20);
                buttonComboResFoodDel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        textAreaList.setText("");
                        textAreaList.setText(methods_admins.ResFoodList(comboBoxResFoodDel.getSelectedItem().toString()));
                        textAreaList.setBorder(new TitledBorder(new EtchedBorder(), "Foods "
                                + comboBoxResFoodDel.getSelectedItem().toString()));
                        add(labelDeleteFood1);
                        labelDeleteFood1.setBounds(30, 360, 150, 20);
                        add(textFieldFoodDelete1);
                        textFieldFoodDelete1.setBounds(180, 360, 200, 20);
                        add(buttonDeleteFood1);
                        buttonDeleteFood1.setBounds(395, 360, 100, 20);
                        labelMesDeleteFood1.setVisible(false);
                        add(labelMesDeleteFood1);
                        labelMesDeleteFood1.setBounds(30, 390, 300, 20);
                        buttonDeleteFood1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                if(Client.dataBase.FoodResCheck(comboBoxResFoodDel.getSelectedItem().toString(),
                                textFieldFoodDelete1.getText())){
                                    Client.dataBase.removeFoodsFromRes(textFieldFoodDelete1.getText(),
                                            comboBoxResFoodDel.getSelectedItem().toString());
                                    labelMesDeleteFood1.setText("Food has been removed at this restaurant.");
                                    textFieldFoodDelete1.setText("");
                                    textAreaList.setText("");
                                    textAreaList.setText(methods_admins.ResFoodList(comboBoxResFoodDel.getSelectedItem().toString()));
                                    textAreaList.setBorder(new TitledBorder(new EtchedBorder(), "Foods "
                                            + comboBoxResFoodDel.getSelectedItem().toString()));
                                    labelMesDeleteFood1.setVisible(true);
                                    return;
                                }
                                else{
                                    labelMesDeleteFood1.setText("There is no such food in this restaurant.");
                                    textFieldFoodDelete1.setText("");
                                    labelMesDeleteFood1.setVisible(true);
                                }
                            }
                        });
                    }
                });
            }
        });

        buttonOrderL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textAreaList.setText("");
                textAreaList.setText(methods_admins.getListAllOrder());
                textAreaList.setBorder(new TitledBorder(new EtchedBorder(), ""));
                textAreaList.setBorder(new TitledBorder(new EtchedBorder(), "Order list"));
            }
        });
        buttonOrderD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textAreaList.setText("");
                textAreaList.setText(methods_admins.getListAllOrder());
                textAreaList.setBorder(new TitledBorder(new EtchedBorder(), ""));
                textAreaList.setBorder(new TitledBorder(new EtchedBorder(), "Order list"));
                LabelsUser(false);
                LabelsUserDelete(false);
                LabeslRestairantDelete(false);
                FoodDeleteLabelsVis(false);
                FoodUpdateLabelsVis(false);
                DeleteOrderVis(true);
                comboBoxType.setModel(new DefaultComboBoxModel(orderTypesForCombo));
                add(labelOrderType);
                labelOrderType.setBounds(30, 330, 150, 20);
                add(comboBoxType);
                comboBoxType.setBounds(180, 330, 200, 20);
                add(labelOrderNumber);
                labelOrderNumber.setBounds(30, 360, 150, 20);
                add(textFieldOrderNum);
                textFieldOrderNum.setBounds(180, 360, 200, 20);
                add(buttonDeleteOrder);
                buttonDeleteOrder.setBounds(390, 360, 100,20);
                buttonDeleteOrder.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        ArrayList<BookingTables>bookingTables = Client.dataBase.GetAllBookingTables();
                        ArrayList<FoodDelivery>foodDeliveries = Client.dataBase.GetAllFoodDelivery();
                        if(textFieldOrderNum.getText().length() == 0) return;
                        String pro = textFieldOrderNum.getText();
                        for(int i = 0; i < pro.length(); i++) if(pro.charAt(i) < '0' || pro.charAt(i) > '9') return;
                        int ind = 0;
                        ind = parseInt(textFieldOrderNum.getText()) - 1;
                        if(ind < 0) return;
                        if(comboBoxType.getSelectedIndex() == 0) {
                            if (bookingTables.size() >= ind + 1) {
                                Client.dataBase.removeBookingTable(bookingTables.get(ind));
                                textAreaList.setText("");
                                textAreaList.setText(methods_admins.getListAllOrder());
                            }
                        }
                        else {
                            if(foodDeliveries.size() >= ind + 1) {
                                Client.dataBase.removeFoodDelivery(foodDeliveries.get(ind));
                                textAreaList.setText("");
                                textAreaList.setText(methods_admins.getListAllOrder());
                            }
                        }
                        textFieldOrderNum.setText("");
                    }
                });
            }
        });
        buttonOrderC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Create_Order create_order = new Create_Order();
                create_order.setVisible(true);
            }
        });
    }
}
