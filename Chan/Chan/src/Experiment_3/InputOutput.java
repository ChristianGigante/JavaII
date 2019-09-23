/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_3;

import java.util.Scanner;

/**
 *
 * @author gigantech_sd2023
 */
public class InputOutput {

    public String ask(String label) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter " + label + " : ");
        return scanner.next();
    }
    
    public void print(String label) {
        System.out.println(label);
    }
}
