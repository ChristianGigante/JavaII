/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_1;

import static Day1.prac1.display;
import java.util.*;

/**
 *
 * @author 2ndyrGroupC
 */
public class Exp1 {

    static int sel;

    public static void display(Iterator itr, String label) {
        System.out.println(label);
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static void main(String[] args) {
        Navigator nav = new Navigator();
        sel = nav.initialMenu();
        Scanner input = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        Queue<String> queue = new PriorityQueue<>();
        Set<String> set = new TreeSet<>();
        while (sel != 4) {
            //List
            if (sel == 1) {
                System.out.println("List Mode");
                int jOpt = nav.functionMenu();
                switch (jOpt) {
                    case 1:
                        System.out.println(">>>Enter Element to Add:");
                        list.add(input.nextLine());
                        System.out.println("Element Added!");
                        break;
                    case 2:
                        display(list.iterator(), "Elements in list:");
                        break;
                    case 3:
                        System.out.println(">>>Enter Element to Update:");
                        String oldObj = input.nextLine();
                        if (list.contains(oldObj)) {
                            System.out.println(">>>Enter Update: ");
                            String newObj = input.nextLine();
                            list.set(list.indexOf(oldObj), newObj);
                            System.out.println("Element Updated!");
                        } else {
                            System.out.println("Element Not Exist!");
                        }
                        break;
                    case 4:
                        System.out.println(">>>Enter Element Name: ");
                        String delObj = input.nextLine();
                        if (list.contains(delObj)) {
                            list.remove(delObj);
                            System.out.println("Element Deleted!");
                        } else {
                            System.out.println("Element Not Exist!");
                        }
                        break;
                }
            }

            //Queue
            if (sel == 2) {
                System.out.println("Queue Mode");
                int jOpt = nav.functionMenu();
                switch (jOpt) {
                    case 1:
                        System.out.println(">>>Enter Element to Add:");
                        queue.add(input.nextLine());
                        System.out.println("Element Added!");
                        break;
                    case 2:
                        display(queue.iterator(), "Elements in Priority Queue:");
                        break;
                    case 3:
                        System.out.println(">>>Enter Element to Update:");
                        String oldObj = input.nextLine();
                        if (queue.contains(oldObj)) {
                            queue.remove(oldObj);
                            System.out.println(">>>Enter Update: ");
                            String newObj = input.nextLine();
                            queue.add(newObj);
                            System.out.println("Element Updated!");
                        } else {
                            System.out.println("Element Not Exist!");
                        }
                        break;
                    case 4:
                        System.out.println(">>>Enter Element Name: ");
                        String delObj = input.nextLine();
                        if (queue.contains(delObj)) {
                            queue.remove(delObj);
                            System.out.println("Element Deleted!");
                        } else {
                            System.out.println("Element Not Exist!");
                        }
                        break;
                }

            }

            //set
            if (sel == 3) {
                System.out.println("Set Mode");
                int jOpt = nav.functionMenu();
                switch (jOpt) {
                    case 1:
                        System.out.println(">>>Enter Element to Add:");
                        set.add(input.nextLine());
                        System.out.println("Element Added!");
                        break;
                    case 2:
                        display(set.iterator(), "Elements in Priority Queue:");
                        break;
                    case 3:
                        System.out.println(">>>Enter Element to Update:");
                        String oldObj = input.nextLine();
                        if (queue.contains(oldObj)) {
                            queue.remove(oldObj);
                            System.out.println(">>>Enter Update: ");
                            String newObj = input.nextLine();
                            queue.add(newObj);
                            System.out.println("Element Updated!");
                        } else {
                            System.out.println("Element Not Exist!");
                        }
                        break;
                    case 4:
                        System.out.println(">>>Enter Element Name: ");
                        String delObj = input.nextLine();
                        if (set.contains(delObj)) {
                            set.remove(delObj);
                            System.out.println("Element Deleted!");
                        } else {
                            System.out.println("Element Not Exist!");
                        }
                        System.out.println(">>>Enter Element Name: ");
                        break;
                }

            }

            sel = nav.initialMenu();
        }
    }
}
