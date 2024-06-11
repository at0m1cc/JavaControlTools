package ru.at0m1cc.core;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Класс который нужен для приёма запросов на / а так же для приёма запросов на /main
 * */
@Controller
public class MainController {
    @GetMapping("/")
    public String defaultForm(HttpSession session){
       if(session.getAttribute("loginStatus") != null){
           return "redirect:/main";
       }
       else {
           return "redirect:/login";
       }
    }
    @GetMapping("/main")
    public String mainForm(HttpSession session, HttpServletRequest request) {
        if(session.getAttribute("loginStatus") != null){
            if(request.getParameter("logOut") != null){
                session.removeAttribute("loginStatus");
                return "redirect:/login";
            }
            if(request.getParameter("jC") != null){
                return "redirect:/JC";
            }
            return "MainForm";
        }
        else {
            return "redirect:/login";
        }
    }

}
