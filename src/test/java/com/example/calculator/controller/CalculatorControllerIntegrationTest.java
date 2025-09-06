package com.example.calculator.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.calculator.model.CalculatorInput;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddOperation() throws Exception {
        CalculatorInput input = new CalculatorInput(2.0, 3.0, "add");
        String json = objectMapper.writeValueAsString(input);

        mockMvc.perform(post("/api/calculator/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    public void testSubtractOperation() throws Exception {
        CalculatorInput input = new CalculatorInput(5.0, 2.0, "subtract");
        String json = objectMapper.writeValueAsString(input);

        mockMvc.perform(post("/api/calculator/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0"));
    }

    @Test
    public void testMultiplyOperation() throws Exception {
        CalculatorInput input = new CalculatorInput(4.0, 2.5, "multiply");
        String json = objectMapper.writeValueAsString(input);

        mockMvc.perform(post("/api/calculator/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("10.0"));
    }

    @Test
    public void testDivideOperation() throws Exception {
        CalculatorInput input = new CalculatorInput(10.0, 2.0, "divide");
        String json = objectMapper.writeValueAsString(input);

        mockMvc.perform(post("/api/calculator/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    public void testSqrtOperation() throws Exception {
        CalculatorInput input = new CalculatorInput(16.0, 4.0, "sqrt");
        String json = objectMapper.writeValueAsString(input);

        mockMvc.perform(post("/api/calculator/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("4.0"));
    }

    @Test
    public void testPowOperation() throws Exception {
        CalculatorInput input = new CalculatorInput(2.0, 3.0, "pow");
        String json = objectMapper.writeValueAsString(input);

        mockMvc.perform(post("/api/calculator/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("8.0"));
    }

    @Test
    public void testModOperation() throws Exception {
        CalculatorInput input = new CalculatorInput(10.0, 3.0, "mod");
        String json = objectMapper.writeValueAsString(input);

        mockMvc.perform(post("/api/calculator/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("1.0"));
    }
}