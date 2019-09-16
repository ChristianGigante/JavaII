/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

/**
 *
 * @author 2ndyrGroupC
 */
public abstract class Inventory {

    public abstract void create(String obj);

    public abstract void read();

    public abstract boolean update(String oldObj, String newObj);

    public abstract boolean delete(String obj);
}
