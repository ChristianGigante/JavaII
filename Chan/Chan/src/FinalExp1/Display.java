/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalExp1;

import java.util.Iterator;

/**
 *
 * @author gigantech_sd2023
 */
public class Display {
        public static void print(Iterator itr){
        while(itr.hasNext()){
            System.out.println(itr.next());  
        } 
    }
}
