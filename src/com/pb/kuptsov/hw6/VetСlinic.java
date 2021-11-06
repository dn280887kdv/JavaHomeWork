package com.pb.kuptsov.hw6;

import java.lang.reflect.Constructor;

public class VetСlinic {
    public static void main(String[] args) throws Exception {

        Cat cat = new Cat("Барсик","рыба","дома");
        Dog dog = new Dog("black", "мясо", "на улице");
        Horse horse = new Horse("сено", "в стойле", "тонна");

        Animal[] animals = {cat, dog, horse};

        Class clazz = Class.forName("com.pb.kuptsov.hw6.Veterinarian");
        Constructor constructor = clazz.getConstructor();
        Object obj = constructor.newInstance();

        for(Animal animal: animals){
            if(obj instanceof Veterinarian){
                ((Veterinarian) obj).treatAnimal(animal);
            }
        }



    }
}
