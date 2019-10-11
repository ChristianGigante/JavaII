/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MidtermJava203;

/**
 *
 * @author gigantech_sd2023
 */
public class Registration {

    private int id;
    private String username;
    private String password;
    private String confirmPassword;

    public Registration() {
    }

    public Registration(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;

    }

    public Registration(String username, String password) {
        this.username = username;
        this.password = password;

    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "Registration{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }

}
