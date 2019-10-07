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

    //input or output
    public static InputOutput io = new InputOutput();

    //main
    public static void main(String[] args) {
        //configureJDBC
        ConfigDB configDB = new ConfigDB();
        configDB.connectDB();

        //account interface
        AccountInterface acc = new AccountInterface();

        int sel = Integer.valueOf(io.menuCrud());

        while (sel != 5) {
            switch (sel) {
                case 1:
                    acc.addAccount();
                    break;
                case 2:
                    acc.retrieveAccount();
                    break;
                case 3:
                    acc.updateAccount();
                    break;
                case 4:
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
