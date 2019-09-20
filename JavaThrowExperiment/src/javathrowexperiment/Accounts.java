/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javathrowexperiment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.util.Objects.hash;
import java.util.Scanner;

/**
 *
 * @author morrejo_sd2023
 */
public class Accounts {

    Scanner input = new Scanner(System.in);
    private String username;
    private String password;
    private String confirm;
    private int account_id = 1;
    FileOutputStream fileOutputStreamAccount;
    FileOutputStream fileOutputStreamPersonal;
    FileOutputStream fileOutputStreamCourses;

    Accounts() throws FileNotFoundException, IOException {
        fileOutputStreamAccount = new FileOutputStream("Accounts.txt");
        fileOutputStreamPersonal = new FileOutputStream("Accounts_Personal_Information.txt");
        fileOutputStreamCourses = new FileOutputStream("Courses.txt");
        String strAccount = "ID" + "\t\t" + "Username" + "\t\t" + "Password";
        String strPersonal = "ID" + "\t\t" + "Account_ID" + "\t\t" + "First Name" + "\t\t" + "Last Name" + "\t\t" + "Age";
        String strCourses = "ID" + "\t\t" + "Account_ID" + "\t\t" + "Title" + "\t\t" + "Units" + "Schedule";

        try {
            byte[] strToBytesAccount = strAccount.getBytes();
            fileOutputStreamAccount.write(strToBytesAccount);
            byte[] strToBytesPersonal = strPersonal.getBytes();
            fileOutputStreamPersonal.write(strToBytesPersonal);
            byte[] strToBytesCourses = strCourses.getBytes();
            fileOutputStreamCourses.write(strToBytesCourses);
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

    void addUsername() throws IOException {
        System.out.print("Enter username : ");
        username = input.next();
    }

    void addPassword() throws IOException, PasswordException {
        while (true) {
            try {
                System.out.print("Enter password : ");
                password = input.next();
                if (password.length() >= 8) {
                    break;
                } else {
                    throw new PasswordException("Password too short.");
                }
            } catch (PasswordException ex) {
                System.out.println("Password too short.");
            }
        }
        while (true) {
            try {
                System.out.print("Re-enter password : ");
                confirm = input.next();
                if (confirm == null ? password == null : confirm.equals(password)) {
                    break;
                } else {
                    throw new PasswordException("Password mismatch.");
                }
            } catch (PasswordException ex) {
                System.out.println("Password mismatch.");
            }
        }
    }

    public void save()
            throws IOException {
        String str = "\r\n" + Integer.toString(account_id) + "\t\t" + username + "\t\t" + hash(password.toCharArray());

        try {
            byte[] strToBytes = str.getBytes();
            fileOutputStreamAccount.write(strToBytes);
            ++account_id;
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }

    }

}

