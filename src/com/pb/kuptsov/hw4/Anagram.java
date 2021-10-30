package com.pb.kuptsov.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public String check(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите первую строку: ");
        String s1 = scan.nextLine();
        System.out.print("Введите вторую строку: ");
        String s2 = scan.nextLine();

        char[] str1 = s1.toLowerCase().toCharArray();
        char[] str2 = s2.toLowerCase().toCharArray();

        char[] temp1 = convert(str1);
        char[] temp2 = convert(str2);

        Arrays.sort(temp1);
        Arrays.sort(temp2);

        String s3 = new String(temp1).trim().replaceAll("\\s+","");
        String s4 = new String(temp2).trim().replaceAll("\\s+","");

        for (int i = 0; i < temp1.length; i++){
            System.out.print(temp1[i]);
        }
        System.out.println("\n");

        for (int i = 0; i < temp2.length; i++){
            System.out.print(temp2[i]);
        }
        System.out.println("\n");

        System.out.println(Arrays.equals(temp1, temp2));

        if(s3.equals(s4)){
            return "это анаграмма!";
        } else {
            return "\nvse propalo";
        }
    }

    public char[] convert(char[] ch){
        char[] temp = new char[ch.length];
        for(int i = 0; i < ch.length; i++){
            if(Character.isLetter(ch[i])){
                temp[i] += ch[i];
            }
        }
        return temp;
    }
}
