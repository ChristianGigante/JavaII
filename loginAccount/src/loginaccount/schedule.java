package loginaccount;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class schedule {

    public int sid = 1;

    public schedule() {
        try {
            this.sid = sid();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
    public void schedule(int id, int accID) {
        Scanner scan = new Scanner(System.in);

        try {
            File schedule = new File("schedule.txt"/*,true*/);

            try (BufferedWriter fw = new BufferedWriter(new FileWriter(schedule, true))) {
                while (true) {
                    System.out.println("Do you want to add subject??\t\n Yes or No");
                    String ans = scan.next();
                    if (ans.equals("Yes") || ans.equals("yes") || ans.equals("YES")) {
                        System.out.print("Enter Subject: ");
                        String sub = scan.next();

                        while (!check(sub)) {
                            System.out.print("Invalid Subject!!!\nPlease Enter new Subject: ");
                            sub = scan.next();
                        }

                        System.out.print("Enter how many units: ");
                        String unit = scan.next();

                        while (!checkInt(unit)) {
                            System.out.print("Invalid Input!!!\nPlease Enter Units: ");
                            unit = scan.next();
                        }
                        System.out.print("Enter Schedule: ");
                        String Sched = scan.next();

                        while (!check(Sched)) {
                            System.out.print("Invalid Schedule!!!\nPlease Enter new Schedule: ");
                            Sched = scan.next();
                        }

                        fw.write(this.sid++ + "\t" + accID + "\t" + sub + "\t" + unit + "\t" + Sched + "\n");
                        
                    } else if (ans.equals("No") || ans.equals("no") || ans.equals("NO")) {
                        fw.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public final int sid() throws FileNotFoundException, IOException {
        BufferedReader reader;

        reader = new BufferedReader(new FileReader("schedule.txt"));
        String line = reader.readLine();
        while (line != null) {
            if (line.length() != 0) {
                ++sid;
            }
            line = reader.readLine();
        }
        reader.close();
        return sid;
    }

    public boolean checkInt(String age) {
        String rule = "\\d+";
        return age.matches(rule);
    }

    public boolean check(String username) {
        String rule = "^[a-zA-Z ]*$";
        return username.matches(rule);
    }
}
