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

        
        while(Integer.valueOf(io.menuCrud()) != 5){
            io.print("in");
        }
        io.print("out");
        
        
    }
}
