package com.pb.kuptsov.hw4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CapitalLetter cap = new CapitalLetter();
        Anagram an = new Anagram();
        System.out.println(an.check());

        while(true){
            System.out.println("Результат работы программы: " + cap.upperCaseConvert());
            System.out.println("Желаете еще ввести?\n1.Da\n2.Net");
            Scanner scan = new Scanner(System.in);
            if(scan.nextInt() == 2){
                return;
            } else {
                continue;
            }
        }


    }
}
