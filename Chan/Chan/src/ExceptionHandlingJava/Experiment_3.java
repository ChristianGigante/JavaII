/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandlingJava;

import java.io.*;
import java.util.*;
import static java.util.Objects.hash;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gigantech_sd2023
 */
public class Experiment_3 {

    private static Scanner input = new Scanner(System.in);
    private static String username;
    private static String password;
    private static String confirm;

    private static FileOutputStream fileOutputStream;
    private static FileOutputStream fileOutputStreamAccount;
    private static FileOutputStream fileOutputStreamPersonal;
    private static FileOutputStream fileOutputStreamCourses;

    public static void main(String[] args) throws InputOutputException, IOException {
        int account_id = 1;
        while (true) {
            while (true) {
                try {
                    System.out.print("Enter username : ");
                    username = input.nextLine();
                    if (username.length() > 0) {
                        break;
                    } else {
                        throw new InputOutputException("username too short.");
                    }
                } catch (InputOutputException ex) {
                    System.out.println("username too short.");
                }
            }

            while (true) {
                try {
                    System.out.print("Enter password : ");
                    password = input.nextLine();
                    if (password.length() >= 8) {
                        break;
                    } else {
                        throw new InputOutputException("Password too short.");
                    }
                } catch (InputOutputException ex) {
                    System.out.println("Password too short.");
                }
            }

            while (true) {
                try {
                    System.out.print("Re-enter password : ");
                    confirm = input.nextLine();
                    if (confirm == null ? password == null : confirm.equals(password)) {
                        break;
                    } else {
                        throw new InputOutputException("Password mismatch.");
                    }
                } catch (InputOutputException ex) {
                    System.out.println("Password mismatch.");
                }
            }

            String fileName = ("Z:\\Java2\\Chan\\Chan\\src\\Experiment_3\\Accounts.txt");
            try {
                FileWriter fileWriter = new FileWriter(fileName, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(account_id++ + "\t\t" + username + "\t\t" + password + "\n");
                bufferedWriter.newLine();
                bufferedWriter.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");

            }
            System.out.println("end");
        }

    }
}
