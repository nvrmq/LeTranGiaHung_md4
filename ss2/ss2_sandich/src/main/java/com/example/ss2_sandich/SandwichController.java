package com.example.ss2_sandich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String showPage(){
        return "index";
    }
    @PostMapping("/submit")
    public String submit(@RequestParam(value = "condiment", required = false) String[] condiment, Model model){
        List<String> submitted;
        if(condiment != null && condiment.length > 0){
            submitted = Arrays.asList(condiment);
        } else {
            submitted = Arrays.asList(new String[] {});
        }
        model.addAttribute("submitted", submitted);
        return "result";
    }
}
