/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_3;

import java.io.*;
import java.util.*;

/**
 *
 * @author gigantech_sd2023
 */
public class Exp_3 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = null;
//        try {
//            String sCurrentLine;
//            br = new BufferedReader(new FileReader("C:\\Users\\gigantech_sd2023\\Desktop\\sample.txt"));
//            System.out.println("File Open and Read!");
//            while ((sCurrentLine = br.readLine()) != null) {
//                System.out.println(sCurrentLine);
//            }
//        } catch (IOException e) {
//            System.out.println("IOException: " + e.getMessage());
//        } catch (NullPointerException e) {
//            System.out.println("NullPointerException: " + e.getMessage());
//        } finally {
//            if (br != null) {
//                br.close();
//                System.out.println("File Closed!");
//            }
//        }
        // The name of the file to open.
//        String fileName = ("C:\\Users\\gigantech_sd2023\\Desktop\\sample.txt");
//
//        // This will reference one line at a time
//        String line = null;
//
//        try {
//            // FileReader reads text files in the default encoding.
//            FileReader fileReader = new FileReader(fileName);
//
//            // Always wrap FileReader in BufferedReader.
//            BufferedReader bufferedReader
//                    = new BufferedReader(fileReader);
//
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            // Always close files.
//            bufferedReader.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println(
//                    "Unable to open file '"
//                    + fileName + "'");
//        } catch (IOException ex) {
//            System.out.println(
//                    "Error reading file '"
//                    + fileName + "'");
//            // Or we could just do this: 
//            // ex.printStackTrace();
//        }
// The name of the file to open.
//        String fileName = ("C:\\Users\\gigantech_sd2023\\Desktop\\test.txt");
//
//        try {
//            // Assume default encoding.
//            FileWriter fileWriter = new FileWriter(fileName);
//
//            // Always wrap FileWriter in BufferedWriter.
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//
//            // Note that write() does not automatically
//            // append a newline character.
//            bufferedWriter.write("Hello there,");
//            bufferedWriter.write(" here is some text.");
//            bufferedWriter.newLine();
//            bufferedWriter.write("We are writing");
//            bufferedWriter.write(" the text to the file.");
//
//            // Always close files.
//            bufferedWriter.close();
//        } catch (IOException ex) {
//            System.out.println(
//                    "Error writing to file '"
//                    + fileName + "'");
//            // Or we could just do this:
//            // ex.printStackTrace();
//        }

        // Creating an empty Hashtable 
        Hashtable<String, String> hTbl = new Hashtable<String, String>();
        boolean status = false;
        while(!status){
            String fileName = ("C:\\Users\\gigantech_sd2023\\Desktop\\test.txt");
        Scanner input = new Scanner(System.in);
        System.out.print("Username: ");
        String userName = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        try {
            if (!hTbl.contains(userName)) {
                FileWriter fileWriter = new FileWriter(fileName, true);

                // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // Note that write() does not automatically
                // append a newline character.
                bufferedWriter.write(userName + "\t" + password + "\n");
                bufferedWriter.newLine();
                bufferedWriter.close();
            } else {
                throw new IOException("Error");
            }
        } catch (IOException e) {
            System.out.println(
                    "Error writing to file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
        }

    }
}
