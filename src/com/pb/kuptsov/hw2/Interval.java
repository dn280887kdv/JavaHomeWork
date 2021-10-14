package com.pb.kuptsov.hw2;

import java.util.Scanner;

public class Interval {
    public int calc(){
        Scanner insert = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = insert.nextInt();
        int result = 0;
        if(number >= 0 && number <= 14){
            System.out.println("Введенное число входит в промежуток [0-14]");
            result = number;
        } else if(number >= 15 && number <= 35){
            System.out.println("Введенное число входит в промежуток [15 - 35]");
            result = number;
        } else if(number >= 36 && number <= 50){
            System.out.println("Введенное число входит в промежуток [36 - 50]");
            result = number;
        } else if(number >= 51 && number <= 100){
            System.out.println("Введенное число входит в промежуток [51 - 100]");
            result = number;
        } else {
            System.out.println("Введенное число не входит ни в один из промежутков");
        }
        return result;
    }
}
