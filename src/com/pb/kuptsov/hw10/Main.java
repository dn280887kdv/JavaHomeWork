package com.pb.kuptsov.hw10;

public class Main {
    public static void main(String[] args) {
        NumBox<Float> numBox = new NumBox<>(3);
        numBox.setMas(0, 2.7F);
        numBox.setMas(1, 2.2F);
        numBox.setMas(2, 2.1F);

        System.out.println(numBox.max());
        System.out.println(numBox.average());
        System.out.println(numBox.sum());



        NumBox<Integer> integerNumBox = new NumBox<>(3);
        integerNumBox.setMas(0, 3);
        integerNumBox.setMas(1, 6);
        integerNumBox.setMas(2, 7);

        System.out.println(integerNumBox.max());
        System.out.println(integerNumBox.average());
        System.out.println(integerNumBox.sum());
    }
}
