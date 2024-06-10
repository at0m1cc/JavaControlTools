package ru.at0m1cc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Класс сервера c с использованием аннотаций и внедрения зависимотей с помощью Spring framework
 * @author at0m1cc
 * @version 1.0
 * */
@Component("serverLogic")
public class ServerLogic {
    /**Поле порта для подключения*/
    private final int port;
    /**Поле передоваемого набора команд*/
    private final Commands command;
    /**
     * Конструктор - создания нового обьекта с опроделёнными параметрами
     * @param port Порт для подклбчения к данному компьютеру (По умолчанию 5556)
     * @param command Основные команды Windows
     * */
    @Autowired
    public ServerLogic(@Value("5556") int port, Commands command) {
        this.port = port;
        this.command = command;
    }
    /**
     * Метод для запуска сервера
     * */
    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port); // Создаём серверсокет
            while (true) {
                Socket socket = serverSocket.accept(); // Ждём подключения к нашему сокету
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Получение информации с клиента
                String request = reader.readLine();//Передаём всю информацию с клиента
                //Проверка команд
                if (request.equals("reboot")) {
                    command.reboot();
                }
                else if (request.equals("poweroff")) {
                    command.powerOff();
                }
                else if (request.equals("logOut")) {
                    command.logOut();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e); //Если что либо пошло не по плану
        }
    }

}
