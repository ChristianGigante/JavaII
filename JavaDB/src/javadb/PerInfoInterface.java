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
    public static Connection conn;
    public static Statement stmt;

    //get Last ID in account table
    public int getLastId() {
        int lastid = 0;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT LAST_INSERT_ID() FROM tblaccounts";
            ResultSet rs = stmt.executeQuery(sql);
            lastid = rs.getInt("id");
            System.out.println(lastid);
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lastid;
    }
    
    public static void main(String args[]){
        PerInfoInterface p = new PerInfoInterface();
        System.out.println(p.getLastId());
    }

}
