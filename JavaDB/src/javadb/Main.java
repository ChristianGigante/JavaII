/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb;

/**
 *
 * @author 2ndyrGroupC
 */
public class Main {

//
//    // JDBC driver name and database URL
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost/test";
//
//    //  Database credentials
//    static final String USER = "";
//    static final String PASS = "";
//
//    public static void main(String[] args) {
//        Connection conn = null;
//        Statement stmt = null;
//        try {
//            //STEP 2: Register JDBC driver
//            Class.forName("com.mysql.jdbc.Driver");
//
//            //STEP 3: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            System.out.println("Connected!");
//            //STEP 4: Execute a query
//            System.out.println("Creating statement...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT id, username, password FROM Chan";
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String username = rs.getString("username");
//                String password = rs.getString("password");
//                //display values
//                System.out.printf("ID%dUname%spwd%s ",id,username,password);
//
//            }
//            //STEP 6: Clean-up environment
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch (SQLException se) {
//            //Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            //Handle errors for Class.forName
//            e.printStackTrace();
//        } finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException se2) {
//            }// nothing we can do
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }//end finally try
//        }//end try
//
//        System.out.println("Goodbye!");
//
//    }
}
