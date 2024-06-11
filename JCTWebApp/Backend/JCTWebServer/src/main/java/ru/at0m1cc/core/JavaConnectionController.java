package ru.at0m1cc.core;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JavaConnectionController {
    @GetMapping("/JC")
    public String javaConnectionForm(HttpSession session) {
        if(session.getAttribute("loginStatus") != null) {
            return "JC";
        }
        else{
            return "redirect:/login";
        }
    }

    @PostMapping("/JC")
    public String javaConnectionFunc(HttpSession session, HttpServletRequest request) {
        if(request.getParameter("back") != null) {
            return "redirect:/main";
        } else if (request.getParameter("logOut") != null) {
            session.removeAttribute("loginStatus");
            return "redirect:/login";
        }
        else {
            return "JC";
        }
    }
}
