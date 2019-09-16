/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudjavacollection;

import Inventory.*;
import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupC
 */
public class CrudJavacollection {

    static int choice = 0;
    static int operation = 0;

    static ListInventory inventory1 = new ListInventory();
    static PriorityQueueInventory inventory2 = new PriorityQueueInventory();
    static SetInventory inventory3 = new SetInventory();

    static Inventory[] inventories = new Inventory[]{inventory1, inventory2, inventory3};


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);

        mainMenu:
        {
            while (choice == 0) {
                System.out.println("\nSelect Inventory : \n[1]List\n[2]Queue \n[3]Set \n[4]Exit");                
                System.out.print("\nChoice : ");
                choice = input.nextInt();
                if (choice == 4) {
                    break mainMenu;
                } else if (choice > 4) {
                    choice = 0;
                    continue;
                } else {
                    while (operation == 0 || choice > 5) {
                        System.out.println("\n\nSelect Operation : \n[1]Create\n[2]Retrieve\n[3]Update\n[4]Delete \n[5]Exit");                        
                        System.out.print("\nChoice : ");
                        operation = input.nextInt();
                        switch (operation) {
                            case 1:
                                System.out.print("\nCREATE\nEnter Product Name : ");
                                inventories[choice - 1].create(stringInput.nextLine());
                                operation = 0;
                                break;
                            case 2:
                                System.out.print("\nRETRIEVE\n");
                                inventories[choice - 1].read();
                                operation = 0;
                                break;
                            case 3:
                                System.out.print("\nUPDATE\nEnter Old Product Name : ");
                                String oldProduct = stringInput.nextLine();
                                System.out.print("Enter New Product Name : ");
                                String newProduct = stringInput.nextLine();

                                if (inventories[choice - 1].update(oldProduct, newProduct)) {
                                    System.out.println("Updated!");
                                } else {
                                    System.out.println("Failed");
                                }
                                operation = 0;
                                break;
                            case 4:
                                System.out.print("\nDELETE\nEnter Product Name : ");
                                if (inventories[choice - 1].delete(stringInput.nextLine())) {
                                    System.out.println("Deleted!");
                                } else {
                                    System.out.println("Failed!");
                                }
                                operation = 0;
                                break;
                            case 5:
                                choice = 0;
                                break;
                        }
                    }
                }
            }

        }
    }
}
