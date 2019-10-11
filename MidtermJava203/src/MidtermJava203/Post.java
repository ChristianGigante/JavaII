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
public class Post {

    // input or output
    public static InputOutput io = new InputOutput();
    public static Connection conn;
    public static Statement stmt;
    public static int id;

    public void retrievePost() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM tblpostss";
            ResultSet rs = stmt.executeQuery(sql);
            io.print("\t[Retrieving Posts]");
            while (rs.next()) {
                String username = rs.getString("username");
                String text = rs.getString("post");
                String date = rs.getString("date");
                System.out.println("\n\tPosted By: " + username + "\n\t" + text + "\n\tPosted On: " + date + "\n");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        io.print("\t[Done!]");
    }

    //addAccount Method
    public void addPost(String uname) {
        String post, date;
        io.print("Creating to DB");

        post = io.ask("Description");

        date = io.ask("Date");

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "INSERT INTO tblpostss (username, post, date) VALUES ";
            sql += "('" + uname + "', '" + post + "', '" + date + "')";
            //sql += "('" + username + "', '" + hash(password.toCharArray()) + "')";
//            System.out.println(sql);
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
        System.out.println("Done!");
    }

    //updateAccount Method
    public void updatePost(String uname) {
        io.print("Updating to DB");
        try {
            Class.forName(JDBC_DRIVER);
            io.print("Updating Post..,");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            int accId = Integer.valueOf(io.ask("Id of Post to be Update"));
            String newPost = io.ask("New Post");
            String newDate = io.ask("New Date");
            String PostUpdate = "UPDATE `tblpostss` SET `post`= '" + newPost + "',`date`= '" + newDate + "' WHERE `id`= " + accId;
            stmt.executeUpdate(PostUpdate);
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
        io.print("Done!");
    }

    //deleteAccount Method
    public void deletePost() {
        try {
            Class.forName(JDBC_DRIVER);
            io.print("Deleting Post..,");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            int Id = Integer.valueOf(io.ask("Id of Post to be Remove"));
            String postUpdate = "DELETE FROM `tblpostss` WHERE id = " + Id;
            stmt.executeUpdate(postUpdate);
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
        io.print("Done!");
    }

}
