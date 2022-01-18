package com.pb.kuptsov.hw15;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JTextArea;

public class ServerThread extends Thread {
    private Socket client;
    private OutputStream out;
    private JTextArea jta;

    public ServerThread(Socket client, JTextArea jta) {
        this.client = client;
        this.jta = jta;
    }

    public void run() {
        processChat(this.client);
    }


    public void sendMs(String msg) {
        System.out.println("Отправлено: " + msg);
        try {
            msg += "\r\n";
            out.write(msg.getBytes());
            out.flush();
        } catch (Exception ef) {
        }
    }

    public void processChat(Socket client) {
        try {
            InputStream ins = client.getInputStream();
            out = client.getOutputStream();
            out.write(("Добро пожаловать на сервер \r\n").getBytes());
            BufferedReader brd = new BufferedReader(new InputStreamReader(ins));
            String input = brd.readLine();
            while (!"bye".equals(input)) {
                System.out.println("Сервер получен" + input);
                jta.append("Клиент говорит:" + input + "\r\n");
                ChatTools.castMsg(input);
                input = brd.readLine();
            }
        } catch (Exception ef) {
            ef.printStackTrace();
        }
    }
}