package ru.at0m1cc.core;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Контроллер для отслежевания захода на Login
 * @author at0m1cc
 * @version 1.0
 * */
@Controller
public class LoginController {
    /**
     * Аннотация @GetMapping принимает в себя GET запросы по определённому URL
     * В данном случае мы возвращаем в ответе пользователю страницу Login.html
     * */
    @GetMapping("/login")
    public String loginForm() {
        return "Login";
    }
    /**
     * Аннотация @PostMapping вызывается когда мы нажимаем на форме Login.html кнопку Login
     * Класс loginForm проверяет верен ли пароль, если верен, он устанавливает новый атрибут для сессии - loginStatus с значением ok
     * Иначе вернёт нас на форму авторизации
     * */
    @PostMapping("/login")
    public String login(HttpSession session, @RequestParam("password") String password) {
        if(password.equals("password")) {
            session.setAttribute("loginStatus", "ok");
            return "redirect:/main";
        }
        else {
            return "redirect:/login";
        }
    }

}
