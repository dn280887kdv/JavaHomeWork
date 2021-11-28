package com.pb.kuptsov.hw10;

public class Main {
    public static void main(String[] args) {
        NumBox<Float> numBox = new NumBox<>(3);
        System.out.println(numBox.max());
    }
}
