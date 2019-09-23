package loginaccount;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class account {

    private String username;
    private String password;
    private int id = 1;
    private int accID = 18100 + id;

    public account() {
        try {
            this.id = id();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public account(int id) {
        this.id = id;
    }

    public account(String username, String password) {
        this.username = username;
        this.password = password;
    }

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

    public void loginAccount() throws IOException {
        Scanner scan = new Scanner(System.in);
        try {
            File out = new File("login.txt"/*,true*/);
            try (BufferedWriter fr = new BufferedWriter(new FileWriter(out, true))) {
                System.out.print("Enter username: ");
                String usern = scan.next();

                while (!checkUsername(usern)) {
                    System.out.print("Invalid Username!!!\nPlease Enter new Username: ");
                    usern = scan.next();
                }
                
                System.out.print("Enter Password: ");
                String passw = scan.next();

                while (!checkPassword(passw)) {
                    System.out.println("Invalid Password!!! It should be at least 8 characters..");
                    System.out.print("Please enter new password: ");
                    passw = scan.next();
                }
                
                System.out.print("Confirm Password: ");
                String newpassw = scan.next();

                while (!matchPassword(passw, newpassw)) {
                    System.out.print("Password did not match!!!\n Please confirm password: ");
                    newpassw = scan.next();
                }
                fr.write(accID + "\t" + usern + "\t" + passw);
                fr.newLine();
                fr.close();
            }

        } catch (IOException e) {
            System.out.println(e);
        }

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

}
