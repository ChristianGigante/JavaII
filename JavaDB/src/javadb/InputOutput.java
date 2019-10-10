package javadb;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2ndyrGroupC
 */
public class InputOutput {

    public Scanner scanner = new Scanner(System.in);

    public static String sel;
    
    public String ask(String label) {
        System.out.print("\nInput " + label + " : ");
        return scanner.next();
    }

    public void print(String label) {
        System.out.println(label);
    }

    public String menuCrud() {
        print("\tMenu\n[1] Create\n[2] Retrieve\n[3] Update\n[4] Delete\n[5] Exit");
        sel = ask("Choice");
        return sel;
    }
    
    public int menuOption(String label){
        print("\t" + label +"\n[1] Account\n[2] Personal Information\n[3] Schedule\n[4] Back");
        sel = ask("Choice");
        return Integer.valueOf(sel);
    }
    
    
    
    
    
}