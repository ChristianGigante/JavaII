/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MidtermJava203;

import java.util.Scanner;

/**
 *
 * @author gigantech_sd2023
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

    public int firstMenu() {
        print("\tMenu\n[1] Register\n[2] Login");
        sel = ask("Choice");
        return Integer.valueOf(sel);
    }

    public int secMenu(String uname) {
        print("\nHi "+ uname +"\n\t[1] Create\n\t[2] Retrieve\n\t[3] Update\n\t[4] Delete\n\t[5] Logout");
        sel = ask("Choice");
        return Integer.valueOf(sel);
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
}
