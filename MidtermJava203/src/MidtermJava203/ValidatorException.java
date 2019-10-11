/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MidtermJava203;

/**
 *
 * @author gigantech_sd2023
 */
public class ValidatorException extends Exception {

    public ValidatorException(String invalid) {
        super(invalid);
    }

    public static void isString(String str) throws ValidatorException {
        if (str.matches(".*\\d.*")) {
            throw new ValidatorException("Invalid Username!!!");
        }
    }

    public static void isNumber(Object num) throws ValidatorException {
        String num1 = num.toString();
        for (char c : num1.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new ValidatorException("Invalid!!!");
            }
        }
    }

    public static void isNull(String str) throws ValidatorException {
        if (str.equals("")) {
            throw new ValidatorException("Invalid Username!!!");
        }
    }

    public static void validatePassword(String str) throws ValidatorException {
        if (str.length() < 8) {
            throw new ValidatorException("Password is too short!!!");
        }
    }
}
