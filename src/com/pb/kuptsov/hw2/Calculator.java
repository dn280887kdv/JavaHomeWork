package com.pb.kuptsov.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner insert = new Scanner(System.in);
        System.out.println("Калькулятор или число из мнтервала?");
        System.out.println("1. Калькулятор");
        System.out.println("2. Посиск число в интервале");
        System.out.print("Ваш выбор: ");

        int res = insert.nextInt();
        if(res == 1){
            Calculator calc = new Calculator();
            System.out.print("Результат: " + calc.math());
        } else if(res == 2){
            Interval interv = new Interval();
            System.out.println("Результат: " + interv.calc());
        } else {
            System.out.println("Нет такой операции!");
        }
    }

    public int math(){
        Scanner insert = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int operand1 = insert.nextInt();
        System.out.print("Введите второе число: ");
        int operand2 = insert.nextInt();
        System.out.print("Укажите желаемую операцию: ");
        String sign = insert.next();
        int result = 0;

            switch(sign){
                case "+": result = operand1 + operand2;
                    break;
                case "-": result = operand1 - operand2;
                    break;
                case "*": result = operand1 * operand2;
                    break;
                case "/": if(operand2 == 0){
                             System.out.println("На ноль дельть нельзя!");
                          } else {
                             result = operand1 / operand2;
                          }
                break;
            }
        return result;
    }

}
