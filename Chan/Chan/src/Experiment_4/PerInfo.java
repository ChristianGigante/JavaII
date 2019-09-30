/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Objects.hash;

/**
 *
 * @author 2ndyrGroupC
 */
public class PerInfo {

    //attributes
    private int id;
    private int accId;
    private String fName;
    private String lName;
    private int age;

    //constructors
    public PerInfo() {
    }

    public PerInfo(int id) {
        this.id = id;
    }

    public PerInfo(int id, String fName, String lName, int age) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    //getters&setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //toString
    @Override
    public String toString() {
        return "PerInfo{" + "id=" + id + ", firstname=" + fName + ", lastname=" + lName + ", age=" + age + '}';
    }

    //ownMethods
    public void register(int id, int accID) {
        InputOutput io = new InputOutput();
        String fname = io.ask("Your Firstname");
        while (!check(fname)) {
            fname = io.ask("Invalid First Name!!!\nNew First Name");
        }
        String lname = io.ask("Your Lastname");
        while (!check(lname)) {
            lname = io.ask("Invalid Last Name!!!\nNew Last Name");
        }
        String age1 = io.ask("Your Age");
        while (!checkInt(age1)) {
            age1 = io.ask("Invalid Age!!!\nYour Age");
        }
        this.setId(id);
        this.setAccId(accID);
        this.setfName(fname);
        this.setlName(lname);
        this.setAge(Integer.valueOf(age1));
    }

    public void savePerInfo() {
        try {
            File register = new File("register.txt"/*,true*/);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(register, true))) {
                bw.write(this.id + "\t" + this.accId + "\t" + this.fName + "\t" + this.lName + "\t" + this.age);
                bw.newLine();
                bw.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public boolean checkInt(String age) {
        String rule = "\\d+";
        return age.matches(rule);
    }

    public boolean check(String username) {
        String rule = "^[a-zA-Z ]*$";
        return username.matches(rule);
    }
    

}
