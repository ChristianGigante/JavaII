/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb;

import java.sql.*;
import static java.util.Objects.hash;
import static javadb.ConfigDB.*;
import static javadb.ValidatorException.*;

/**
 *
 * @author 2ndyrGroupC
 */
public class AccountInterface {

    // input or output
    public static InputOutput io = new InputOutput();
    public static Connection conn;
    public static Statement stmt;
    public static int id;

    //methods
    public void retrieveAccount() {

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM tblaccounts";
            ResultSet rs = stmt.executeQuery(sql);
            io.print("\t[Retrieving Account/s]");
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(id + "\t" + username + "\t" + password + "\t");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\t[Done!]");
    }

    public void addAccount() {
        String username, password, confirm;
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
            confirm = io.ask("Match Password");
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
            System.out.println(sql);
            stmt.executeUpdate(sql);
            ++id;
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println("Saved!");
    }

    public void updateAccount() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            io.print("Updating Account..,");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            int accId = Integer.valueOf(io.ask("Id of Account to be Update"));
            String newUsername = io.ask("New Username");
            String newPassword = io.ask("New Password");
            String accountUpdate = "UPDATE `tblaccounts` SET `username`='" + newUsername + "',`password`= '" + newPassword + "' WHERE `id`= " + accId;
            stmt.executeUpdate(accountUpdate);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println(se);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                System.out.println(se2);
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                System.out.println(se);
            }//end finally try
        }//end try
        io.print("Account Updated!");
    }
}
