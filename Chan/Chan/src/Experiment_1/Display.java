/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_1;

import java.util.Iterator;

/**
 *
 * @author 2ndyrGroupC
 */
public class Display {
      public static void print(Iterator itr){
        while(itr.hasNext()){
            System.out.println(itr.next());  
        } 
    }
}
