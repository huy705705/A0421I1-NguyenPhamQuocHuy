package model;

public class Calculator {
    public static float calculate(float firstOperand,float secondOperand,char operator){
        switch (operator){
            case '+':
                return firstOperand+secondOperand;
            case '-':
                return firstOperand-secondOperand;
            case '*':
                return firstOperand*secondOperand;
            case '/':
                return firstOperand/secondOperand;
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
