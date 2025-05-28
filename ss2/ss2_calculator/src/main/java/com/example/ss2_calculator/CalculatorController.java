package com.example.ss2_calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String showPage(){
        return "index";
    }
    @PostMapping("/calculate")
    public String calculate(@RequestParam double var1, @RequestParam double var2, @RequestParam String operator, Model model){
        double result = 0;
        String message = "";
        switch (operator){
            case "+":
                result = var1 + var2;
                message = "The sum of " + var1 + " and " + var2 + " is " + result;
                break;
            case "-":
                result = var1 - var2;
                message = "The subtraction of " + var1 + " and " + var2 + " is " + result;
                break;
            case "x":
                result = var1 * var2;
                message = "The multiplication of " + var1 + " and " + var2 + " is " + result;
                break;
            case "/":
                if (var2 == 0) {
                    message = "Invalid operation";
                    model.addAttribute("message", message);
                    return "index";
                }
                result = var1 / var2;
                message = "The division of " + var1 + " and " + var2 + " is " + result;
                break;
        }
        model.addAttribute("message", message);
        model.addAttribute("result", result);
        return "index";
    }
}
