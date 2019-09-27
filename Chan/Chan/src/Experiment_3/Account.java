/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.util.Objects.hash;

/**
 *
 * @author gigantech_sd2023
 */
public class Account {

    //attributes
    private String username;
    private String password;
    private int id;
    private int accID = 992019 + id;

    //constructors
    public Account() {
        try {
            this.id = id();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //gettersAndSetters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    //toString()
    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", id=" + id + '}';
    }

    //ownMethods
    //validation
    public boolean checkUsername(String username) {
        String rule = "^[a-zA-Z ]*$";
        return username.matches(rule);
    }

    public boolean checkPassword(String password) {
        return password.length() >= 8;
    }

    public boolean matchPassword(String password, String newpassword) {
        return password.equals(newpassword);
    }

    public final int id() throws FileNotFoundException, IOException {
        BufferedReader reader;

        reader = new BufferedReader(new FileReader("login.txt"));
        String line = reader.readLine();
        while (line != null) {
            if (line.length() != 0) {
                ++id;
                ++accID;
            }
            line = reader.readLine();
        }
        reader.close();
        return id;
    }

    //logInAccount
    public void loginAccount() {
        InputOutput inOut = new InputOutput();
        try {
            File out = new File("login.txt"/*,true*/);
            try (BufferedWriter fr = new BufferedWriter(new FileWriter(out, true))) {
                String usern = inOut.ask("Username");
                while (!checkUsername(usern)) {
                    inOut.print("Invalid Username!!!");
                    usern = inOut.ask("Username");
                }
                String passw = inOut.ask("Password");
                while (!checkPassword(passw)) {
                    inOut.print("Invalid Password!!!\nIt should be at least 8 characters..");
                    passw = inOut.ask("Again the Password");
                }
                String newpassw = inOut.ask("Match Password");
                while (!matchPassword(passw, newpassw)) {
                    inOut.print("Password did not match!!!");
                    newpassw = inOut.ask("Match Password");
                }
                fr.write(getAccID() + "\t" + usern + "\t" + hash(newpassw.toCharArray()));
                fr.newLine();
                fr.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
