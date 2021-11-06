package com.pb.kuptsov.hw6;

import java.util.Objects;

public class Cat extends Animal {
    private String name;

    public Cat() {
    }

    public Cat(String name, String food, String location) {
        super(food, location);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void makeNoise() {
        System.out.println("Кот мяукает");
    }

    @Override
    public void eat() {
        System.out.println("Кот кушает "  + super.getFood());
    }

    @Override
    public void sleep() {
        System.out.println("Кот спит "+ super.getLocation());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return name.equals(cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
