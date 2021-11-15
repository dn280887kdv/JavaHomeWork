package com.pb.kuptsov.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes{

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Pants(String prise, String color, Size size, String name) {
        super(prise, color, size);
        this.name = name;
    }

    @Override
    public void dressMan() {
        System.out.println("Одевает мужчина: " + getName() + ", размер: " + getSize().getEuroSize() + "("+
                            getSize().getDescription() +"), цена: " + getPrise() + ", цвет: " + getColor());
    }

    @Override
    public void dressWomen() {
        System.out.println("Одевает женщина: " + getName() + ", размер: " + getSize().getEuroSize() + "("+
                            getSize().getDescription() +"), цена: " + getPrise() + ", цвет: " + getColor());
    }
}
