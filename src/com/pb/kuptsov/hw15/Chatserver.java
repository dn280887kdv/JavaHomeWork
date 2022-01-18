package com.pb.kuptsov.hw15;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

public class Chatserver extends Thread {
    private boolean running = true;
    private int port;
    private JTextArea jta;

    public Chatserver(int port, JTextArea jta) {
        this.port = port;
        this.jta = jta;
    }

    public void run() {
        setUpServer(port);
    }

    public void setUpServer(int port) {
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Сервер успешно создан");
            while (running) {
                Socket client = ss.accept();
                System.out.println("Добро пожаловать на мой сервер");
                ServerThread st = new ServerThread(client, jta);
                st.start();
                ChatTools.add(st);
            }
        } catch (Exception ef) {
            ef.printStackTrace();
        }
    }
}

