/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MidtermJava203;

import java.util.*;

/**
 *
 * @author gigantech_sd2023
 */
public class Main {

    public static InputOutput io = new InputOutput();
    public static ArrayList<Registration> regList = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //configureJDBC
        ConfigDB configDB = new ConfigDB();
        configDB.connectDB();

        Registration regAcc = new Registration();
        RegistrationInterface reg = new RegistrationInterface();

        Login log = new Login();
        LoginInterface logInt = new LoginInterface();

        Post p = new Post();

        while (true) {
            int sel = io.firstMenu();
            if (sel == 1) {
                regAcc = reg.register();
                regList.add(regAcc);
            } else if (sel == 2) {
                String username = io.ask("username");
                for (int i = 0; i < regList.size(); i++) {
                    if (username == null ? regList.get(i).getUsername() == null : username.equals(regList.get(i).getUsername())) {
                        String password = io.ask("password");
                        if (password == null ? regList.get(i).getPassword() == null : password.equals(regList.get(i).getPassword())) {
                            int val = io.secMenu(username);
                            while (val != 5) {
                                switch (val) {
                                    case 1:
                                        p.addPost(username);
                                        break;
                                    case 2:
                                        p.retrievePost();
                                        break;
                                    case 3:
                                        p.updatePost(username);
                                        break;
                                    case 4:
                                        p.deletePost();
                                        break;
                                    default:
                                        break;
                                }
                                val = io.secMenu(username);
                            }
                        } else {
                            io.print("Invalid Password");
                        }
                    } else {
                        io.print("Username Not Exist");
                    }
                }
            }
        }

    }
}
