package com.company.JFrame;

import com.company.Client;
import com.company.Entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register_form extends JFrame {
//    private DataBaseInterface dataBase = new DataBase();
    private JLabel labelTypeTitle = new JLabel("Register");
    private JLabel labelUserName = new JLabel("Name:");
    private JLabel labelUserSurname = new JLabel("Surname:");
    private JLabel labelUserHandle = new JLabel("Handle:");
    private JLabel labelUserPass = new JLabel("Password");
    private JLabel labelUserPassRe = new JLabel("Confirm password:");
    private JLabel labelPhone = new JLabel("Phone number:");
    private JLabel labelMes = new JLabel("");

    private JButton buttonSub = new JButton("Register");
    private JTextField textFieldName = new JTextField();
    private JTextField textFieldSurname = new JTextField();
    private JTextField textFieldHandle = new JTextField();
    private JTextField textFieldPhone = new JTextField();
    private JTextField textFieldPass = new JTextField();
    private JTextField textFieldPassRe = new JTextField();

    public Register_form(){
        setBounds(200, 50, 1100, 700);
        setLayout(null);
        setTitle("Register form");
        add(labelTypeTitle);
        labelTypeTitle.setFont(new Font("Serif", Font.BOLD, 17));
        labelTypeTitle.setBounds(520, 50, 200, 25);
        add(labelUserName);
        labelUserName.setBounds(380, 90, 100, 20);
        add(textFieldName);
        textFieldName.setBounds(500, 90, 200, 20);
        add(labelUserSurname);
        labelUserSurname.setBounds(380, 120, 100, 20);
        add(textFieldSurname);
        textFieldSurname.setBounds(500, 120, 200, 20);
        add(labelUserHandle);
        labelUserHandle.setBounds(380, 150, 100, 20);
        add(textFieldHandle);
        textFieldHandle.setBounds(500, 150, 200, 20);
        add(labelPhone);
        labelPhone.setBounds(380, 180, 100, 20);
        add(textFieldPhone);
        textFieldPhone.setBounds(500, 180, 200, 20);
        add(labelUserPass);
        labelUserPass.setBounds(380, 210, 100, 20);
        add(textFieldPass);
        textFieldPass.setBounds(500, 210, 200, 20);
        add(labelUserPassRe);
        labelUserPassRe.setBounds(380, 240, 110, 20);
        add(textFieldPassRe);
        textFieldPassRe.setBounds(500, 240, 200, 20);
        add(buttonSub);
        buttonSub.setBounds(550, 285, 150, 22);
        add(labelMes);
        labelMes.setBounds(380, 320, 500, 20);

        buttonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldName.getText().length() == 0 ||
                        textFieldSurname.getText().length() == 0 ||
                        textFieldHandle.getText().length() == 0 ||
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
                if(Client.dataBase.getUserHandle(textFieldHandle.getText())){
                    labelMes.setText("Form mistakes... User with this handle already exists.");
                    textFieldPass.setText("");
                    textFieldPassRe.setText("");
                    textFieldHandle.setText("");
                    return;
                }
                if(Client.dataBase.getUserPhone(textFieldPhone.getText())){
                    labelMes.setText("Form mistakes... User with this phone number already exists.");
                    textFieldPass.setText("");
                    textFieldPassRe.setText("");
                    textFieldPhone.setText("");
                    return;
                }
                Client.dataBase.addUser(new User(textFieldName.getText(), textFieldSurname.getText(),
                        textFieldHandle.getText(), textFieldPass.getText(), textFieldPhone.getText()));
                labelMes.setText("User is registered!");
                textFieldPass.setText("");
                textFieldPassRe.setText("");
                textFieldPhone.setText("");
                textFieldHandle.setText("");
                textFieldName.setText("");
                textFieldSurname.setText("");
            }
        });
    }
}
