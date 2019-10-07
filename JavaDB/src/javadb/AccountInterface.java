/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb;
import java.sql.*;
import static javadb.ConfigDB.*;
/**
 *
 * @author 2ndyrGroupC
 */
public class AccountInterface {
    // input or output
    public static InputOutput io = new InputOutput();
    
    //methods
    public void retrieveAccount(){
        Connection conn;
        Statement stmt;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "SELECT * FROM account";
            ResultSet rs = stmt.executeQuery(sql);

            io.print("\tRetrieve Account/s");
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(id + "\t" + username + "\t" + password + "\t");
            }
//            STEP 6: Clean-up environment
            rs.close();
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
    
}
