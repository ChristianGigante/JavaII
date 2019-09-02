/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day1;

import java.util.*;

/**
 *
 * @author gigantech_sd2023
 */
public class prac1 {

    public static void arrayList() {
        ArrayList<String> list4 = new ArrayList<>();
        list4.add("Roy");
        list4.add("Bob");
        list4.add("Roy");
        list4.add("Bob");
        display(list4.iterator(), "Array List");
    }

    public static void linkedList() {
        LinkedList<String> list5 = new LinkedList<>();
        list5.add("Boy");
        list5.add("Bob");
        list5.add("Doy");
        display(list5.iterator(), "Linked List");
    }

    public static void vector() {
        Vector<String> list6 = new Vector<>();
        list6.add("Roy");
        list6.add("Bob");
        list6.add("Roy");
        list6.add("Bob");
        display(list6.iterator(), "Vector");
    }

    public static void stack() {
        Stack<String> stack = new Stack<>();
        stack.push("Roy");
        stack.push("Bob");
        stack.push("Roy");
        stack.push("Bob");
        stack.pop();
        display(stack.iterator(), "Stack");
    }

    public static void priorityQueue() {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("Roy");
        queue.add("Bob");
        queue.add("Roy");
        queue.add("Bob");
        queue.add("Aroy");
        System.out.println("head: " + queue.element());
        System.out.println("head: " + queue.peek());
        System.out.println("Iterating queue elements: ");
        display(queue.iterator(), "Priority Queue");

        System.out.println("Remove: " + queue.remove());
        System.out.println("Poll: " + queue.poll());
        System.out.println("After removing two elements:");
        display(queue.iterator(), "Priority Queue");
    }

    public static void deque() {
        //Creating Deque and adding elements  
        Deque<String> deque = new ArrayDeque<String>();
        deque.add("Ravi");
        deque.add("Vijay");
        deque.add("Ajay");
        //Traversing elements  
        for (String str : deque) {
            System.out.println(str);
        }
    }
    
    public static void set() {
        Set <String> s1 = new HashSet<String>();
        s1.add("Raw");
        
    }

    public static void display(Iterator itr, String label) {
        System.out.println(label);
        while (itr.hasNext()) {
            System.out.println(itr.next());
//            String str = (String) itr.next();
//            if (str.startsWith("B")) {
//                System.out.println(str);
//            }
        }
    }

    public static void main(String[] args) {
//        List <Integer> list = new ArrayList();
//        List <Integer> list1 = new LinkedList();
//        List <Integer> list2 = new Vector();
//        List <Integer> list3 = new Stack();

//        ArrayList<String> list4 = new ArrayList<>();
//
//        list4.add("Roy");
//        list4.add("Bob");
//        list4.add("Roy");
//        list4.add("Bob");
//
//        Iterator itr = list4.iterator();
//        while (itr.hasNext()) {
//            System.out.println(itr.next());
//        } 
//        arrayList();
//        linkedList();
//        vector();
//        priorityQueue();
        deque();
    }
}
