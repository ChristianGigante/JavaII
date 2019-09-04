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
     private String empId;
     private String empName;
     private String empAddress;

    public Employee() {
    }

    public Employee(String empId, String empName, String empAddress) {
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
    }

     
    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
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
     * @return the empAddress
     */
    public String getEmpAddress() {
        return empAddress;
    }

    /**
     * @param empAddress the empAddress to set
     */
    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    @Override
    public String toString() {
        return String.format("%20s%20s%20s",getEmpId(), getEmpName(), getEmpAddress());
    }
     
//    public static void main(String[] args){
//        Employee e = new Employee("01","Tian","Cebu");
//        System.out.println(e);
//    }
//    
    
     

    
}
