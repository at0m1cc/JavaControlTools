package ru.at0m1cc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLogic {
    private final int port;
    private final Commands command;
    public ServerLogic(int port, Commands command) {
        this.port = port;
        this.command = command;
    }
    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = reader.readLine();
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
            throw new RuntimeException(e);
        }
    }
}
