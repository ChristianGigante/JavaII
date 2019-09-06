/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalExp1;

/**
 *
 * @author gigantech_sd2023
 */
public abstract class CRUD {

    public abstract void create(Employee emp);

    public abstract void retrieve();

    public abstract boolean update(Employee oldEmp, Employee newEmp);

    public abstract boolean delete(String name);
}
