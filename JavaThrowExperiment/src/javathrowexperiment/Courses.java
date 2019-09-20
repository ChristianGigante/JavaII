/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javathrowexperiment;

import java.io.IOException;


/**
 *
 * @author morrejo_sd2023
 */

class Testthrows {

    public static void main(String args[]) throws IOException, PasswordException {
        Accounts m = new Accounts();
        m.addUsername();
        m.addPassword();
        m.save();
        m.addUsername();
        m.addPassword();
        m.save();
        System.out.println("normal flow...");
    }
}
