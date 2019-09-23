package javalogin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author erimja_sd2023
 */
public class JavaLogin {

    Scanner input = new Scanner(System.in);
    static int id = 1;
    
    public void User() {
        try {
            File file = new File("Z:\\Java2\\JavaLogin" +  File.separator + "Accounts.txt");//File destination
            BufferedReader br = new BufferedReader(new FileReader(file));//use to read data from file
             while (br.readLine() != null) { // read data every line
                 id++;
               }
            System.out.print("Username: ");
            String username = input.next();
            System.out.print("Password: ");
            String password = input.next();

            try {
                while (password.length() < 8) {
                    System.err.println("Please enter a password which is equal or above 8 characters!");
                    System.out.print("Password: ");
                    password = input.next();
                }
                System.out.print("Confirm Password: ");
                String password1 = input.next();
                if (password.equals(password1)) {
                    FileWriter fWriter = new FileWriter("Accounts.txt", true);
                    try (PrintWriter writer = new PrintWriter(fWriter)) {

                        writer.println(id + "\t" + username + "\t" + password);

                    }

                    System.err.println("Your account  has been saved.");

                } else {
                    System.out.println("Please enter again");
                    System.out.print("Password: ");
                    password = input.next();
                    System.err.println("Your account  has been saved.");

                }

            } catch (Exception e) {
                throw new Exception("Password must have 8 characters!");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void AboutMe() {
        try {

            System.out.print("Firstname: ");
            String fname = input.next();
            System.out.print("Lastname: ");
            String lname = input.next();
            try {
                System.out.print("Age: ");
                int age = input.nextInt();

                FileWriter fWriter = new FileWriter("Information.txt", true);
                try (PrintWriter writer = new PrintWriter(fWriter)) {

                    writer.println(id + "\t" + fname + "\t" + lname + "\t" + age);

                }
            } catch (ArithmeticException e) {
                System.out.println("Must be a number!");

            }

            System.err.println("Your Personal information has been saved.");

        } catch (Exception e) {
            System.err.println("Your age must be a number!");

        }

    }

    public void Schedule() {
        try {

            System.out.print("Course: ");
            String course = input.next();
            System.out.print("Subject: ");
            String subject = input.next();
            try {
                System.out.print("Schedule: ");
                String sched = input.next();

                FileWriter fWriter = new FileWriter("Schedule.txt", true);
                try (PrintWriter writer = new PrintWriter(fWriter)) {

                    writer.println(id + "\t" + course + "\t" + subject + "\t" + sched);

                }
            } catch (ArithmeticException e) {
                System.out.println("Must be a number!");

            }

            System.err.println("Your course has been saved.");

        } catch (Exception e) {
            System.err.println("Your age must be a number!");

        }
    }

    public static void main(String[] args) {
        Scanner write = new Scanner(System.in);
        JavaLogin sample = new JavaLogin();
        boolean x = true;
        while (x == true) {
            sample.User();
            sample.AboutMe();
            sample.Schedule();
            System.out.println("Thank you  for entering your credentials");
            break;
        }

    }

}
