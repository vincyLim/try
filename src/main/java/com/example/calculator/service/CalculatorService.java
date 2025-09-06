package com.example.calculator.service;

import com.example.calculator.model.CalculatorInput;
import org.springframework.stereotype.Service;

//Changes

@Service
public class CalculatorService {

    public double calculate(CalculatorInput input) {
        String operation = input.getOperation().toLowerCase();

        switch (operation) {
            case "add": return input.getNum1() + input.getNum2();
            case "subtract": return input.getNum1() - input.getNum2();
            case "multiply": return input.getNum1() * input.getNum2();
            case "divide":
                if (input.getNum2() == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return input.getNum1() / input.getNum2();
            case "sqrt": // Square root of num1
                if (input.getNum1() < 0) {
                    throw new ArithmeticException("Square root of negative number is not allowed");
                }
                return Math.sqrt(input.getNum1());
            case "pow": // Power: num1 ^ num2
                return Math.pow(input.getNum1(), input.getNum2());
            case "mod": // Modulus: num1 % num2
                return input.getNum1() % input.getNum2();
            default:
                throw new IllegalArgumentException("Invalid or unsupported operation");
        }
    }
}
