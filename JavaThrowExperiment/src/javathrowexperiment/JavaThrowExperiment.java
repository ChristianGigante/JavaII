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
public class JavaThrowExperiment {

    public static void main(String args[]) throws IOException, PasswordException {
        Accounts a = new Accounts();
        a.addUsername();
        a.addPassword();
        a.save();
//        a.addUsername();
//        a.addPassword();
//        a.save();
        System.out.println("normal flow...");
    }
}
