package ru.at0m1cc.core;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SettingsController {

    @GetMapping("/Settings")
    public String settingsForm(HttpSession session, HttpServletRequest request) {

        if(session.getAttribute("loginStatus") != null) {
            if(request.getParameter("logOut") != null) {
                session.removeAttribute("loginStatus");
                return "redirect:/login";
            }
            if(request.getParameter("back") != null) {
                return "redirect:/main";
            }
            return "Settings";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/Settings")
    public String settingsPost(@RequestParam("password") String password, HttpSession session) {
        if(session.getAttribute("loginStatus") != null) {
            LoginController.setPassword(password);
            return "Settings";
        }
        else {
            return "redirect:/login";
        }
    }

}
