package ru.at0m1cc;

import java.io.IOException;

public class Commands {
    public void reboot(){
        try {
            Runtime.getRuntime().exec("shutdown /r /t 0");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void powerOff(){
        try {
            Runtime.getRuntime().exec("shutdown /s /t 0");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void logOut(){
        try {
            Runtime.getRuntime().exec("shutdown /l");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
