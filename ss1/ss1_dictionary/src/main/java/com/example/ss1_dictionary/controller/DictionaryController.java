package com.example.ss1_dictionary.controller;

import com.example.ss1_dictionary.services.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;
    @GetMapping("/")
    public String showHome() {
        return "index";
    }
    @PostMapping("/translate")
    public String translate(@RequestParam("word") String word, Model model) {
        String result = dictionaryService.translate(word);
        model.addAttribute("result", result);
        model.addAttribute("word", word);
        return "result";
    }
}
