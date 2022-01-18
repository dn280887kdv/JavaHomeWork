package com.pb.kuptsov.hw15;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JTextArea;


public class MainchatThread extends Thread {
    private OutputStream out;
    private BufferedReader brd;
    private Socket socket;
    private int port;
    private String ip;
    private JTextArea jta;


    public MainchatThread(String ip, int port, JTextArea jta) {
        this.jta = jta;
        this.ip = ip;
        this.port = port;

    }

    public boolean runing() {
        try {
            Socket socket = new Socket(this.ip, this.port);
            System.out.println("Подключено");
            InputStream ins = socket.getInputStream();
            out = socket.getOutputStream();
            brd = new BufferedReader(new InputStreamReader(ins));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void readMsg() {
        try {
            String input = brd.readLine();
            while (!"bye".equals(input)) {
                System.out.println("Сервер" + input);
                jta.append(input + "\r\n");
                System.out.println("Привет");
                input = brd.readLine();
            }
        } catch (Exception ef) {
        }
    }

    public void sendMsg(String msg) {
        try {
            msg += "\r\n";
            this.out.write(msg.getBytes());
            this.out.flush();
        } catch (Exception ef) {
        }
    }

    public void run() {
        readMsg();
    }
}
