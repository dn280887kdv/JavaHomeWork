package com.pb.kuptsov.hw6;

import java.util.Objects;

public class Dog extends Animal{
    private String color;

    public Dog() {
    }

    public Dog(String color, String food, String location) {
        super(food, location);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void makeNoise() {
        System.out.println("Собака лает");
    }

    @Override
    public void eat() {
        System.out.println("Собака кушает " + super.getFood());
    }

    @Override
    public void sleep() {
        System.out.println("Собака спит " + super.getLocation());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return color.equals(dog.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "color='" + color + '\'' +
                '}';
    }
}
