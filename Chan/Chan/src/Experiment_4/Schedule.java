/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_4;

/**
 *
 * @author gigantech_sd2023
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Schedule {

    public int sid = 1;

    public Schedule() {
        try {
            this.sid = sid();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
    public void schedule(int id, int accID) {
        InputOutput io = new InputOutput();
        try {
            File schedule = new File("schedule.txt"/*,true*/);
            try (BufferedWriter fw = new BufferedWriter(new FileWriter(schedule, true))) {
                while (true) {
                    io.print("Do you want to add subject?");
                    String ans = io.ask("Yes or No");
                    if (ans.equalsIgnoreCase("yes")) {
                        String sub = io.ask("Enter Subject: ");
                        while (!check(sub)) {
                            sub = io.ask("Invalid Subject!!!\nPlease Enter new Subject: ");
                        }
                        String unit = io.ask("how many units");
                        while (!checkInt(unit)) {
                            unit = io.ask("Invalid Input!!!\nPlease Enter Units: ");
                        }
                        String Sched = io.ask("Schedule");
                        while (!check(Sched)) {
                            Sched = io.ask("Invalid Schedule!!!\nPlease Enter new Schedule");
                        }

                        fw.write(this.sid++ + "\t" + accID + "\t" + sub + "\t" + unit + "\t" + Sched + "\n");

                    } else if (ans.equalsIgnoreCase("no")) {
                        fw.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
//
//    public void saveSched() {
//        try {
//            File schedule = new File("schedule.txt"/*,true*/);
//            try (BufferedWriter fw = new BufferedWriter(new FileWriter(schedule, true))) {
//                while (true) {
//                    
//                    fw.write(this.sid++ + "\t" + accID + "\t" + sub + "\t" + unit + "\t" + Sched + "\n");
//                }else if (ans.equalsIgnoreCase("no")) {
//                        fw.close();
//                        break;
//                    }
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//    
//
//    
//
//    

    

    

    public final int sid() throws FileNotFoundException, IOException {
        BufferedReader reader;

        reader = new BufferedReader(new FileReader("schedule.txt"));
        String line = reader.readLine();
        while (line != null) {
            if (line.length() != 0) {
                ++sid;
            }
            line = reader.readLine();
        }
        reader.close();
        return sid;
    }

    public boolean checkInt(String age) {
        String rule = "\\d+";
        return age.matches(rule);
    }

    public boolean check(String username) {
        String rule = "^[a-zA-Z ]*$";
        return username.matches(rule);
    }
}
