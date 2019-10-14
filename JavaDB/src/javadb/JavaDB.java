/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb;

//import java.sql.*;

/**
 *
 * @author 2ndyrGroupC
 */
public class JavaDB {
    
    
    //input or output
    public static InputOutput io = new InputOutput();

    public static int val;

    //main
    public static void main(String[] args) throws Exception {
        //configureJDBC
        ConfigDB configDB = new ConfigDB();
        configDB.connectDB();

        //account interface
        AccountInterface acc = new AccountInterface();

        //perInfo interface
        PerInfoInterface perInfo = new PerInfoInterface();

        int sel = Integer.valueOf(io.menuCrud());

        while (sel != 5) {
            switch (sel) {
                case 1: //create
                    val = io.menuOption("Create");
                    switch (val) {
                        case 1: //addAccount
                            acc.addAccount();
                            break;
                        case 2: //addPerInfo
                            perInfo.addPerInfo();
                            break;
                        case 3: //addSched
                            io.print("sched");
                            break;
                        case 4: //Back
                            break;
                        default:
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
                            io.print("sched");
                            break;
                        case 4: //Back
                            break;
                        default:
                            break;
                    }
                    break;
                case 3: //update
                    val = io.menuOption("Update");
                    acc.updateAccount();
                    break;
                case 4: //delete
                    val = io.menuOption("Delete");
                    acc.deleteAccount();
                    break;
                default:
                    break;
            }
            sel = Integer.valueOf(io.menuCrud());
        }
        io.print("out");

    }
 
}
