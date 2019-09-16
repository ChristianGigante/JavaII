/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandlingJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author gigantech_sd2023
 */
public class TryCatchFinally {

    public static void main(String[] args) throws IOException {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Devision");
//        System.out.println("Input Dividend: ");
//        int num1 = input.nextInt();
//        System.out.println("Input Divisor: ");
//        int num2 = input.nextInt();
//        int result = 0;
//        try {
//           result = num1/num2;
//        } catch (NullPointerException e) {
//            System.out.println("NullPointerException: " + e.getMessage());
//        } catch (NumberFormatException e) {
//            System.out.println("NumberFormatException: " + e.getMessage());
//        } catch (Exception e) {
//            System.out.println("Exception: " + e.getMessage());
//        } finally {
//            if(result == 0){
//                
//                System.exit(0);
//                System.out.println("Closing Program");
//            }
//            else{
//                System.out.println("Result: " + result);
//            }
//        }

        BufferedReader br = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("C:\\Users\\gigantech_sd2023\\Desktop\\sample.txt"));
            System.out.println("File Open and Read!");
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        } finally {
            if (br != null) {
                br.close();
                System.out.println("File Closed!");
            }
        }
    }
}
