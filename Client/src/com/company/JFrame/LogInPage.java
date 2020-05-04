package com.company.JFrame;

import com.company.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class LogInPage extends JFrame{
//    private DataBaseInterface dataBase = new DataBase();
    public JLabel labelTypeTitle = new JLabel("Log In to ProjectANK");
    public JLabel labelName = new JLabel("Your handle:");
    public JLabel labelPass = new JLabel("Your password:");
    public JTextField textFieldHandle = new JTextField();
    public JPasswordField passwordField = new JPasswordField();
    public JButton buttonLog = new JButton("LogIn");
    public JButton buttonReg = new JButton("Register");
    public JLabel labelMes = new JLabel("");

    public LogInPage(){
        setBounds(200, 50, 1100, 700);
        setLayout(null);
        setTitle("Log in to the platform");
        setLayout(null);
        labelTypeTitle.setFont(new Font("Serif", Font.BOLD, 17));
        add(labelTypeTitle);
        labelTypeTitle.setBounds(450, 90, 250, 20);
        add(labelName);
        labelName.setBounds(380, 130, 100, 20);
        add(textFieldHandle);
        textFieldHandle.setBounds(490, 130, 200, 20);
        add(labelPass);
        labelPass.setBounds(380, 160, 100,20);
        add(passwordField);
        passwordField.setBounds(490, 160, 200, 20);
        add(buttonReg);
        buttonReg.setBounds(380, 200, 150, 20);
        add(buttonLog);
        buttonLog.setBounds(540, 200, 150, 22);
        add(labelMes);
        labelMes.setBounds(380, 240, 300, 22);
        buttonLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldHandle.getText().length() == 0 ||
                passwordField.getText().length() == 0) return;
                if(!Client.dataBase.getUserHandle(textFieldHandle.getText())){
                    labelMes.setText("Unregistered handles");
                    textFieldHandle.setText("");
                    passwordField.setText("");
                    return;
                }
                if(!Client.dataBase.CheckTheLogIn(textFieldHandle.getText(), passwordField.getText())){
                    labelMes.setText("Wrong password");
                    passwordField.setText("");
                    return;
                }
                String userNameByteCode = textFieldHandle.getText();
                try{
                    ObjectOutputStream objectInputStream = new ObjectOutputStream(new FileOutputStream("transferData.type"));
                    objectInputStream.writeObject(userNameByteCode);
                    objectInputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                MainPage mainPage = new MainPage();
                mainPage.setVisible(true);
                setVisible(false);
            }
        });
        buttonReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Register_form register_form = new Register_form();
                register_form.setVisible(true);
            }
        });
    }
}
