/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_1;
import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupC
 */
public class Navigator {
        public int initialMenu(){
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please choose the ff:");
        System.out.print("Menu\n\t1 List\n\t2 Queue\n\t3 Set\n\t4 Exit\nOption: ");
//        System.out.println("Option: ");
        int choice = scanner.nextInt();
        return choice;
    }
    
    public int functionMenu(){
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please choose the ff:\n");
        System.out.print("\t1 Create\n\t2 Read\n\t3 Update\n\t4 Delete\n\t5 Back\nOption: ");
//        System.out.println("Option: ");
        int choice = scanner.nextInt();
        return choice;
    }
}
