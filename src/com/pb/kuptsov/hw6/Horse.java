package com.pb.kuptsov.hw6;

import java.util.Objects;

public class Horse extends Animal{
    private String weight;

    public Horse(String food, String location, String weight) {
        super(food, location);
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return weight.equals(horse.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "weight='" + weight + '\'' +
                '}';
    }

    @Override
    public void makeNoise() {
        System.out.println("Лошадь издает ржание");
    }

    @Override
    public void eat() {
        System.out.println("Лошадь кушает " + super.getFood());
    }

    @Override
    public void sleep() {
        System.out.println("Лошадь спит " + super.getLocation());
    }
}
