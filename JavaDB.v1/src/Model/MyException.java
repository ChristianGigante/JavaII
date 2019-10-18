/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 2ndyrGroupC
 */
public class MyException extends Exception {

    public MyException(String invalid) {
        super(invalid);
    }

    public static void isString(String str) throws MyException {
        if (str.matches(".*\\d.*")) {
            throw new MyException("Must only be String!!!");
        }
    }

    public static void isNumber(Object num) throws MyException {
        String num1 = num.toString();
        for (char c : num1.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new MyException("Must be a Number!");
            }
        }

    }

    public static void validatePassword(String str) throws MyException {
        if (str.length() < 8) {
            throw new MyException("Password is too short!!!");
        }
    }
}
