/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chan;

import java.util.*;

/**
 *
 * @author gigantech_sd2023
 */
public class Chan {

//    /**
//     * @param args the command line arguments
//     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         List<String> list = new ArrayList();
         list.add("Christian");
         Iterator<String> itr = list.iterator() ;
         if(list.iterator().hasNext()){
             System.out.println(list.iterator().next());
         }
    }
//    
}
