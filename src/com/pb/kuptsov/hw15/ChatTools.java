package com.pb.kuptsov.hw15;

import java.util.ArrayList;
import java.util.List;


public class ChatTools {

    private static List<ServerThread> list = new ArrayList();

    private ChatTools() {
    }

    public static List<ServerThread> getAllthread() {
        return list;
    }

    public static void add(ServerThread st) {
        castMsg("Новый пользователь подключился к чату, количество онлайн: " + (list.size() + 1));
        list.add(st);
    }

    public static void castMsg(String str) {
        for (int i = 0; i < list.size(); i++) {
            ServerThread st = list.get(i);
            st.sendMs(st.getName() + "сказал:" + str);
        }
    }
}
