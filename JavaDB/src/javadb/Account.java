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
    private int id;
    private int accID = 992019 + id;

    //constructors
    public Account() {
//        try {
//            this.id = id();
//        } catch (IOException ex) {
//            System.out.println(ex);
//        }
    }

    public Account(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    //gettersAndSetters
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    //toString()
    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }
    
    

}
