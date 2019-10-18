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
 * @author 1styrGroupC
 */
public class CourseInterface {

    // input or output
    public static InputOutput io = new InputOutput();
    public static Statement stmt;

    //retrieveAccount Method
    public void retrieveCourse() {
        int sel = Integer.valueOf(io.ask("\n\t[1]Retrieve Course By ID\n\t[2]Retrieve All Course\n"));
        if (sel == 1) {
            try {
                Connection conn = getConnection();
                stmt = conn.createStatement();
                int accId = Integer.valueOf(io.ask("Id of Course to be Retrieve"));
                String sql = "SELECT * FROM tblcourses WHERE id = " + accId;
                ResultSet rs = stmt.executeQuery(sql);
                io.print("\t[Retrieving Course]");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int accountID = rs.getInt("accountID");
                    String title = rs.getString("title");
                    String schedule = rs.getString("schedule");
                    int unit = rs.getInt("unit");
                    System.out.println(id + "\t" + accountID + "\t" + title + "\t" + unit + "\t" + schedule);
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
                String sql = "SELECT * FROM tblcourses";
                ResultSet rs = stmt.executeQuery(sql);
                io.print("\t[Retrieving Course]");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int accountID = rs.getInt("accountID");
                    String title = rs.getString("title");
                    String schedule = rs.getString("schedule");
                    int unit = rs.getInt("unit");
                    System.out.println(id + "\t" + accountID + "\t" + title + "\t" + unit + "\t" + schedule);
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

    //add Sched
    public void addCourse(int accID) throws Exception {
        String title, schedule;
        int unit;
        io.print("Creating Schedule to DB");
        while (true) {
            title = io.ask("Course Title");
            try {
                isString(title);
                break;
            } catch (ValidatorException e) {
                System.err.println(e);
            }
        }

        while (true) {
            unit = Integer.valueOf(io.ask("Number of Units"));
            try {
                isNumber(unit);
                break;
            } catch (ValidatorException e) {
                System.err.println(e);
            }
        }

        while (true) {
            schedule = io.ask("Schedule");
            try {
                isString(schedule);
                break;
            } catch (ValidatorException e) {
                System.err.println(e);
            }
        }

        try {
            int acc_ID = accID;
            Connection conn = getConnection();
            stmt = conn.createStatement();
            String sql = "INSERT INTO tblcourses (accountID, title, unit, schedule) VALUES ";
            sql += "('" + acc_ID + "', '" + title + "', '" + unit + "', '" + schedule + "')";
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
    public void updateCourse(int accId) {
        try {
            Connection conn = getConnection();
            stmt = conn.createStatement();
//            int accId = Integer.valueOf(io.ask("Account ID of Course to be Update"));
            io.print("Updating Course Information..,");
            String title, schedule;
            int unit;
            io.print("Creating Schedule to DB");
            while (true) {
                title = io.ask("New Course Title");
                try {
                    isString(title);
                    break;
                } catch (ValidatorException e) {
                    System.err.println(e);
                }
            }

            while (true) {
                unit = Integer.valueOf(io.ask("Number of Units"));
                try {
                    isNumber(unit);
                    break;
                } catch (ValidatorException e) {
                    System.err.println(e);
                }
            }

            while (true) {
                schedule = io.ask("Schedule");
                try {
                    isString(schedule);
                    break;
                } catch (ValidatorException e) {
                    System.err.println(e);
                }
            }

            String perInfoUpdate = "UPDATE `tblperinfo` SET `title`='" + title + "',`unit`= '" + unit + "',`schedule`= '" + schedule + "' WHERE `accountID`= " + accId;
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
    public void deleteCourse(int accId) {
        try {
            Connection conn = getConnection();
            stmt = conn.createStatement();
//            int accId = Integer.valueOf(io.ask("Account ID of Course to be Remove"));
            String perInfoDel = "DELETE FROM `tblcouses` WHERE accountID = " + accId;
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


