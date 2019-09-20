/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javathrowexperiment;

/**
 *
 * @author morrejo_sd2023
 */
public class PasswordException extends Exception {

    public PasswordException(String password_too_short) {
        super(password_too_short);
    }
    
}
