/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_3;

/**
 *
 * @author gigantech_sd2023
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class perInfo {

    private String name;
    private String lastname;
    private int age;
    private int id;

    public perInfo() {
    }

    public perInfo(int id) {
        this.id = id;
    }

    public perInfo(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void register(int id, int accID) {
        this.id = id;
        Scanner scan = new Scanner(System.in);
        try {

            File register = new File("register.txt"/*,true*/);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(register, true))) {
                System.out.print("Enter Your Firstname: ");
                String fname = scan.next();

                while (!check(fname)) {
                    System.out.print("Invalid Name!!!\nPlease Enter new Name: ");
                    fname = scan.next();
                }
                
                System.out.print("Enter Your Lastname: ");
                String lname = scan.next();

                while (!check(lname)) {
                    System.out.print("Invalid Lastname!!!\nPlease Enter new Lastname: ");
                    lname = scan.next();
                }
                
                System.out.print("Enter Your Age: ");
                String age1 = scan.next();
                
                while (!checkInt(age1)) {
                    System.out.print("Invalid Input!!!\nPlease Enter your age: ");
                    age1 = scan.next();
                }

                bw.write(this.id + "\t" + accID + "\t" + fname + "\t" + lname + "\t" + age1);
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
