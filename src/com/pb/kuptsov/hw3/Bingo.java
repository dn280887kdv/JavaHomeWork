package com.pb.kuptsov.hw3;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Random;
import java.util.Scanner;

public class Bingo {

    public static void main(String[] args) {
        Random rand = new Random();
        int randomNum = rand.nextInt(101);
        System.out.println(randomNum);

        Scanner scan = new Scanner(System.in);
        int counter = 0;
        while (true) {
            System.out.print("Введите число: ");
            int i = scan.nextInt();
            counter++;
            if (i == randomNum) {
                System.out.println("Поздравляем! Вы угадали, загаданное число = " + i);
                System.out.println("Количество использованных попыток: " + counter);
                return;
            } else if (randomNum > i) {
                System.out.println("Вы не угадали, попробуйте еще раз. Загаданное число больше " + i);
                System.out.print("\n");
            } else {
                System.out.println("Вы не угадали, попробуйте еще раз. Загаданное число меньше " + i);
                System.out.print("\n");
            }

            System.out.println("Желаете попробовать еще раз?");
            System.out.println("1. Да");
            System.out.println("2. Нет");
            System.out.print("Выберите номер пункта: ");

            int y = scan.nextInt();
            if (y == 1) {
                System.out.println("\n");
            } else if (y == 2) {
                System.out.println("Количество использованных попыток: " + counter);
                System.out.println("Приходите еще!");
                return;
            } else {
                System.out.println("Введены неверные данные. Программа завершена автоматически");
                System.out.println("Количество использованных попыток: " + counter);
                return;
            }

        }
    }


}
