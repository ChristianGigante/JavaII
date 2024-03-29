/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experiment_1;

/**
 *
 * @author 2ndyrGroupC
 */
public class Employee {

    private int empId;
    private String empName;
    private String empEmail;

    public Employee() {
    }

    public Employee(int empId, String empName, String empEmail) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
    }

    /**
     * @return the empId
     */
    public int getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    /**
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName the empName to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return the empEmail
     */
    public String getEmpEmail() {
        return empEmail;
    }

    /**
     * @param empEmail the empEmail to set
     */
    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    @Override
    public String toString() {
        return String.format("%d%20s%50s", getEmpId(), getEmpName(), getEmpEmail());
    }
    
//    public static void main(String[] args){
//        Employee emp = new Employee(1,"christian","christiangigante@gmail.com");
//        System.out.println(emp);
//    }
}
