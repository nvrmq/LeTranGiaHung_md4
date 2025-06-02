package com.example.ss3_mail.controller;

import com.example.ss3_mail.model.EmailSettings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailSettingController {
    private EmailSettings emailSettings = new EmailSettings();

    public void EmailSettingsController(){
        emailSettings.setLanguage("English");
        emailSettings.setPageSize(25);
        emailSettings.setSpamFilter(false);
        emailSettings.setSignature("Thor\nKing, Asgard");
    }
    @GetMapping("/")
    public String redirectToForm(){
        return "redirect:/emailSettings";
    }
    @GetMapping("/emailSettings")
    public String showForm(Model model){
        model.addAttribute("emailSettings", emailSettings);
        model.addAttribute("languages", new String[]{"English", "German", "Italian", "French", "Spanish"});
        model.addAttribute("pageSize", new int[]{5, 10, 15, 25, 50, 100});
        return "form";
    }
    @PostMapping("/settings")
    public String updateSetting(@ModelAttribute("emailSettings") EmailSettings emailSetting, Model model) {
        this.emailSettings = emailSetting;
        model.addAttribute("emailSettings", emailSetting);
        return "result";
    }
}
