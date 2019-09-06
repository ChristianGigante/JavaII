/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalExp1;

import java.util.Scanner;

/**
 *
 * @author gigantech_sd2023
 */
public class Navigator {

    public int initialMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("<Menu>\n\t1 List\n\t2 Queue\n\t3 Set\n\t4 Exit\nOption: ");
        int choice = scanner.nextInt();
        return choice;
    }

    public int functionMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t1 Create\n\t2 Retrieve\n\t3 Update\n\t4 Delete\n\t5 Back\nOption: ");
        int choice = scanner.nextInt();
        return choice;
    }
}
