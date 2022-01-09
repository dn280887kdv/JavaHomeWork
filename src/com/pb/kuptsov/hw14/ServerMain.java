package com.pb.kuptsov.hw14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class ServerMain {

//    private static Socket clientSocket;
//    private static ServerSocket server;
//    private static BufferedReader in;
//    private static BufferedWriter out;
//
//    public static void main(String[] args) {
//        try {
//            try {
//                server = new ServerSocket(9543);
//                System.out.println("Сервер запущен");
//                clientSocket = server.accept();
//                try {
//                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//                    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//                    String date = dateFormat.format(new Date());
//
//                    String text = in.readLine();
//                    System.out.println(text);
//                    out.write(date + "Сервер : " + text + "\n");
//                    out.flush();
//
//                } finally {
//                    clientSocket.close();
//                    in.close();
//                    out.close();
//                }
//            } finally {
//                System.out.println("Сервер остановлен");
//                server.close();
//            }
//        } catch (IOException e) {
//            System.err.println(e);
//        }
//    }

        public static final int PORT = 8080;
        public static LinkedList<Server> serverList = new LinkedList<>();

        public static void main(String[] args) throws IOException {
            ServerSocket server = new ServerSocket(PORT);
            try {
                while (true) {
                    Socket socket = server.accept();
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
