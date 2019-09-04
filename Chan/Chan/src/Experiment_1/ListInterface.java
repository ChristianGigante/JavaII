/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_1;

import java.util.*;

/**
 *
 * @author 2ndyrGroupC
 */
public class ListInterface {

    public static ArrayList<Employee> list = new ArrayList<>();//Creating arraylist  

    public void add(Employee employee) {
        list.add(employee);
    }

    public static void print(Iterator itr) {
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> li = new ArrayList<>();
        Employee emp = new Employee("0", "Christian", "Cebu");
        li.add(emp);
        for (int i = 0; i < li.size(); i++) {
            System.out.println(li.get(i));
        }

    }
}
