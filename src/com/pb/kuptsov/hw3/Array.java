package com.pb.kuptsov.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Необходимо заполнить массив целыми числами, количество для заполнения = " + arr.length);

        for(int i = 0; i < arr.length; i++){
            System.out.print("Введите число для записи в массив: ");
            arr[i] = scan.nextInt();
        }

        int sum = 0;
        StringBuilder arrPositiv = new StringBuilder();
        System.out.println("\n");
        System.out.print("Введенный массив: ");

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
            sum += arr[i];
            if(arr[i] >= 0){
                arrPositiv.append(arr[i]).append(" ");
            }

        }
        System.out.println("Сумма всех элементов = " + sum);
        System.out.println("Положительные элементы массива: " + arrPositiv);

        for(int i = 0; i < arr.length; i++){
            for(int y = arr.length - 1; i < y; y--){
                if(arr[y] < arr[y-1]){
                    int temp = arr[y];
                    arr[y] = arr[y-1];
                    arr[y-1] = temp;
                }
            }
        }

        System.out.print("Сортированный массив: ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(" " + arr[i]);
        }
    }
}
