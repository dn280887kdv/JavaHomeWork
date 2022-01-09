package com.pb.kuptsov.hw14;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class Client {
//    private static final int port = 9543;
//    public Client() {
//    }
//
//    public void connectToServer(){
//        Socket socket = null;
//        try {
//            socket = new Socket("localhost", port);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Запущен клиент");
//
//        try {
//            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            BufferedReader readerFromConsole = new BufferedReader(new InputStreamReader(System.in));
//
//            while (readerFromConsole.readLine() != null){
//                System.out.println("В консоль введено: " + readerFromConsole.readLine());
//                writer.println(readerFromConsole.readLine());
//                System.out.println(reader.readLine());
//            }
//            writer.close();
//            reader.close();
//            readerFromConsole.close();
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        Client client = new Client();
//        client.connectToServer();
//    }
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Клиент стартовал");
        String serverIp = "127.0.0.1";
        int serverPort = 9543;
        System.out.println("Соединяемся с сервером " + serverIp + ":" + serverPort);

        Socket server = new Socket(serverIp, serverPort);
        BufferedReader inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter outServer = new PrintWriter(server.getOutputStream(), true);
        BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

        String dataFromUser, dataFromServer;

        // Основной цикл отправки сообщений серверу
        while ((dataFromUser = inConsole.readLine()) != null) {
            outServer.println(dataFromUser);
            dataFromServer = inServer.readLine();
            System.out.println(dataFromServer);
            if ("exit".equalsIgnoreCase(dataFromUser)) {
                break;
            }
        }
        outServer.close();
        inServer.close();
        outServer.close();
        server.close();
    }
}
