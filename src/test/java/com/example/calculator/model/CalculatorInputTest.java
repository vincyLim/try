package com.example.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorInputTest {
    @Test
    public void testGettersAndSetters() {
        CalculatorInput input = new CalculatorInput(2.0, 3.0, "add");
        Assertions.assertEquals(2.0, input.getNum1());
        Assertions.assertEquals(3.0, input.getNum2());
        Assertions.assertEquals("add", input.getOperation());

        input.setNum1(5.0);
        input.setNum2(7.0);
        input.setOperation("subtract");
        Assertions.assertEquals(5.0, input.getNum1());
        Assertions.assertEquals(7.0, input.getNum2());
        Assertions.assertEquals("subtract", input.getOperation());
    }
}
