package com.pb.kuptsov.hw15;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ServerMain {
        public static final int PORT = 9543;
        public static LinkedList<Server> serverList = new LinkedList<>();

        public static void main(String[] args) throws IOException {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");
            try {
                while (true) {
                    Socket socket = server.accept();
                    System.out.println("Клиент подключился");
                    try {
                        serverList.add(new Server(socket));
                    } catch (IOException e) {
                        socket.close();
                    }
                }
            } finally {
                server.close();
            }
        }
    }
