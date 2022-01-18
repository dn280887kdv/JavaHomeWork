package com.pb.kuptsov.hw15;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainServer {


    public void ShowUI() {
        JFrame jf = new JFrame();
        jf.setTitle("Многопользовательский чат");
                jf.setSize(600, 500);
        jf.setLayout(new FlowLayout());
        jf.setDefaultCloseOperation(3);
        JButton jb = new JButton("Создать");
        final JTextField jte = new JTextField(4);
        JButton jb1 = new JButton("Отправить");
        final JTextField jte1 = new JTextField(30);
        final JTextArea jta = new JTextArea(20, 50);
        jf.add(jb);
        jf.add(jte);
        jf.add(jb1);
        jf.add(jte1);
        jf.add(jta);

        ActionListener al = (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("Укажите порт подключения")) {
                    String ss = jte.getText();
                    int i = Integer.parseInt(ss);
                    Chatserver cs = new Chatserver(i, jta);
                    cs.start();
                }
                if (s.equals("Отправить")) {
                    String msg = jte1.getText();
                    ChatTools.castMsg(msg);
                    jta.append("Сервер говорит:" + msg + "\r\n");
                    jte1.setText("");
                }
            }
        });
        jb.addActionListener(al);
        jb1.addActionListener(al);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        MainServer ms = new MainServer();
        ms.ShowUI();
    }
}
