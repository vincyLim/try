package com.example.calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.calculator.model.CalculatorInput;

public class CalculatorServiceTest {
	private CalculatorService calculatorService;

	@BeforeEach
	public void setUp() {
		calculatorService = new CalculatorService();
	}

	@Test
	public void testAdd() {
		CalculatorInput input = new CalculatorInput(2.0, 3.0, "add");
		double result = calculatorService.calculate(input);
		Assertions.assertEquals(5, result);
	}

	@Test
	public void testSubtract() {
		CalculatorInput input = new CalculatorInput(5.0, 2.0, "subtract");
		double result = calculatorService.calculate(input);
		Assertions.assertEquals(3, result);
	}

	@Test
	public void testMultiply() {
		CalculatorInput input = new CalculatorInput(4.0, 2.5, "multiply");
		double result = calculatorService.calculate(input);
		Assertions.assertEquals(10, result);
	}

	@Test
	public void testDivide() {
		CalculatorInput input = new CalculatorInput(10.0, 2.0, "divide");
		double result = calculatorService.calculate(input);
		Assertions.assertEquals(5, result);
	}

	@Test
	public void testDivideByZero() {
		CalculatorInput input = new CalculatorInput(10.0, 0.0, "divide");
		Assertions.assertThrows(ArithmeticException.class, () -> {
			calculatorService.calculate(input);
		});
	}

	@Test
	public void testSqrt() {
		CalculatorInput input = new CalculatorInput(16.0, 0.0, "sqrt");
		double result = calculatorService.calculate(input);
		Assertions.assertEquals(4, result);
	}

	@Test
	public void testPow() {
		CalculatorInput input = new CalculatorInput(2.0, 3.0, "pow");
		double result = calculatorService.calculate(input);
		Assertions.assertEquals(8, result);
	}

	@Test
	public void testMod() {
		CalculatorInput input = new CalculatorInput(10.0, 3.0, "mod");
		double result = calculatorService.calculate(input);
		Assertions.assertEquals(1, result);
	}

	@Test
	public void testInvalidOperation() {
		CalculatorInput input = new CalculatorInput(1.0, 2.0, "invalid");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			calculatorService.calculate(input);
		});
	}

	@Test
	public void testSqrtNegative() {
		CalculatorInput input = new CalculatorInput(-4.0, 0.0, "sqrt");
		Assertions.assertThrows(ArithmeticException.class, () -> {
			calculatorService.calculate(input);
		});
	}
}
