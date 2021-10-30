package com.pb.kuptsov.hw4;

import java.util.Scanner;

public class CapitalLetter {

    public String upperCaseConvert(){

        System.out.println("Конвертер строк");
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String link = scan.nextLine();
        System.out.println("Введена строка: "+link);
        String out = link.substring(0, 1).toUpperCase();

        for(int i = 1; i < link.length(); i++){
            if(" ".equals(link.substring(i-1, i))){
                out += link.substring(i, i+1).toUpperCase();
            } else {
                out += link.substring(i, i+1);
            }
        }

        return out;
    }
}
