/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalExp1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gigantech_sd2023
 */
public class ListInventory extends CRUD{

    private List<Employee> inventory;

    public ListInventory() {
        this.inventory = new ArrayList<>();
    }

    public List<Employee> getInventory() {
        return inventory;
    }

    public void setInventory(List<Employee> inventory) {
        this.inventory = inventory;
    }

    @Override
    public void create(Employee emp) {
        
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void retrieve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Employee oldEmp, Employee newEmp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
