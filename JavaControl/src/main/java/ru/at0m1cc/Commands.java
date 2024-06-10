package ru.at0m1cc;

import org.springframework.stereotype.Component;
import java.io.IOException;
/**
 * Класс с набором команд с использованием аннотаций Spring framework
 * @author at0m1cc
 * @version 1.0
 * */
@Component("command")
public class Commands {
    /**Метод который отправляет shell скрипт для перезагрузки ПК*/
    public void reboot(){
        try {
            Runtime.getRuntime().exec("shutdown /r /t 0");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**Метод который отправляет shell скрипт для выключения ПК*/
    public void powerOff(){
        try {
            Runtime.getRuntime().exec("shutdown /s /t 0");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**Метод который отправляет shell скрипт для выхода из системы*/
    public void logOut(){
        try {
            Runtime.getRuntime().exec("shutdown /l");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
