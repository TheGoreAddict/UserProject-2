/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author glassiron
 */
public class User_CRUD {

    public boolean userSignUp(String name, String surename, String userName, String password) {
        boolean didWork = true;

        try {
            File read = new File("userData.txt");
            Scanner myReader = new Scanner(read);

            return didWork;

        } catch (FileNotFoundException ex) {

            try {
                File create = new File("userData.txt");//[i]

                if (create.createNewFile()) {
                    System.out.println("File created: " + create.getName());
                }
            } catch (IOException ex2) {
                System.out.println("input / output error");
            }
            try {
                FileWriter taskAddToFile = new FileWriter("userData.txt", false);
                PrintWriter file = new PrintWriter(taskAddToFile);

                String uInfo = name + "#" + surename + "#" + userName + "#" + password;

                file.println(uInfo);

                file.close();

            } catch (IOException ex2) {
                didWork = false;
            }

        }

        return didWork;
    }

    public boolean userLogIn(String name, String surename, String userName, String password) {
        boolean didWork = true;
        int i = 0;
        int counter = 4;

        String namec = " ";
        String surenamec = " ";
        String userNamec = " ";
        String passwordc = " ";

        try {
            FileReader read = new FileReader("userData.txt");
            Scanner file = new Scanner(read);

            while (i <= counter) {

                String line = file.nextLine();
                String[] details = line.split("#");

                namec = details[0];

                surenamec = details[1];

                userNamec = details[2];

                passwordc = details[3];

                file.close();

            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Have you Signed in yet?");
            didWork = false;
        }

        boolean check = false;
        if (!check) {

            int nam = namec.compareTo(name);
            int sure = surenamec.compareTo(surename);
            int use = userNamec.compareTo(userName);
            int pass = passwordc.compareTo(password);

            if (nam <= 0) {
                check = true;
                JOptionPane.showMessageDialog(null, "Incorrect name");
            }
            if (sure <= 0) {
                JOptionPane.showMessageDialog(null, "Incorrect surename");
                check = true;
            }
            if (use <= 0) {
                JOptionPane.showMessageDialog(null, "Incorrect userName");
                check = true;
            }
            if (pass <= 0) {
                JOptionPane.showMessageDialog(null, "Incorrect passsword");
                check = true;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Something didnt match please check entries");
            didWork = false;
        }
        return didWork;
    }

}
