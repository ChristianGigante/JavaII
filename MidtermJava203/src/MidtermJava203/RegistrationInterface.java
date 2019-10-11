/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MidtermJava203;

import java.sql.*;
import java.util.ArrayList;
import static java.util.Objects.hash;
import static MidtermJava203.ConfigDB.*;
import static MidtermJava203.ValidatorException.*;

/**
 *
 * @author gigantech_sd2023
 */
public class RegistrationInterface {

    // input or output
    public static InputOutput io = new InputOutput();
    public static Connection conn;
    public static Statement stmt;
    public static String username, password, confirm;

    //register Method
    public Registration register() {
        io.print("Creating to DB");
        while (true) {
            username = io.ask("Username");
            try {
                isString(username);
                break;
            } catch (ValidatorException e) {
                System.err.println(e);
            }
        }
        while (true) {
            password = io.ask("Password");
            try {
                validatePassword(password);
                break;
            } catch (ValidatorException e) {
                System.err.println(e);
            }
        }

        while (true) {
            confirm = io.ask("Confirm Password");
            try {
                if (password.equals(confirm)) {
                    break;
                } else {
                    throw new ValidatorException("Password mismatch.");
                }
            } catch (ValidatorException ex) {
                System.err.println(ex);
            }
        }
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "INSERT INTO tblaccounts (username, password) VALUES ";
            sql += "('" + username + "', '" + password + "')";
            //sql += "('" + username + "', '" + hash(password.toCharArray()) + "')";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println("Done!");
        return (new Registration(this.username, this.password));
    }

}
