package com.example.calculator.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.calculator.model.CalculatorInput;
import com.example.calculator.service.CalculatorService;

public class CalculatorControllerTest {
    private CalculatorService calculatorService;
    private CalculatorController calculatorController;

    @BeforeEach
    public void setUp() {
        calculatorService = Mockito.mock(CalculatorService.class);
        calculatorController = new CalculatorController(calculatorService);
    }

    @Test
    public void testCalculate_AddOperation() {
        CalculatorInput input = new CalculatorInput(2.0, 3.0, "add");
        Mockito.when(calculatorService.calculate(input)).thenReturn(5.0);

        double result = calculatorController.calculate(input);
        Assertions.assertEquals(5.0, result);

        Mockito.verify(calculatorService).calculate(input);
    }

    @Test
    public void testCalculate_SubtractOperation() {
        CalculatorInput input = new CalculatorInput(5.0, 2.0, "subtract");
        Mockito.when(calculatorService.calculate(input)).thenReturn(3.0);

        double result = calculatorController.calculate(input);
        Assertions.assertEquals(3.0, result);
        Mockito.verify(calculatorService).calculate(input);
    }

    @Test
    public void testCalculate_MultiplyOperation() {
        CalculatorInput input = new CalculatorInput(4.0, 2.5, "multiply");
        Mockito.when(calculatorService.calculate(input)).thenReturn(10.0);

        double result = calculatorController.calculate(input);
        Assertions.assertEquals(10.0, result);
        Mockito.verify(calculatorService).calculate(input);
    }

    @Test
    public void testCalculate_DivideOperation() {
        CalculatorInput input = new CalculatorInput(10.0, 2.0, "divide");
        Mockito.when(calculatorService.calculate(input)).thenReturn(5.0);

        double result = calculatorController.calculate(input);
        Assertions.assertEquals(5.0, result);
        Mockito.verify(calculatorService).calculate(input);
    }

    @Test
    public void testCalculate_SqrtOperation() {
        CalculatorInput input = new CalculatorInput(16.0, 0.0, "sqrt");
        Mockito.when(calculatorService.calculate(input)).thenReturn(4.0);

        double result = calculatorController.calculate(input);
        Assertions.assertEquals(4.0, result);
        Mockito.verify(calculatorService).calculate(input);
    }

    @Test
    public void testCalculate_PowOperation() {
        CalculatorInput input = new CalculatorInput(2.0, 3.0, "pow");
        Mockito.when(calculatorService.calculate(input)).thenReturn(8.0);

        double result = calculatorController.calculate(input);
        Assertions.assertEquals(8.0, result);
        Mockito.verify(calculatorService).calculate(input);
    }

    @Test
    public void testCalculate_ModOperation() {
        CalculatorInput input = new CalculatorInput(10.0, 3.0, "mod");
        Mockito.when(calculatorService.calculate(input)).thenReturn(1.0);

        double result = calculatorController.calculate(input);
        Assertions.assertEquals(1.0, result);
        Mockito.verify(calculatorService).calculate(input);
    }

    @Test
    public void testCalculate_InvalidOperation() {
        CalculatorInput input = new CalculatorInput(1.0, 2.0, "invalid");
        Mockito.when(calculatorService.calculate(input))
                .thenThrow(new IllegalArgumentException("Invalid or unsupported operation"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorController.calculate(input);
        });
        Mockito.verify(calculatorService).calculate(input);
    }
}
