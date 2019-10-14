/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb;

import java.sql.*;
import static javadb.ConfigDB.*;
import static javadb.ValidatorException.*;

/**
 *
 * @author 2ndyrGroupC
 */
public class PerInfoInterface {

    // input or output
    public static InputOutput io = new InputOutput();
    public static Statement stmt;

    //get Last ID in account table
    public int getLastId() throws Exception {
        int lastid = 0;
        Connection conn = getConnection();
        stmt = conn.createStatement();
        String sql = "SELECT max(id) FROM tblaccounts";
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            lastid = rs.getInt(1);
        } else {
            io.print("Not Found!");
        }
        System.out.println(lastid);
        rs.close();
        stmt.close();
        conn.close();
        return lastid;
    }

    //retrieve perInfo
    public void retrievePerInfo() throws Exception {
        try {
            Connection conn = getConnection();
            stmt = conn.createStatement();
            int accId = Integer.valueOf(io.ask("Id of Personal Information to be Retrieve"));
            String sql = "SELECT * FROM tblperinfo WHERE id = " + accId;
            ResultSet rs = stmt.executeQuery(sql);
            io.print("\t[Retrieving Account]");
            while (rs.next()) {
                int id = rs.getInt("id");
                int accountID = rs.getInt("accountID");
                String fname = rs.getString("firstname");
                String lname = rs.getString("lastname");
                int age = rs.getInt("age");
                System.out.println(id + "\t" + accountID + "\t" + fname + "\t" + lname + "\t" + age);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //add PerInfo
    public void addPerInfo() throws Exception {
        String fname, lname;
        int age;
        io.print("Creating Personal Information to DB");
        while (true) {
            fname = io.ask("Firstname");
            try {
                isString(fname);
                break;
            } catch (ValidatorException e) {
                System.err.println(e);
            }
        }
        while (true) {
            lname = io.ask("Lastname");
            try {
                isString(lname);
                break;
            } catch (ValidatorException e) {
                System.err.println(e);
            }
        }
        while (true) {
            age = Integer.valueOf(io.ask("Age"));
            try {
                isNumber(age);
                break;
            } catch (ValidatorException e) {
                System.err.println(e);
            }
        }

        try {
            int acc_ID = getLastId();
            Connection conn = getConnection();
            stmt = conn.createStatement();
            String sql = "INSERT INTO tblperinfo (accountID, firstname, lastname, age) VALUES ";
            sql += "('" + acc_ID + "', '" + fname + "', '" + lname + "', '" + age + "')";
            System.out.println(sql);
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
    }

    public static Connection getConnection() throws Exception {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

}
