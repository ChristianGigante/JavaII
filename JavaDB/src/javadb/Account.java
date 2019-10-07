/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb;

/**
 *
 * @author 2ndyrGroupC
 */
public class Account {
    //attributes
    private String username;
    private String password;

    //constructors
    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //getters&setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //toString
    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + '}';
    }
    
    

}
