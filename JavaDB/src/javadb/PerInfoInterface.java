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

    

    //retrieveAccount Method
    public void retrievePerInfo() {
        int sel = Integer.valueOf(io.ask("\n\t[1]Retrieve Personal Information By ID\n\t[2]Retrieve All Personal Information\n"));
        if (sel == 1) {
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
            io.print("DONE!");
        } else if (sel == 2) {
            try {
                Connection conn = getConnection();
                stmt = conn.createStatement();
                String sql = "SELECT * FROM tblperinfo";
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
            io.print("DONE!");
        }
    }

    //add PerInfo
    public void addPerInfo(int accID) throws Exception {
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
            int acc_ID = accID;
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

    //update PerInfo
    public void updatePerInfo() {
        try {
            Connection conn = getConnection();
            stmt = conn.createStatement();
            int accId = Integer.valueOf(io.ask("Account ID of Personal Information to be Update"));
            String fname, lname;
            int age;
            io.print("Updating Personal Information..,");
            while (true) {
                fname = io.ask("New Firstname");
                try {
                    isString(fname);
                    break;
                } catch (ValidatorException e) {
                    System.err.println(e);
                }
            }
            while (true) {
                lname = io.ask("New Lastname");
                try {
                    isString(lname);
                    break;
                } catch (ValidatorException e) {
                    System.err.println(e);
                }
            }
            while (true) {
                age = Integer.valueOf(io.ask("New Age"));
                try {
                    isNumber(age);
                    break;
                } catch (ValidatorException e) {
                    System.err.println(e);
                }
            }
            String perInfoUpdate = "UPDATE `tblperinfo` SET `firstname`='" + fname + "',`lastname`= '" + lname + "',`age`= '" + age + "' WHERE `accountID`= " + accId;
            stmt.executeUpdate(perInfoUpdate);
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
            //end finally try
        }//end try
        io.print("Done!");
    }

    //deletePerInfo Method
    public void deletePerInfo() {
        try {
            Connection conn = getConnection();
            stmt = conn.createStatement();
            int accId = Integer.valueOf(io.ask("Account ID of Personal Information to be Remove"));
            String perInfoDel = "DELETE FROM `tblperinfo` WHERE accountID = " + accId;
            stmt.executeUpdate(perInfoDel);
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
            //end finally try
        }//end try
        io.print("Done!");
    }

    public static Connection getConnection() throws Exception {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

}
