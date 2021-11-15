package com.pb.kuptsov.hw7;

public class Skirt extends Clothes implements WomenClothes{

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Skirt(String prise, String color, Size size, String name) {
        super(prise, color, size);
        this.name = name;
    }

    @Override
    public void dressWomen() {
        System.out.println("Одевает женщина: " + getName() + ", размер: " + getSize().getEuroSize() + "("+
                getSize().getDescription() +"), цена: " + getPrise() + ", цвет: " + getColor());
    }
}
