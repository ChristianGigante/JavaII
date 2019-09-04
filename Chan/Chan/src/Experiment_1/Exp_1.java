/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_1;

import java.util.*;

/**
 *
 * @author gigantech_sd2023
 */
public class Exp_1 {

    //displayMenu
    public static void displayMenu() {
        System.out.print("Menu\n\t1 List\n\t2 Queue\n\t3 Set\n\t4 Exit\nSelect: ");
    }

    //CRUD
    public static void crud() {
        System.out.print("\t1 Create\n\t2 Read\n\t3 Update\n\t4 Delete\n\t5 Back\nSelect: ");
    }

    public static void display(Iterator itr) {
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    //ListMode
    public static void main(String[] args) {
        Scanner sel = new Scanner(System.in);
        displayMenu();
        switch (sel.nextInt()) {
            case 1:
                // List
                List list = new ArrayList();
                while (true) {
                    Scanner input = new Scanner(System.in);
                    System.out.println("List Mode");
                    crud();
                    switch (sel.nextInt()) {
                        case 1:
                            // Create
                            System.out.println("-Add Element-");
                            list.add(input.nextLine());
                            System.out.println("Successfully Added");
                            break; // optional

                        case 2:
                            // Read
                            if (!list.isEmpty()) {
                                System.out.println("List Elements: ");
                                display(list.iterator());
                            } else {
                                System.out.println(">>>Empty List");
                            }
                            break; // optional
                            
                        case 3:
                            // Update
                            if (!list.isEmpty()) {
                                System.out.println("-Update Element (Input target Element)-");
                                display(list.iterator());
                                list.remove(input.nextLine());
                            } else {
                                System.out.println(">>>Empty List");
                            }

                        case 4:
                            // Delete
                            if (!list.isEmpty()) {
                                System.out.println("-Remove Element (Input target Element)-");
                                display(list.iterator());
                                list.remove(input.nextLine());
                            } else {
                                System.out.println(">>>Empty List");
                            }
                        //break; // optional
                        // You can have any number of case statements.
                        default: // Optional
                        // Statements
                            continue;
                    }
                }

            //break; // optional
            case 2:
                // Statements
                break; // optional

            case 3:
                // Statements
                break; // optional

            case 4:
                // Statements
                break; // optional

            // You can have any number of case statements.
            default: // Optional
            // Statements
        }
    }
}
