package com.pb.kuptsov.hw6;

public class Veterinarian {

    public void treatAnimal(Animal animal){
        System.out.println("Кушет: " + animal.getFood() + ", находится: " + animal.getLocation());
    }
}
