package com.pb.kuptsov.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Auth auth = new Auth();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Регистрация на сайте");
        System.out.print("Введите логин: ");
        String login = scanner.next();
        System.out.print("Введите пароль: ");
        String pwd = scanner.next();
        System.out.print("Повторите пароль: ");
        String confPwd = scanner.next();
        boolean registration = false;

        while (registration == false){
            try {
                registration = auth.signUp(login, pwd, confPwd);
            } catch (WrongLoginException e) {
                e.printStackTrace();
                System.out.println("Ошибка ввода логина");
                System.out.print("Введите логин: ");
                login = scanner.next();
                System.out.print("Введите пароль: ");
                pwd = scanner.next();
                System.out.print("Повторите пароль: ");
                confPwd = scanner.next();
            } catch (WrongPasswordException e) {
                e.printStackTrace();
                System.out.println("Ошибка ввода пароля");
                System.out.print("Введите логин: ");
                login = scanner.next();
                System.out.print("Введите пароль: ");
                pwd = scanner.next();
                System.out.print("Повторите пароль: ");
                confPwd = scanner.next();
            }
        }

        System.out.println("Войдите на сайт");
        System.out.print("Введите логин: ");
        login = scanner.next();
        System.out.print("Введите пароль: ");
        pwd = scanner.next();
        try {
            System.out.println(auth.toString());
            auth.signIn(login, pwd);
        } catch (WrongLoginException e) {
            e.printStackTrace();
        }
    }
}
