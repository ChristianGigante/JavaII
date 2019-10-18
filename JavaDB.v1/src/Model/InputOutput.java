/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Scanner;

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

    public int menuOption(String label) {
        print("\t" + label + "\n[1] Account\n[2] Personal Information\n[3] Schedule\n[4] Back");
        sel = ask("Choice");
        return Integer.valueOf(sel);
    }

    public int menuOptionCreatePerInfo() {
        print("\tOptional\n[1] Add Personal Information\n[2] Leave");
        sel = ask("Choice");
        return Integer.valueOf(sel);
    }
    
    
    public int menuOptionCreateSched() {
        print("\tOptional\n[1] Add Schedule\n[2] Leave");
        sel = ask("Choice");
        return Integer.valueOf(sel);
    }

}