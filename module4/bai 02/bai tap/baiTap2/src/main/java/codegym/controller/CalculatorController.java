package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping(value = "")
    public String show(){
        return "calculator/calculator";
    }
    @PostMapping(value = "/calculate")
    public String calculate(@RequestParam String operator, double second, double first, Model model){
        double result;
        switch (operator){
            case "+":
                result=first+second;
                model.addAttribute("result",result);
                break;
            case "-":
                result=first-second;
                model.addAttribute("result",result);
                break;
            case "*":
                result=first*second;
                model.addAttribute("result",result);
                break;
            case "/":
                if(second==0){
                    model.addAttribute("mess", "Can't divided by zero");
                }else {
                    result = first / second;
                    model.addAttribute("result", result);
                }
                break;
        }
        return "calculator/calculator";
    }
}
