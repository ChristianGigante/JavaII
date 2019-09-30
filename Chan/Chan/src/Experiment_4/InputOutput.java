/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_4;

import java.util.Scanner;

/**
 *
 * @author gigantech_sd2023
 */
public class InputOutput {

    public Scanner scanner = new Scanner(System.in);

    public String ask(String label) {
        System.out.print("\nInput " + label + " : ");
        return scanner.next();
    }

    public void print(String label) {
        System.out.println(label);
    }

    public void menuCrud() {
        print("\tMenu\n[1] Create\n[2] Retrieve\n[3] Update\n[4] Delete");
        ask("");
    }
}
