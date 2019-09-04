/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_1;

import java.util.*;

/**
 *
 * @author 2ndyrGroupC
 */
public class Exp1 {

    static int sel;

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Navigator nav = new Navigator();
        sel = nav.initialMenu();
        while (sel != 4) {
            //List
            if (sel == 1) {
                ArrayList<Employee> list = new ArrayList<>();
                System.out.println("List");
                int jOpt = nav.functionMenu();
                while (jOpt != 5) {
                    if (jOpt == 1) {
                        System.out.println("C");
                        break;
                    };

                    if (jOpt == 2) {
                        System.out.println("C");
                        break;
                    };

                    if (jOpt == 3) {
                        System.out.println("C");
                        break;
                    };

                    if (jOpt == 4) {
                        System.out.println("C");
                        break;
                    };
                    
                }
                continue;

            }

            //Queue
            if (sel == 2) {
                System.out.println("Queue");
                int jOpt = nav.functionMenu();
                while (jOpt != 5) {
                    if (jOpt == 1) {
                        System.out.println("List");
                    }
                    if (jOpt == 2) {
                        System.out.println("");
                    }
                }

            }

            //set
            if (sel == 3) {
                System.out.println("Set");
                int jOpt = nav.functionMenu();
                while (jOpt != 5) {
                    if (jOpt == 1) {
                        System.out.println("List");
                    }
                    if (jOpt == 2) {
                        System.out.println("");
                    }
                }

            }

            sel = nav.initialMenu();
        }
    }
}
