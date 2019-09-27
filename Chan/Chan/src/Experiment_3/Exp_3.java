/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_3;

import java.io.*;

/**
 *
 * @author gigantech_sd2023
 */
public class Exp_3 {
    //main
    public static void main(String[] args) throws IOException {
        InputOutput io = new InputOutput();
        String num = io.ask("\t [YES] to Enroll \t [NO] to Exit");
        while (num.equalsIgnoreCase("yes")) {
            Account acc = new Account();
            perInfo per = new perInfo();
            schedule sched = new schedule();
            acc.loginAccount();
            per.register(acc.getId(), acc.getAccID());
            sched.schedule(sched.getSid(), acc.getAccID());
         num = io.ask("\t [YES] to Enroll \t [NO] to Exit");
        }
    }
}
