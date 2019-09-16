/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gigantech_sd2023
 */
import java.io.*;
public class Experiment_2 {
    

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/




/**
*
* @author erimja_sd2023
*/


   public static void main(String args[]) throws IOException {  
     FileInputStream in = null;
     FileOutputStream out = null;

     try {
        in = new FileInputStream("inpufdsdt.txt");
        out = new FileOutputStream("output.txt");
       
        int c;
        while ((c = in.read()) != -1) {
           out.write(c);
        }
     }catch (FileNotFoundException e){
         System.out.println(e);
     }finally {
        if (in != null) {
           in.close();
        }
        if (out != null) {
           out.close();
        }
     }
  }

}
