/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.Statement;

/**
 *
 * @author 2ndyrGroupC
 */
public class CRUD {

    private final InputOutput io = new InputOutput();
    private final ConfigDB conn = new ConfigDB();
    private static Statement stmt;

    public void insertData(String sql) throws Exception {
        conn.getConnection(); //create Connection to DB
        stmt = conn.getConnection().createStatement(); //create query statement to DB
        stmt.executeUpdate(sql); //execute Query
        stmt.close(); //close statement
        conn.getConnection().close(); //close DB connection
        io.print("Done!");
    }

}
