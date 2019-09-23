/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginaccount;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginAccount {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        account acc = new account();
        perInfo per = new perInfo();
        schedule sched = new schedule();

        acc.loginAccount();
        per.register(acc.getId(), acc.getAccID());
        sched.schedule(sched.getSid(),acc.getAccID());
    }
}
