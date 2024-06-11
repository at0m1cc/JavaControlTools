package ru.at0m1cc.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String defaultForm(){
        return "Login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "Login";
    }

    @GetMapping("/main")
    public String mainForm() {
        return "MainForm";
    }

    @GetMapping("/JavaControl")
    public String javaControlForm() {
        return "JC";
    }

}
