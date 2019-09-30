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
        InputOutput io = new InputOutput();
        String num = io.ask("\t [YES] to Enroll \t [NO] to Exit");
        while (num.equalsIgnoreCase("yes")) {
            String val = "1";
            switch(val){
                case "1":
                    io.menuCrud();
                default:
                    val = "1";
            }
//            Account acc = new Account();
////            perInfo per = new perInfo();
////            schedule sched = new schedule();
//            acc.loginAccount();
//            acc.saveAccount();
//            per.register(acc.getId(), acc.getAccID());
//            sched.schedule(sched.getSid(), acc.getAccID());
            num = io.ask("\t [YES] to Enroll \t [NO] to Exit");
        }
    }
}
