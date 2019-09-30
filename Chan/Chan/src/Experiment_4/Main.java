/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_4;

//import Experiment_3.perInfo;
//import Experiment_3.schedule;
import java.io.IOException;

/**
 *
 * @author 2ndyrGroupC
 */
public class Main {

    //main
    public static void main(String[] args) throws IOException {
        Experiment_3.InputOutput io = new Experiment_3.InputOutput();
        String num = io.ask("\t [YES] to Enroll \t [NO] to Exit");
        while (num.equalsIgnoreCase("yes")) {
            Account acc = new Account();
//            perInfo per = new perInfo();
//            schedule sched = new schedule();
            acc.loginAccount();
            acc.save();
//            per.register(acc.getId(), acc.getAccID());
//            sched.schedule(sched.getSid(), acc.getAccID());
            num = io.ask("\t [YES] to Enroll \t [NO] to Exit");
        }
    }
}
