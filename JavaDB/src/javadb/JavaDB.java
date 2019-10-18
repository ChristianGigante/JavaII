/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb;

//import java.sql.*;
import static javadb.ValidatorException.*;

/**
 *
 * @author 2ndyrGroupC
 */
public class JavaDB {

    //input or output
    public static InputOutput io = new InputOutput();

    public static int val;

    public static int accID;
    public static int temp;

    public static int askId() {
        String acc_id;
        while (true) {
            acc_id = io.ask("Account ID");
            try {
                isNumber(acc_id);
                break;
            } catch (ValidatorException e) {
                System.err.println(e);
            }
        }
        return Integer.valueOf(acc_id);
    }

    //main
    public static void main(String[] args) throws Exception {
        //configureJDBC
        ConfigDB configDB = new ConfigDB();
        configDB.connectDB();

        //account interface
        AccountInterface acc = new AccountInterface();

        //perInfo interface
        PerInfoInterface perInfo = new PerInfoInterface();

        //schedule interface
        CourseInterface course = new CourseInterface();

        int sel = Integer.valueOf(io.menuCrud());

        while (sel != 5) {
            switch (sel) {
                case 1: //create
                    val = io.menuOption("Create");
                    switch (val) {
                        case 1: //addAccount
                            int id = acc.addAccount();
                            val = io.menuOptionCreatePerInfo();
                            switch (val) {
                                case 1:
                                    perInfo.addPerInfo(id);
                                    break;
                                case 2:
                                    io.print("Leave the Personal Information as BLANK");
                                    break;
                                default:
                                    io.print("INVALID INPUT!");
                                    break;
                            }
                            val = io.menuOptionCreateSched();
                            switch (val) {
                                case 1:
                                    //sched goes here
                                    course.addCourse(id);
                                    break;
                                case 2:
                                    io.print("Leave the Schedule as BLANK");
                                    break;
                                default:
                                    io.print("INVALID INPUT!");
                                    break;
                            }
                            break;
                        case 2: //addPerInfo
                            //ask id
                            accID = askId();
                            temp = acc.getLastId();
                            if (accID > temp) {
                                io.print("Account ID does not Exist!");
                            } else {
                                perInfo.addPerInfo(accID);
                            }
                            break;
                        case 3: //addSched
                            //ask id
                            accID = askId();
                            temp = acc.getLastId();
                            if (accID > temp) {
                                io.print("Account ID does not Exist!");
                            } else {
                                course.addCourse(accID);
                            }
                            break;
                        case 4: //Back
                            break;
                        default:
                            io.print("INVALID INPUT!");
                            break;
                    }

                    break;
                case 2: //retrieve
                    val = io.menuOption("Retrieve");
                    switch (val) {
                        case 1: //RetrieveAccount
                            acc.retrieveAccount();
                            break;
                        case 2: //RetrievePerInfo
                            perInfo.retrievePerInfo();
                            break;
                        case 3: //RetrieveSched
                            course.retrieveCourse();
                            break;
                        case 4: //Back
                            break;
                        default:
                            io.print("INVALID INPUT!");
                            break;
                    }
                    break;
                case 3: //update
                    val = io.menuOption("Update");
                    switch (val) {
                        case 1: //UpdateAccount
                            //ask id
                            accID = askId();
                            temp = acc.getLastId();
                            if (accID > temp) {
                                io.print("Account ID does not Exist!");
                            } else {
                                acc.updateAccount(accID);
                            }
//                            acc.updateAccount();
                            break;
                        case 2: //UpdatePerInfo
                            //ask id
                            accID = askId();
                            temp = acc.getLastId();
                            if (accID > temp) {
                                io.print("Account ID does not Exist!");
                            } else {
                                perInfo.updatePerInfo(accID);
                            }
//                            perInfo.updatePerInfo();
                            break;
                        case 3: //UpdateSched
                            accID = askId();
                            temp = acc.getLastId();
                            if (accID > temp) {
                                io.print("Account ID does not Exist!");
                            } else {
                                course.updateCourse(accID);
                            }
//                            course.updateCourse();
                            break;
                        case 4: //Back
                            break;
                        default:
                            io.print("INVALID INPUT!");
                            break;
                    }

                    break;
                case 4: //delete
                    val = io.menuOption("Delete");
                    switch (val) {
                        case 1: //DeleteAccount
                            //ask id
                            accID = askId();
                            temp = acc.getLastId();
                            if (accID > temp) {
                                io.print("Account ID does not Exist!");
                            } else {
                                acc.deleteAccount(accID);
                            }
//                            acc.deleteAccount();
                            break;
                        case 2: //DeletePerInfo
                            //ask id
                            accID = askId();
                            temp = acc.getLastId();
                            if (accID > temp) {
                                io.print("Account ID does not Exist!");
                            } else {
                                perInfo.deletePerInfo(accID);
                            }
//                            perInfo.deletePerInfo();
                            break;
                        case 3: //DeleteSched
                            //ask id
                            accID = askId();
                            temp = acc.getLastId();
                            if (accID > temp) {
                                io.print("Account ID does not Exist!");
                            } else {
                                course.deleteCourse(accID);
                            }
//                            course.deleteCourse();
                            break;
                        case 4: //Back
                            break;
                        default:
                            io.print("INVALID INPUT!");
                            break;
                    }
                    break;
                default:
                    io.print("INVALID INPUT!");
                    break;
            }
            sel = Integer.valueOf(io.menuCrud());
        }
        io.print("out");

    }

}
