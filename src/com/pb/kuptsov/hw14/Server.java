package com.pb.kuptsov.hw14;

import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class Server extends Thread {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public Server(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }
    @Override
    public void run() {
        String text;
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String date = dateFormat.format(new Date());
        try {
            while (true) {
                text = in.readLine();
                if(text.equals("stop")) {
                    break;                }
                for (Server server : ServerMain.serverList) {
                    out.write(date + "Сообщение: " + text + "\n");
                    out.flush();
                }
            }

        } catch (IOException e) {
        }
    }

}
