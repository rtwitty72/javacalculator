package com.example.javacalculator.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.function.DoubleToIntFunction;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(@RequestParam(value = "operand1", required = false) String operand1,
                        @RequestParam(value = "operand2", required = false) String operand2,
                        @RequestParam(value = "operator", required = false) String operator,
                        Model model) {

        double answer = 0;
            switch (operator) {
                case "+":
                    answer = Double.parseDouble(operand1) + Double.parseDouble(operand2);
                    break;
                case "-":
                    answer = Double.parseDouble(operand1) - Double.parseDouble(operand2);
                    break;
                case "*":
                    answer = Double.parseDouble(operand1) * Double.parseDouble(operand2);
                    break;
                case "/":
                    answer = Double.parseDouble(operand1) / Double.parseDouble(operand2);
                    break;
                default:
                    break;
            }

        model.addAttribute("calculator", operand1 + " " + operator + " " + operand2 + " " + answer);
        return "index";
    }
}


