/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.util.*;

/**
 *
 * @author 2ndyrGroupC
 */
public class ListInventory extends Inventory {

    private List<String> inventory;

    public ListInventory() {
        this.inventory = new ArrayList<>();
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void setInventory(List<String> inventory) {
        this.inventory = inventory;
    }

    @Override
    public void create(String obj) {
        inventory.add(obj);
    }

    @Override
    public void read() {
        int count = 0;
        Iterator irr = inventory.iterator();
        System.out.printf("Items Inside The Set Inventory : %d\n",inventory.size());
        while (irr.hasNext()) {
            System.out.println(String.format("%d . %s", ++count, irr.next()));
        }
    }

    @Override
    public boolean update(String oldObj, String newObj) {
        boolean result = false;
        if (inventory.contains(oldObj)) {
            inventory.set(inventory.indexOf(oldObj), newObj);
            result = true;
        }
        return result;

    }

    @Override
    public boolean delete(String obj) {
        return inventory.remove(obj);
    }
}
